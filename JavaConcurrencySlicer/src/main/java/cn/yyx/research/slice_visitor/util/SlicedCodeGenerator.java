package cn.yyx.research.slice_visitor.util;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.core.dom.Statement;

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
	
}
