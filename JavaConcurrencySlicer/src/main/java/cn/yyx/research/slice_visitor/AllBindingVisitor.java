package cn.yyx.research.slice_visitor;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.SimpleName;

public class AllBindingVisitor extends ASTVisitor {
	
	Set<IBinding> bindings = new HashSet<IBinding>();
	
	public AllBindingVisitor() {
	}
	
	@Override
	public boolean visit(SimpleName node) {
		IBinding ib = node.resolveBinding();
		if (ib != null)
		{
			bindings.add(ib);
		}
		return super.visit(node);
	}
	
	public Set<IBinding> GetAllBindings()
	{
		return bindings;
	}
	
}
