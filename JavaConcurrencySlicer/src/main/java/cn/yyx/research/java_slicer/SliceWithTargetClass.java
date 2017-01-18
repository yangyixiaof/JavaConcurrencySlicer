package cn.yyx.research.java_slicer;

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
	
//	public TestSuite SliceOneJunitTest(String classname, String classcontent)
//	{
//		CompilationUnit icu = JDT_Util.parseSourceCode(classname, new Document(classcontent));
//		ParseSliceVisitor psv = new ParseSliceVisitor(target_class_simple_name);
//		icu.accept(psv);
//		TestSuite ts = new TestSuite(psv.GetImportContent(), psv.GetTestCases());
//		return ts;
//	}
	
}
