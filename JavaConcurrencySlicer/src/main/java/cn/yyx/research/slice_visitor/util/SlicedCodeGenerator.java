package cn.yyx.research.slice_visitor.util;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.Statement;

import cn.yyx.research.slice_visitor.ConcernedBindingVisitor;

public class SlicedCodeGenerator {
	
	public static final String ONE_LINETAB = "    ";
	public static final String PACKAGE = "yyx_concurrency";
	
	public static void AppendOneStatement(List<String> code, Statement statement, String tab)
	{
		code.add(tab + statement.toString());
	}
	
	public static void AppendStatements(List<String> code, List<Statement> statement_list, String tab)
	{
		Iterator<Statement> slitr = statement_list.iterator();
		while (slitr.hasNext())
		{
			Statement stat = slitr.next();
			code.add(tab + stat.toString());
		}
	}
	
	public static void AppendStatementsWithFinal(List<String> code, List<Statement> statement_list, Set<IBinding> final_binds, String tab)
	{
		Iterator<Statement> slitr = statement_list.iterator();
		while (slitr.hasNext())
		{
			Statement stat = slitr.next();
			ConcernedBindingVisitor cbv = new ConcernedBindingVisitor(final_binds);
			stat.accept(cbv);
			if (cbv.IsConcernedStatement()) {
				code.add(tab + "final " + stat.toString());
			} else {
				code.add(tab + stat.toString());
			}
		}
	}
	
}
