package cn.yyx.research.slice_visitor;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.SimpleName;

public class FirstSimpleNameVisitor extends ASTVisitor {
	
	private SimpleName sn = null;
	
	public FirstSimpleNameVisitor() {
	}
	
	@Override
	public boolean visit(SimpleName node) {
		if (sn == null)
		{
			sn = node;
		}
		return super.visit(node);
	}
	
	public SimpleName getSimpleName() {
		return sn;
	}
	
	public boolean HasSimpleName()
	{
		return sn != null;
	}
	
}
