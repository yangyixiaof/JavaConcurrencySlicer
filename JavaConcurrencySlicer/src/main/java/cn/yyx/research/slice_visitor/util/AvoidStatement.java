package cn.yyx.research.slice_visitor.util;

import org.eclipse.jdt.core.dom.ASTNode;

public class AvoidStatement {
	
	public static boolean IsAvoided(ASTNode node)
	{
		if (node.toString().trim().startsWith("PrivateAccess."))
		{
			return true;
		}
		if (node.toString().trim().startsWith("fail("))
		{
			return true;
		}
		if (node.toString().trim().startsWith("System."))
		{
			return true;
		}
		return false;
	}
	
}
