package cn.yyx.research.slice_visitor.util;

public class RegexHelper {
	
	public static String SimplifyType(String type)
	{
		String tpstr = type;
		tpstr = tpstr.replaceAll("<[^\\.]*>", "");
		tpstr = tpstr.replaceAll("\\[[^\\.]*\\]+", "");
		return tpstr;
	}
	
}
