package cn.yyx.research.slice_visitor.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class FixedSizeQueue<T> {
	
	protected int capacity = 0;
	private List<T> items = new LinkedList<T>();
	
	public FixedSizeQueue(int capacity) {
		this.capacity = capacity;
		if (capacity <= 0)
		{
			System.err.println("capacity less than 0?");
			System.exit(1);
		}
	}
	
	public void AddOneItem(T t)
	{
		getItems().add(t);
		if (getItems().size() > capacity)
		{
			getItems().remove(0);
		}
	}
	
	public Iterator<T> Iterator()
	{
		return getItems().iterator();
	}

	public List<T> getItems() {
		return items;
	}
	
}
