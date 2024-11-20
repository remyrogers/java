/*
 * Remy Rogers
 */

public class GroceryItem {
	private String name;
	private double value;
	public GroceryItem()
	{
		name = "none";
		value = 0;
	}
	public GroceryItem(String aName, double aValue)
	{
		if (aName != null)
		{
			name = aName;
		}
		else
		{
			name = "none";
		}
		if (aValue >= 0)
		{
			value = aValue;
		}
		else
		{
			value = 0;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String aName) {
		if (aName != null)
		{
			name = aName;
		}
		else
		{
			name = "none";
		}
	}
	public double getValue() {
		return value;
	}
	public void setValue(double aValue) {
		if (aValue >= 0)
		{
			value = aValue;
		}
		else
		{
			value = 0;
		}
	}
	public String toString() {
		return "Grocery Item Name: " + name + ", Value: " + value;
	}
	public boolean equals(GroceryItem a)
	{
		if (a.getName().equals(this.getName()) && a.getValue() == this.getValue())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
