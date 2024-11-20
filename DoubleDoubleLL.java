/*
 * Remy Rogers
 */

public class DoubleDoubleLL {
	//private ListNode class
		private class ListNode
		{
			double data;
			ListNode link;
			ListNode prevLink;
			/*public ListNode()
			{
				data = null;
				link = null;
			}*/
			public ListNode(double aData)
			{
				data = aData;
			}
		}
		private ListNode head; //reference to the first element
		private ListNode tail; //reference to last element
		private ListNode current; //current node of interest
		private ListNode previous; //one node behind current
		
		//initializing and adding nodes
		public void DoubleLL()
		{
			head = current = previous = null;
		}
		public void add(double aData)
		{
			ListNode newNode = new ListNode(aData);
			if (head == null) //empty list
			{
				head = current = tail = newNode;
				head.prevLink = null;
				head.link = null;
			}
			else//not an empty list
			{
				tail.link = newNode;
				newNode.prevLink = tail;
				tail = newNode;
				tail.link = null;
			}
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
		public void gotoPrev()
		{
			current = previous;
			previous = current.prevLink;
		}
		public void reset()
		{
			current = head;
			previous = null;
		}
		public void gotoEnd()
		{
			reset();
			while (current.link != null)
			{
				current = current.link;
			}
		}
		public boolean hasMore()
		{
			if (current != null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		public double getCurrent()
		{
				return current.data;
		}
		public void setCurrent(double aData)
		{
			if (current == null)
			{
				return;
			}
			current.data = aData;
		}
		public void remove(double aData)
		{
			
			while (current != null)
			{
				ListNode del;
				if (current.data == aData)
				{
					del = current;
					//delete node
			        if (del.link != null)  
			        { 
			            del.link.prevLink = del.prevLink; 
			        } 
			        if (del.prevLink != null)  
			        { 
			            del.prevLink.link = del.link; 
			        }
			        del = null; 
				}
				current = current.link;
			}
		}
		public void removeCurrent() 
	    { 
			ListNode del = current;
			current = current.link;	        //empty list
	        if (head == null || del == null)  
	        { 
	            return; 
	        } 
	  
	        //if current is first
	        if (head == del)  
	        { 
	            head = del.link; 
	        } 
	        
	       //delete middle node
	        if (del.link != null)  
	        { 
	            del.link.prevLink = del.prevLink; 
	        } 
	        if (del.prevLink != null)  
	        { 
	            del.prevLink.link = del.link; 
	        }
	        del = null; 
	    }
		public void addAfterCurrent(double aData)
		{
			if (current == null)
			{
				return;
			}
			ListNode newNode = new ListNode(aData);
			newNode.link = current.link;
			current.link.prevLink = newNode;
			newNode.prevLink = current;
			current.link = newNode;
		}
		public boolean contains(double aData)
		{
			reset();
			while (current != null)
			{
				if (current.data == aData)
				{
					return true;
				}
				current = current.link;
			}
			return false;
		}
}
