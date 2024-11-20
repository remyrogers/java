/*
 * Remy Rogers
 */

import java.util.Scanner;

public class TasksFE {
	public static void main(String[] args)
	{
		
		//welcome
		System.out.println("Wlecome to the Task Organizer!");
		System.out.println();
		boolean go = true;
		int answer;
		OrganizeTasks org = new OrganizeTasks();
		Scanner scan = new Scanner(System.in);
		//loop of user decisions
		while (go)
		{
			System.out.println();
			System.out.println("Enter 1 to add a task\nEnter 2 to remove a task\nEnter 3 to print tasks to the console\nEnter 4 to read from a task file"
					+ "\nEnter 5 to write a task file\nEnter 9 to quit");
			answer = scan.nextInt();
			scan.nextLine();
			if (answer == 9)
			{
				System.out.println("Goodbye!");
				go = false;
			}
			else if (answer == 1)
			{
				int priority;
				String action;
				System.out.println("Enter the task's priority");
				priority = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter the task's action");
				action = scan.nextLine();
				org.addTask(action, priority);
			}
			else if (answer == 2)
			{
				int priority;
				String action;
				System.out.println("Enter the task's priority");
				priority = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter the task's action");
				action = scan.nextLine();
				org.removeTask(action, priority);
			}
			else if (answer == 3)
			{
				org.printList();
			}
			else if (answer == 4)
			{
				String fileName;
				System.out.println("Enter the file name");
				fileName = "./" + scan.nextLine();
				org.fileRead(fileName);
				//org.printList();
			}
			else if (answer == 5)
			{
				String fileName;
				System.out.println("Enter the file name");
				fileName = scan.nextLine();
				org.addFile(fileName);
			}
		}
	}
}
