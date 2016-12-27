package cn.yyx.research.java_slicer;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jface.text.Document;

import cn.yyx.research.jdt_helper.JDT_Util;
import cn.yyx.research.slice_visitor.ParseSliceVisitor;
import cn.yyx.research.slice_visitor.util.TestSuite;

public class SliceWithTargetClass {
	
	String target_class = null;
	String target_class_simple_name = null;
	
	public SliceWithTargetClass(String targetclass) {
		target_class = targetclass;
		int lidx = target_class.lastIndexOf('.');
		if (lidx < 0) {
			target_class_simple_name = target_class;
		} else {
			target_class_simple_name = target_class.substring(lidx+1);
		}
	}
	
	public TestSuite SliceOneJunitTest(String classname, String classcontent)
	{
		CompilationUnit icu = JDT_Util.parseSourceCode(classname, new Document(classcontent));
		ParseSliceVisitor psv = new ParseSliceVisitor(target_class_simple_name);
		icu.accept(psv);
		TestSuite ts = new TestSuite(psv.GetImportContent(), psv.GetTestCases());
		return ts;
	}
	
}
