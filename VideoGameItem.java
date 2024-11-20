/*
 * Remy Rogers
 */

public class VideoGameItem {
	private String name;
	private String console;
	
	public VideoGameItem()
	{
		name = "none";
		console = "none";
	}
	public VideoGameItem(String aName, String aConsole)
	{
		if (aName != null)
			{
				name = aName;
			}
		else 
		{
			name = "none";
		}
		if (aConsole != null)
			{
				console = aConsole;
			}
		else
		{
			console = "none";
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
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String aConsole) {
		if (aConsole != null)
		{
			console = aConsole;
		}
	}
	public String toString() {
		return name + " " + console;
	}
	public boolean equals(VideoGameItem a)
	{
		if (a.getName().equals(this.getName()) && a.getConsole() == this.getConsole())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
