/*
 * Remy Rogers
 */
public class OrderScheduler {
	//instance variables
	private MinHeap<Order> orders;
	private Order currentOrder;
	private int currentMinute;
	private int totalOrders;
	private int summedWaitingTimes;
	
	public OrderScheduler()
	{
		orders = new MinHeap<>();
		currentOrder = null;
		currentMinute = 0;
		totalOrders = 0;
		summedWaitingTimes = 0;
	}
	
	//required methods
	public Order getCurrentOrder()
	{
		if (currentOrder != null)
		{
			return currentOrder;
		}
		else
		{
			return null;
		}
	}
	public void addOrder(Order aOrder)
	{
		if (currentOrder == null)
		{
			currentOrder = aOrder;
		}
		else
		{
			orders.add(aOrder);
		}
		totalOrders++;
	}
	public void advanceOneMinute()
	{
		currentMinute++;
		if (currentOrder != null)
		{
			currentOrder.cookForOneMinute();
			if (currentOrder.isDone())
			{
				summedWaitingTimes = summedWaitingTimes + (currentMinute - currentOrder.getArrivalTime());
				currentOrder = orders.remove();
			}
		}
	}
	public boolean isDone()
	{
		if (currentOrder == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public double getAverageWaitingTime()
	{
		return (double)(summedWaitingTimes)/(double)(totalOrders);
	}
}
