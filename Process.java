/*
 * Remy Rogers
 */
public class Process {
	private String name;
	private double completionTime;
	public Process()
	{
		name = "none";
		completionTime = 0.0;
	}
	public Process(String aName, double aTime)
	{
		if (aName != null)
		{
			name = aName;
		}
		else
		{
			name = "none";
		}
		if (aTime > 0)
		{
			completionTime = aTime;
		}
		else
		{
			completionTime = 0.0;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String aName) {
		if (name != null) {
			name = aName;
		}
	}
	public double getCompletionTime() {
		return completionTime;
	}
	public void setCompletionTime(double aTime) {
		if (aTime > 0)
			completionTime = aTime;
	}
	public String toString()
	{
		return "Process name: " + name + " Completion time: " + completionTime;
	}
	
}
