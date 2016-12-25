package cn.yyx.research.slice_visitor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Statement;

public class StatementOrderVisitor extends ASTVisitor {
	
	int order = 0;
	private Map<Statement, Integer> statements_order = new HashMap<Statement, Integer>();
	
	@Override
	public boolean preVisit2(ASTNode node) {
		if (node instanceof Statement)
		{
			order++;
			statements_order.put((Statement)node, order);
		}
		return super.preVisit2(node);
	}

	public Map<Statement, Integer> GetStatementsOrder() {
		return statements_order;
	}
	
}
