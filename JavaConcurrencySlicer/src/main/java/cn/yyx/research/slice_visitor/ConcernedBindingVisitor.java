package cn.yyx.research.slice_visitor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.SimpleName;

public class ConcernedBindingVisitor extends ASTVisitor {
	
	List<IBinding> concerned_bindings = null;
	boolean need_concerned = false;
	Set<IBinding> concern_binding = new HashSet<IBinding>();
	
	public ConcernedBindingVisitor(List<IBinding> cbinds) {
		concerned_bindings = cbinds;
	}
	
	@Override
	public boolean visit(SimpleName node) {
		IBinding ib = node.resolveBinding();
		if (concerned_bindings.contains(ib))
		{
			need_concerned = true;
			concern_binding.add(ib);
		}
		return super.visit(node);
	}
	
	public boolean IsConcernedStatement()
	{
		return need_concerned;
	}

	public Set<IBinding> GetConcernedBindings() {
		return concern_binding;
	}
	
}
