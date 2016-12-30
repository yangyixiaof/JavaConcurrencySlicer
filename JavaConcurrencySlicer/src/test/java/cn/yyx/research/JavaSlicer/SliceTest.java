package cn.yyx.research.JavaSlicer;

import org.junit.Assert;
import org.junit.Test;

import cn.yyx.research.slice.Slicer;

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
	public void testx1() throws Exception
	{
		try {
			Slicer s = new Slicer("test_examples");
			s.SliceSuffixedTestInDirectory("_ESTest");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
}
