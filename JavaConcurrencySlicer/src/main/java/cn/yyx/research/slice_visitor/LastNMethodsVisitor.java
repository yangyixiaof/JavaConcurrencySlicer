package cn.yyx.research.slice_visitor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

import cn.yyx.research.slice_visitor.util.FixedSizeQueue;

public class LastNMethodsVisitor extends BaseVisitor {
	
	int n = 0;
	protected FixedSizeQueue<IBinding, Statement> fsq = null;
	List<Statement> static_concern = new LinkedList<Statement>();
	
	public LastNMethodsVisitor(int n, String classname) {
		super(classname);
		this.n = n;
		fsq = new FixedSizeQueue<IBinding, Statement>(n);
	}
	
	@Override
	public boolean visit(Assignment node) {
		Expression expr = node.getLeftHandSide();
		if (IsConcerned(expr))
		{
			Statement stat = FindMostCloseAncestorStatement(node);
			fsq.AddOneItem(GetBinding(expr), stat);
		}
		return super.visit(node);
	}
	
//	@Override
//	public boolean visit(VariableDeclarationStatement node) {
//		boolean result = super.visit(node);
//		
//		@SuppressWarnings("unchecked")
//		List<VariableDeclarationFragment> frags = node.fragments();
//		Iterator<VariableDeclarationFragment> fitr = frags.iterator();
//		while (fitr.hasNext())
//		{
//			VariableDeclarationFragment vdf = fitr.next();
//			SimpleName expr = vdf.getName();
//			if (IsConcerned(expr) && !vdf.getInitializer().toString().equals("null"))
//			{
//				Statement stat = FindMostCloseAncestorStatement(node);
//				fsq.AddOneItem(GetBinding(expr), stat);
//			}
//		}
//		
//		return result;
//	}
	
	@Override
	public boolean visit(MethodInvocation node) {
		Expression expr = node.getExpression();
		if (IsConcerned(expr))
		{
			Statement stat = FindMostCloseAncestorStatement(node);
			fsq.AddOneItem(GetBinding(expr), stat);
		}
		if (expr != null && expr.toString().equals(classname))
		{
			Statement stat = FindMostCloseAncestorStatement(node);
			if (!static_concern.contains(stat))
			{
				static_concern.add(stat);
				if (static_concern.size() > n)
				{
					static_concern.remove(0);
				}
			}
		}
		return super.visit(node);
	}
	
	public List<Statement> GetLastNMethods()
	{
		List<Statement> res = fsq.getItems();
		res.addAll(static_concern);
		return res;
	}
	
	public List<IBinding> GetConcernedBindings()
	{
		return fsq.getKeys();
	}
	
}
