package cn.yyx.research.slice_visitor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

import cn.yyx.research.slice_visitor.util.RegexHelper;

public class BaseVisitor extends ASTVisitor {
	
	protected String classname = null;
	protected List<IBinding> concerned_variables = new LinkedList<IBinding>();
	
	public BaseVisitor(String classname) {
		this.classname = classname;
	}
	
	@Override
	public boolean visit(VariableDeclarationStatement node) {
		boolean need_concern = false;
		Type tp = node.getType();
		String tpstr = tp.toString();
		tpstr = RegexHelper.SimplifyType(tpstr);
		if (tpstr.equals(classname) || tpstr.startsWith(classname+"."))
		{
			need_concern = true;
		}	
		@SuppressWarnings("unchecked")
		List<VariableDeclarationFragment> frags = node.fragments();
		Iterator<VariableDeclarationFragment> fitr = frags.iterator();
		while (fitr.hasNext())
		{
			VariableDeclarationFragment vdf = fitr.next();
			IBinding ib = vdf.getName().resolveBinding();
			if (ib == null)
			{
				System.err.println("Base_Visitor:What the fuck! IBinding is null?" + " Wrong code is:" + node);
				ASTNode temp = node;
				while (temp != null && !(temp instanceof MethodDeclaration))
				{
					temp = temp.getParent();
				}
				System.out.println("possible method declaration:" + temp);
				// possible wrong code:CsrfPreventionFilter.LruCache<Object> csrfPreventionFilter_LruCache0=new CsrfPreventionFilter.LruCache<Object>(0);
				System.exit(1);
			}
			if (need_concern)
			{
				concerned_variables.add(ib);
			}
		}
		return super.visit(node);
	}
	
	protected Statement FindMostCloseAncestorStatement(ASTNode node)
	{
		while (!(node instanceof Statement))
		{
			node = node.getParent();
		}
		return (Statement) node;
	}
	
	protected IBinding GetBinding(Expression expr) {
		if (expr != null && expr instanceof SimpleName)
		{
			IBinding ib = ((SimpleName)expr).resolveBinding();
			return ib;
		}
		return null;
	}
	
	protected boolean IsConcerned(Expression expr) {
		if (expr != null && expr instanceof SimpleName)
		{
			IBinding ib = ((SimpleName)expr).resolveBinding();
			for (IBinding tib : concerned_variables)
			{
				if (tib.equals(ib) || expr.toString().equals(classname) || expr.toString().startsWith(classname+"."))
				{
					return true;
				}
			}
		}
		return false;
	}
	
}
