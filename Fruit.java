/*
 * Remy Rogers
 */

public class Fruit implements Comparable<Fruit>{
	private String type;
	private double weight;
	
	public Fruit()
	{
		type = "Apple";
		weight = 1.0;
	}
	public Fruit(String aType, double aWeight)
	{
		if (aType != null && (aType.equals("Apple") || aType.equals("Orange") || aType.equals("Banana") || aType.equals("Kiwi") || aType.equals("Tomato")))
		{
			type = aType;
		}
		else
		{
			type = "Apple";
		}
		if (aWeight > 0)
		{
			weight = aWeight;
		}
		else
		{
			weight = 1.0;
		}
	}
	public String getType()
	{
		return type;
	}
	public void setType(String aType)
	{
		if (aType != null && (aType.equals("Apple") || aType.equals("Orange") || aType.equals("Banana") || aType.equals("Kiwi") || aType.equals("Tomato")))
		{
			type = aType;
		}
	}
	public double getWeight()
	{
		return weight;
	}
	public void setWeight(double aWeight)
	{
		if (aWeight > 0)
		{
			weight = aWeight;
		}
	}
	public String toString()
	{
		return "Type: " + type +  " Weight: " + weight;
	}
	public int compareTo(Fruit aFruit)
	{
		if (aFruit == null)
		{
			return -1;
		}
		else if (aFruit.getWeight() == this.getWeight())
		{
			return aFruit.getType().compareTo(this.getType());
		}
		else
		{
			return Double.compare(this.getWeight(), aFruit.getWeight());
		}
	}
}
