/*
 * Remy Rogers
 */

import java.io.*;
import java.util.Scanner;

public class VideoGameFrontEnd {
	private static VideoGames list = new VideoGames();
	public static void main(String[] args)
	{
			
		//welcome
		System.out.println("Welcome to the video game database!");
		Scanner scan = new Scanner(System.in);
		boolean go = true;
		int answer;
		while (go)
		{
			System.out.println();
			System.out.println("Enter 1 to load the video game database\nEnter 2 to search the database\nEnter 3 to print current results to the console\nEnter 4 to print current results top file\nEnter 0 to quit");
			answer = scan.nextInt();
			scan.nextLine();
			if (answer == 0)
			{
				System.out.println("Goodbye!");
				go = false;
			}
			else if (answer == 1)
			{

				String fileName;
				System.out.println("Enter the file name");
				fileName = "./" + scan.nextLine();
				//fileName = ("./Tubes.txt");
				list.fileRead(fileName);
				//list.printCurrent();
			}
			else if (answer == 2)
			{
				String a;
				String b;
				System.out.println("Enter the name of the game or \"*\" for all");
				a = scan.nextLine().toLowerCase();
				System.out.println("Enter the name of the console or \"*\" for all");
				b = scan.nextLine().toLowerCase();
				list.search(a,b);
				list.printSearched();
			}
			else if (answer == 3)
			{
				list.printSearched();
			}
			else if (answer == 4)
			{
				String fileName;
				boolean append;
				System.out.println("Enter the file name");
				fileName = scan.nextLine();
				System.out.println("Would you like to append? True or false?");
				if (scan.nextLine().equalsIgnoreCase("True"))
				{
					append = true;
				}
				else
				{
					append = false;
				}
				list.addFile(fileName, append);
			}
			
		}
	}
	
}
