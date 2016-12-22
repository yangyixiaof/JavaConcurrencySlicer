package cn.yyx.research.JavaSlicer;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jface.text.Document;
import org.junit.Assert;
import org.junit.Test;

import cn.yyx.research.file_util.FileUtil;
import cn.yyx.research.java_slicer.TestCase;
import cn.yyx.research.jdt_helper.JDT_Util;
import cn.yyx.research.slice_visitor.ParseSliceVisitor;
import cn.yyx.research.slice_visitor.util.SlicedCodeGenerator;

public class SliceTest
{
	@Test
	public void testx0()
	{
		String tpstr = "Stack<Object>";
		tpstr = tpstr.replaceAll("<[^\\.]*>", "");
		Assert.assertEquals(tpstr, "Stack");
		tpstr = "Stack<Object>.Input<Ha>.Output[]";
		tpstr = tpstr.replaceAll("<[^\\.]*>", "");
		Assert.assertEquals(tpstr, "Stack.Input.Output[]");
		tpstr = tpstr.replaceAll("\\[[^\\.]*\\]+", "");
		Assert.assertEquals(tpstr, "Stack.Input.Output");
	}
	
	@Test
	public void testx1()
	{
		try {
			ParseSliceVisitor psv = new ParseSliceVisitor("Stack");
			CompilationUnit cu = JDT_Util.parseSourceCode("Stack_ESTest.java", new Document(FileUtil.ReadFromFile(new File("test_examples/Stack_ESTest.java"))));
			// testing code.
			// cu.accept(new TestVisitor());
			cu.accept(psv);
			List<TestCase> lts = psv.GetTestCases();
			Iterator<TestCase> litr = lts.iterator();
			while (litr.hasNext())
			{
				TestCase tc = litr.next();
				FileUtil.WriteToFile((tc.getFilename().endsWith(".java") ? tc.getFilename() : tc.getFilename()+".java"), tc.getContent(), SlicedCodeGenerator.PACKAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(new File("haa").getAbsolutePath());
	}
	
}
