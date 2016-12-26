package cn.yyx.research.slice_visitor.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.jdt.core.dom.Statement;

public class Dependency {
	
	protected Set<Statement> statements = new HashSet<Statement>();
	
	public Dependency() {
	}
	
	public Dependency(Dependency smts) {
		statements.addAll(smts.statements);
	}
	
	public Dependency(Collection<Statement> smts) {
		statements.addAll(smts);
	}
	
	public Iterator<Statement> Iterator()
	{
		return statements.iterator();
	}
	
	public void Union(Dependency depd)
	{
		statements.addAll(depd.statements);
	}
	
	public void Intersection(Dependency depd)
	{
		statements.retainAll(depd.statements);
	}
	
	public void Subtraction(Dependency depd)
	{
		statements.removeAll(depd.statements);
	}
	
	public void AddStatement(Statement stmt)
	{
		statements.add(stmt);
	}
	
	public List<Statement> OrderedStatements(Map<Statement, Integer> statements_order)
	{
		Map<Integer, Statement> hm = new TreeMap<Integer, Statement>();
		Iterator<Statement> stsitr = statements.iterator();
		while (stsitr.hasNext())
		{
			Statement stat = stsitr.next();
			Integer order = statements_order.get(stat);
			if (order == null)
			{
				System.out.println("Error: null order of statement:" + stat);
				System.exit(1);
			}
			hm.put(order, stat);
		}
		List<Statement> result = new LinkedList<Statement>();
		Set<Integer> keys = hm.keySet();
		Iterator<Integer> kitr = keys.iterator();
		int preorder = -1;
		while (kitr.hasNext())
		{
			Integer order = kitr.next();
			if (order <= preorder)
			{
				System.err.println("wrong order.");
				System.exit(1);
			}
			preorder = order;
			result.add(hm.get(order));
		}
		return result;
	}
	
}
