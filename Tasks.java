/*
 * Remy Rogers
 */
public class Tasks {
	private String action;
	private int priority;
	
	public Tasks()
	{
		action = "none";
		priority = 4;
	}
	public Tasks(String aAction, int aPriority)
	{
		if (aAction != null)
			{
				action = aAction;
			}
		else 
		{
			action = "none";
		}
		priority = aPriority;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String aAction) {
		if (aAction != null)
		{
			action = aAction;
		}
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int aPriority) {
			priority = aPriority;
	}
	public String toString() {
		return "Priority: " + priority + " Action: " + action;
	}
	public boolean equals(Tasks a)
	{
		if (a.getAction().equals(this.getAction()) && a.getPriority() == this.getPriority())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
