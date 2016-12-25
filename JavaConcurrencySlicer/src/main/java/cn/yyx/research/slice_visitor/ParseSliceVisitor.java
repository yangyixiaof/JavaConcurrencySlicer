package cn.yyx.research.slice_visitor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Statement;

import cn.yyx.research.java_slicer.TestCase;
import cn.yyx.research.slice_visitor.util.SlicedCodeGenerator;

public class ParseSliceVisitor extends ASTVisitor {
	
	private int count = 0;
	
	private StringBuilder import_content = new StringBuilder("");
	private List<TestCase> test_cases = new LinkedList<TestCase>();
	
	private String classname = null;
	
	public ParseSliceVisitor(String classname) {
		this.classname = classname;
	}
	
	@Override
	public boolean visit(ImportDeclaration node) {
		String idstr = node.getName().toString();
		// System.out.println("ImportDeclaration:" + idstr);
		if (!idstr.startsWith("org.evosuite") && !idstr.startsWith("org.junit"))
		{
			import_content.append(node.toString() + "\n");
		}
		return false;
	}
	
	@Override
	public boolean visit(MethodDeclaration node) {
		count++;
		
		LastNMethodsVisitor lnmv = new LastNMethodsVisitor(2, classname);
		node.accept(lnmv);
		List<Statement> lastnms = lnmv.GetLastNMethods();
		StatementOrderVisitor sov = new StatementOrderVisitor();
		node.accept(sov);
		Map<Statement, Integer> sorder = sov.GetStatementsOrder();
		DepenencyVisitor dv = new DepenencyVisitor(lastnms, sorder, classname);
		node.accept(dv);
		List<String> test_contents = dv.GenerateParallelTestCases();
		String LINETAB = SlicedCodeGenerator.ONE_LINETAB;
		StringBuilder sb = new StringBuilder();
		sb.append("package " + SlicedCodeGenerator.PACKAGE + ";\n\n");
		if (import_content.length() > 0)
		{
			sb.append(import_content.toString() + "\n\n");
		}
		sb.append("public class " + "TestCase" + count + " {\n\n");
		sb.append(LINETAB + "public static main(String[] args) throws Exception {\n");
		LINETAB += SlicedCodeGenerator.ONE_LINETAB;
		Iterator<String> titr = test_contents.iterator();
		while (titr.hasNext())
		{
			String one_content = titr.next();
			sb.append(LINETAB + one_content);
		}
		LINETAB = LINETAB.substring(SlicedCodeGenerator.ONE_LINETAB.length());
		sb.append(LINETAB + "}\n\n");
		sb.append("}\n");
		
		test_cases.add(new TestCase("TestCase" + count + ".java", sb.toString()));
		return false;
	}
	
	public List<TestCase> GetTestCases()
	{
		return test_cases;
	}
	
}
