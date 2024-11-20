/*
 * Remy Rogers
 */

import java.io.*;
import java.util.Scanner;
public class RobotFE {
	public static void main(String[] args)
	{
		System.out.println("Welcome to the Robot Simulator!");
		boolean cont = true;
		Scanner scan = new Scanner(System.in);
		char[] board = new char[100];
		String fileName;
		LLQueue<String> commands;
		while (cont)
		{
			//reads board file
			commands = new LLQueue<String>();
			System.out.println("Enter file for the board:");
			fileName = scan.nextLine();
			System.out.println();
			try {
				String fileLines = "";
				Scanner file = new Scanner(new File(fileName));
				while (file.hasNext())
				{
					fileLines += file.next();
				}
				for (int i = 0; i < fileLines.length(); i++)
				{
					board[i] = fileLines.charAt(i);
				}
				file.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//reads robot commands file
			System.out.println("Enter file for the robot commands");
			fileName = scan.nextLine();
			try {
				Scanner file = new Scanner(new File(fileName));
				while (file.hasNextLine())
				{
					commands.enqueue(file.nextLine());
				}
				file.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int robot = 0;
			for (int i = 0; i < board.length; i++)
			{
				if (i % 10 == 0 && i != 0)
				{
					System.out.println();
				}
				if (i == robot)
				{
					System.out.print("O");
					continue;
				}
				System.out.print(board[i]);
			}
			System.out.println();
			
			String currCommand;
			int commandNum = 0;
			System.out.println();
			System.out.println("Simulation begin");
			while (commands.peek() != null)
			{
				currCommand = commands.dequeue();
				if (robot == 99)
				{
					break;
				}
				else if (currCommand.equals("Move Right"))
				{
					if (robot != 99 && !(board[robot+1] == 'X'))
					{
						robot++;
					}
					else
					{
						System.out.println("CRASH!");
						break;
					}
				}
				else if (currCommand.equals("Move Left"))
				{
					if (robot != 0 && !(board[robot-1] == 'X'))
					{
						robot--;
					}
					else
					{
						System.out.println("CRASH!");
						break;
					}
				}
				else if (currCommand.equals("Move Down"))
				{
					if (robot < 90 && !(board[robot+10] == 'X'))
					{
						robot += 10;
					}
					else
					{
						System.out.println("CRASH!");
						break;
					}
				}
				else if (currCommand.equals("Move Up"))
				{
					if (robot > 9 && !(board[robot-10] == 'X'))
					{
						robot -= 10;
					}
					else
					{
						System.out.println("CRASH!");
						break;
					}
				}
				//prints after command
				commandNum++;
				System.out.println("Command " + commandNum);
				System.out.println();
				for (int i = 0; i < board.length; i++)
				{
					if (i % 10 == 0 && i != 0)
					{
						System.out.println();
					}
					if (i == robot)
					{
						System.out.print("O");
						continue;
					}
					System.out.print(board[i]);
				}
				System.out.println();
				System.out.println();
			}
			
			//quit or rerun
			System.out.println("Simulation end.\nEnter \"n\" to quit or \"y\" to continue.");
			String ans = scan.nextLine();
			if (ans.equals("n"))
			{
				System.out.println("Goodbye!");
				cont = false;
			}
		}
	}
}
