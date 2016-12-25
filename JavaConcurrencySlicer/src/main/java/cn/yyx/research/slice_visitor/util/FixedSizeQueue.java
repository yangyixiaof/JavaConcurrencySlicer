package cn.yyx.research.slice_visitor.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FixedSizeQueue<K, T> {
	
	private int capacity = 0;
	private Set<T> items = new HashSet<T>();
	private Map<K, LinkedList<T>> bingds = new HashMap<K, LinkedList<T>>();
	
	public FixedSizeQueue(int capacity) {
		this.capacity = capacity;
		if (capacity <= 0)
		{
			System.err.println("capacity less than 0?");
			System.exit(1);
		}
	}
	
	public void AddOneItem(K k, T t)
	{
		if (!items.contains(t))
		{
			items.add(t);
			LinkedList<T> ls = bingds.get(k);
			if (ls == null)
			{
				ls = new LinkedList<T>();
				bingds.put(k, ls);
			}
			ls.add(t);
			if (ls.size() > capacity)
			{
				ls.remove(0);
			}
		}
	}

	public List<T> getItems() {
		List<T> result = new LinkedList<T>();
		Set<K> bkeys = bingds.keySet();
		Iterator<K> bitr = bkeys.iterator();
		while (bitr.hasNext())
		{
			K bk = bitr.next();
			LinkedList<T> bls = bingds.get(bk);
			if (bls != null)
			{
				result.addAll(bls);
			}
		}
		return result;
	}
	
}
