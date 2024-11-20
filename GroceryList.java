/*
 * Remy Rogers
 */

public class GroceryList {
	//private ListNode class
	private class ListNode
	{
		GroceryItem data;
		ListNode link;
		/*public ListNode()
		{
			data = null;
			link = null;
		}*/
		public ListNode(GroceryItem aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	
	//public GroceryList class
	private ListNode head; //reference to the first element
	private ListNode current; //current node of interest
	private ListNode previous; //one node behind current
	
	public GroceryList()
	{
		head = current = previous = null;
	}
	public void addItem(GroceryItem aData)
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
	public void gotoNext()
	{
		if (current != null)
		{
			previous = current;
			current = current.link;
		}
	}
	public GroceryItem getCurrent()
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
	public void setCurrent(GroceryItem aData)
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
	public void addItemAfterCurrent(GroceryItem aData)
	{
		if (current == null)
		{
			return;
		}
		ListNode newNode = new ListNode(aData, current.link);
		current.link = newNode;
	}

	//prints out list
	public void showList()
	{
		ListNode temp = head;
		while (temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	public boolean contains(GroceryItem aData)
	{
		ListNode temp = head;
		if (temp != null)
		{
			while(temp.link != null)
			{
				if(temp.data.equals(aData))
				{
					return true;
				}
				temp = temp.link;
			}
		}
		return false;
	}
	
	public double totalCost()
	{
		ListNode temp = head;
		double totalCost = 0;
		while(temp.link != null)
		{
			totalCost += temp.data.getValue();
			temp = temp.link;
		}
		totalCost+= temp.data.getValue();
		return totalCost;
	}
}
