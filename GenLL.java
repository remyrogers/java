/*
 * Remy Rogers
 */

public class GenLL <T> {
	private class ListNode
	{
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	private ListNode head; //reference to the first element
	private ListNode current; //current node of interest
	private ListNode previous; //one node behind current
	public GenLL()
	{
		head = current = previous = null;
	}
	public void add(T aData)
	{
		ListNode newNode = new ListNode(aData, null);
		if (head == null) //empty list
		{
			head = current = newNode;
			return;
		}
		//not an empty list
		ListNode temp = head;
		while (temp.link != null)
		{
			temp = temp.link;
		}
		temp.link = newNode;
	}
	public void print()
	{
		ListNode temp = head;
		while (temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	public void gotoNext()
	{
		if (current != null)
		{
			previous = current;
			current = current.link;
		}
	}
	public void reset()
	{
		current = head;
		previous = null;
	}
	
	public T getCurrent()
	{
		if (current == null)
		{
			return null;
		}
		else
		{
			return current.data;
		}
	}
	public void setCurrent(T aData)
	{
		if (current == null)
		{
			return;
		}
		current.data = aData;
	}
	public void removeCurrent()
	{
		if (current != null && previous == null) //current = head
		{
			head = head.link;
			current = head;
		}
		else if (current != null && previous != null)
		{
			previous.link = current.link;
			current = current.link;
		}
	}
	public void addAfterCurrent(T aData)
	{
		if (current == null)
		{
			return;
		}
		ListNode newNode = new ListNode(aData, current.link);
		current.link = newNode;
	}
	public boolean isNotLastNode()
	{
		if (current.link != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void clear()
	{
		head = null;
	}
}
