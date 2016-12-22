package cn.yyx.research.slice_visitor;

import java.util.List;

import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Statement;

import cn.yyx.research.slice_visitor.util.FixedSizeQueue;

public class LastNMethodsVisitor extends BaseVisitor {
	
	protected FixedSizeQueue<Statement> fsq = null;
	
	public LastNMethodsVisitor(int n, String classname) {
		super(classname);
		fsq = new FixedSizeQueue<Statement>(n);
	}
	
	@Override
	public boolean visit(MethodInvocation node) {
		Expression expr = node.getExpression();
		if (IsConcerned(expr))
		{
			Statement stat = FindMostCloseAncestorStatement(node);
			fsq.AddOneItem(stat);
		}
		return super.visit(node);
	}
	
	public List<Statement> GetLastNMethods()
	{
		return fsq.getItems();
	}
	
}
