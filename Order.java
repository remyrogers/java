/*
 * Remy Rogers
 */
public class Order implements Comparable<Order>{
	//instance variables
	private String customer;
	private String foodOrder;
	private int cookingTime;
	private int arrivalTime;
	private int cookingTimeLeft;
	
	public Order()
	{
		customer = "none";
		foodOrder = "none";
		cookingTime = 1;
		arrivalTime = 0;
		cookingTimeLeft = cookingTime;
	}
	public Order(String aCustomer, String aFoodOrder, int aCookingTime, int aArrivalTime)
	{
		if (aCustomer != null)
		{
			customer = aCustomer;
		}
		else
		{
			customer = "none";
		}
		if (aFoodOrder != null)
		{
			foodOrder = aFoodOrder;
		}
		else
		{
			foodOrder = "none";
		}
		if (aCookingTime >= 0)
		{
			cookingTime = aCookingTime;
		}
		else
		{
			cookingTime = 1;
		}
		if (aArrivalTime >= 0)
		{
			arrivalTime = aArrivalTime;
		}
		else
		{
			arrivalTime = 0;
		}
		cookingTimeLeft = cookingTime;
	}
	
	//getters and setters
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String aCustomer) {
		if (aCustomer != null)
		{
			customer = aCustomer;
		}
	}
	public String getFoodOrder() {
		return foodOrder;
	}
	public void setFoodOrder(String aFoodOrder) {
		if (aFoodOrder != null)
		{
			foodOrder = aFoodOrder;
		}
	}
	public int getCookingTime() {
		return cookingTime;
	}
	public void setCookingTime(int aCookingTime) {
		if (aCookingTime >= 0)
		{
			cookingTime = aCookingTime;
		}
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int aArrivalTime) {
		if (aArrivalTime >= 0)
		{
			arrivalTime = aArrivalTime;
		}
	}
	public int getCookingTimeLeft() {
		return cookingTimeLeft;
	}
	public void setCookingTimeLeft(int aCookingTimeLeft) {
		if (aCookingTimeLeft >= 0)
		{
			cookingTimeLeft = aCookingTimeLeft;
		}
	}
	public String toString() {
		return "Customer: " + customer + ", Order: " + foodOrder + ", Cooking Time Left: " + cookingTimeLeft;
	}
	
	
	//other methods
	public void cookForOneMinute()
	{
		cookingTimeLeft--;
	}
	public boolean isDone()
	{
		if (cookingTimeLeft == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public int compareTo(Order aOrder)
	{
		if (aOrder != null)
			return Integer.compare(this.getCookingTime(), aOrder.getCookingTime());
		else 
			return 0;
	}
}
