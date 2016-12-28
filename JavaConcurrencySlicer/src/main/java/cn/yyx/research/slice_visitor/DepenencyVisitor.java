package cn.yyx.research.slice_visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

import cn.yyx.research.slice_visitor.util.SlicedCodeGenerator;
import cn.yyx.research.slice_visitor.util.AvoidStatement;
import cn.yyx.research.slice_visitor.util.Dependency;

public class DepenencyVisitor extends BaseVisitor {
	
	int concerned = 0;
	final List<IBinding> concerned_bindings;
	final List<Statement> concerned_statements;
	final Map<Statement, Integer> statements_order;
	Map<Statement, Dependency> concerned_dependencies = new HashMap<Statement, Dependency>();
	Map<IBinding, Dependency> ibindings_dependencies = new HashMap<IBinding, Dependency>();
	
	boolean concern_signal = false;
	Set<IBinding> concern_bindings = new HashSet<IBinding>();
	boolean signal = false;
	Statement cared_statement = null;
	
	public DepenencyVisitor(List<IBinding> cbinds, List<Statement> lastnms, Map<Statement, Integer> sorder, String classname) {
		super(classname);
		statements_order = sorder;
		Dependency dep = new Dependency(lastnms);
		concerned_statements = dep.OrderedStatements(statements_order);
		concerned_bindings = cbinds;
		// debugging.
		// System.err.println("test:" + concerned_statements);
	}
	
	public List<String> GenerateParallelTestCases()
	{
		List<String> concurrency_test_code = new LinkedList<String>();
		ArrayList<Statement> statement_array = new ArrayList<Statement>();
		ArrayList<Dependency> dependency_array = new ArrayList<Dependency>();
		
		Dependency commondep = new Dependency();
		
		Set<Statement> keys = concerned_dependencies.keySet();
		Iterator<Statement> kitr1 = keys.iterator();
		while (kitr1.hasNext())
		{
			Statement stat1 = kitr1.next();
			Dependency deped1 = concerned_dependencies.get(stat1);
			Iterator<Statement> kitr2 = keys.iterator();
			while (kitr2.hasNext())
			{
				Statement stat2 = kitr2.next();
				if (stat1 == stat2) { break; }
			}
			while (kitr2.hasNext())
			{
				Statement stat2 = kitr2.next();
				Dependency deped2 = concerned_dependencies.get(stat2);
				Dependency deped1_clone = new Dependency(deped1);
				Dependency deped2_clone = new Dependency(deped2);
				deped1_clone.Intersection(deped2_clone);
				commondep.Union(deped1_clone);
			}
			
			statement_array.add(stat1);
			dependency_array.add(deped1);
		}
		
		Set<IBinding> final_binds = new HashSet<IBinding>();
		
		int threadcount = 0;
		for (int i=0;i<statement_array.size();i++)
		{
			threadcount++;
			Statement stat = statement_array.get(i);
			Dependency depd = dependency_array.get(i);
			Dependency depd_clone = new Dependency(depd);
			depd_clone.AddStatement(stat);
			depd_clone.Subtraction(commondep);
			
			Iterator<Statement> ditr = depd_clone.Iterator();
			while (ditr.hasNext())
			{
				Statement stmt = ditr.next();
				AllBindingVisitor abv = new AllBindingVisitor();
				stmt.accept(abv);
				final_binds.addAll(abv.GetAllBindings());
			}
			
			String tab = SlicedCodeGenerator.ONE_LINETAB;
			concurrency_test_code.add("Thread t" + threadcount + " = new Thread(new Runnable() {\n");
			concurrency_test_code.add(tab + "@Override\n");
			concurrency_test_code.add(tab + "public void run() {\n");
			
			tab += SlicedCodeGenerator.ONE_LINETAB;
			concurrency_test_code.add(tab + "try {\n");
			
			tab += SlicedCodeGenerator.ONE_LINETAB;
			SlicedCodeGenerator.AppendStatements(concurrency_test_code, depd_clone.OrderedStatements(statements_order), tab);
			// SlicedCodeGenerator.AppendOneStatement(concurrency_test_code, stat, tab);
			tab = tab.substring(SlicedCodeGenerator.ONE_LINETAB.length());
			
			concurrency_test_code.add(tab + "} catch (Exception e) {\n");
			concurrency_test_code.add(tab + "}\n");
			tab = tab.substring(SlicedCodeGenerator.ONE_LINETAB.length());
			
			concurrency_test_code.add(tab + "}\n");
			concurrency_test_code.add("});\n");
		}
		for (int i=0;i<threadcount;i++)
		{
			concurrency_test_code.add("t" + (i+1) + ".start();\n");
		}
		for (int i=0;i<threadcount;i++)
		{
			concurrency_test_code.add("t" + (i+1) + ".join();\n");
		}
		
		List<String> common_teset_code = new LinkedList<String>();
		List<Statement> common_statements = commondep.OrderedStatements(statements_order);
		SlicedCodeGenerator.AppendStatementsWithFinal(common_teset_code, common_statements, final_binds, "");
		
		List<String> test_code = new LinkedList<String>();
		test_code.addAll(common_teset_code);
		test_code.addAll(concurrency_test_code);
		
		return test_code;
	}
	
	@Override
	public boolean visit(SimpleName node) {
		IBinding ib = node.resolveBinding();
		if (ib != null) {
			Dependency depd = ibindings_dependencies.get(ib);
			if (depd == null) {
				// System.err.println("Warning no binding:" + node + "; must check it is not a variable.");
			} else {
				if (concern_signal) {
					Iterator<IBinding> citr = concern_bindings.iterator();
					while (citr.hasNext())
					{
						IBinding cib = citr.next();
						Dependency dd = ibindings_dependencies.get(cib);
						if (dd != null)
						{
							dd.Union(depd);
						}
					}
				}
				if (signal) {
					Dependency dd = concerned_dependencies.get(cared_statement);
					dd.Union(depd);
				} else {
					depd.AddStatement(FindMostCloseAncestorStatement(node));
				}
			}
		} else {
			// System.err.println("Warning unresolved binding:" + node + "; must check it is not a variable.");
		}
		return super.visit(node);
	}
	
	@Override
	public boolean preVisit2(ASTNode node) {
		if (node instanceof Statement && !(node instanceof TryStatement))
		{
			if (AvoidStatement.IsAvoided(node))
			{
				return false;
			}
			ConcernedBindingVisitor cbv = new ConcernedBindingVisitor(concerned_bindings);
			node.accept(cbv);
			if (cbv.IsConcernedStatement())
			{
				concern_signal = true;
				concern_bindings = cbv.GetConcernedBindings();
			}
			
			// original logic.
			int idx = concerned_statements.indexOf(node);
			if (idx < 0) {
				// Not found. Do nothing.
			} else {
				if (idx < concerned) {
					return false;
				} else {
					if (idx == concerned) {
						signal = true;
						cared_statement = (Statement) node;
						concerned_dependencies.put(cared_statement, new Dependency());
					} else {
						System.err.println("What the fuck? skip some concerned statements?");
						System.exit(1);
					}
				}
			}
		}
		return super.preVisit2(node);
	}
	
	@Override
	public void postVisit(ASTNode node) {
		if (node instanceof Statement && !(node instanceof TryStatement))
		{
			if (AvoidStatement.IsAvoided(node))
			{
				return;
			}
			ConcernedBindingVisitor cbv = new ConcernedBindingVisitor(concerned_bindings);
			node.accept(cbv);
			if (cbv.IsConcernedStatement())
			{
				concern_signal = false;
				concern_bindings.clear();
			}
			
			// original logic.
			int idx = concerned_statements.indexOf(node);
			if (idx == concerned) {
				signal = false;
				concerned++;
				cared_statement = null;
			}
		}
		super.postVisit(node);
	}
	
	@Override
	public boolean visit(VariableDeclarationStatement node) {	
		@SuppressWarnings("unchecked")
		List<VariableDeclarationFragment> frags = node.fragments();
		Iterator<VariableDeclarationFragment> fitr = frags.iterator();
		while (fitr.hasNext())
		{
			VariableDeclarationFragment vdf = fitr.next();
			IBinding ib = vdf.getName().resolveBinding();
			if (ib == null)
			{
				System.err.println("What the fuck! IBinding is null?" + " Wrong code is:" + node);
				System.exit(1);
			}
			ibindings_dependencies.put(ib, new Dependency());
		}
		return super.visit(node);
	}	
	
}
