package cn.yyx.research.slice_visitor;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.SimpleName;

public class TestVisitor extends ASTVisitor {
	
	@Override
	public boolean visit(SimpleName node) {
		IBinding ib = node.resolveBinding();
		System.out.println(node + "#:=:#" + ib);
		return super.visit(node);
	}
	
}
