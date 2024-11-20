/*
 * Remy Rogers
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class OrganizeTasks {
	private GenLL<Tasks>[] organizedTasks;
	public OrganizeTasks()
	{
		organizedTasks = new GenLL[5];
		for(int i=0;i<organizedTasks.length;i++)
		{
		  organizedTasks[i] = new GenLL<Tasks>();
		}
	}
	public void addTask(String aAction, int aPriority)
	{
		Tasks newTask = new Tasks(aAction, aPriority);
		boolean isHere = false;
		organizedTasks[aPriority].reset();
		while (organizedTasks[aPriority].getCurrent() != null && !isHere)
		{
			if (organizedTasks[aPriority].getCurrent().equals(newTask))
			{
				isHere = true;
				System.out.println("This task already exists.");
			}
			organizedTasks[aPriority].gotoNext();
		}
		if (!isHere)
		{
			organizedTasks[aPriority].add(newTask);
		}
	}
	public void removeTask(String aAction, int aPriority)
	{
		Tasks newTask = new Tasks(aAction, aPriority);
		organizedTasks[aPriority].reset();
		while (organizedTasks[aPriority].getCurrent() != null)
		{
			if (organizedTasks[aPriority].getCurrent().equals(newTask))
			{
				organizedTasks[aPriority].removeCurrent();
			}
			organizedTasks[aPriority].gotoNext();
		}
	}
	public void printList()
	{
		for(int i = 0; i < organizedTasks.length; i++)
		{
			organizedTasks[i].print();
		}
	}
	public void fileRead(String fileName)
	{
		//creates the scanner to read the file
		Scanner fileScanner;
		try {
			fileScanner = new Scanner(new File(fileName));
			//While there is a next line
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split("\t");
				//Check if it is the correct size
				if(splitLines.length == 2)
				{
					String action = splitLines[1];
					int priority = Integer.valueOf(splitLines[0]);
					Tasks newTask = new Tasks(action,priority);
					//Adds the new item to the end of the list
					organizedTasks[priority].add(newTask);
					//System.out.println(action);
				}
			}
			fileScanner.close();//Closes the file Scanner
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addFile(String fileName)
	{
		try {
				PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName));
				for (int i = 0; i < organizedTasks.length; i++)
				{
					organizedTasks[i].reset();
					while (organizedTasks[i].isNotLastNode())
					{
						fileWriter.println(organizedTasks[i].getCurrent());
						organizedTasks[i].gotoNext();
					}
					fileWriter.println(organizedTasks[i].getCurrent());
				}
				fileWriter.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
