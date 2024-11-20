//Remy Rogers 

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class FileIOSolutions {
	
	//pastTense method
	public static void pastTense(String iF, String oF)
	{
		try {
			Scanner scan = new Scanner(new File(iF));
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(oF));
			
			while (scan.hasNext())
			{
				//rewrites file to past tense
				String word = scan.next();;
				if (word.equals("is"))		//lowercase "is"
				{
					System.out.println("was");
					fileWriter.println("was");
				}
				else if (word.equals("Is"))		//uppercase "Is"
				{
					System.out.println("Was");
					fileWriter.println("Was");
				}
				else
				{
					System.out.println(word);
					fileWriter.println(word);
				}
			}
				scan.close();
				fileWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//totalTubeVolume method
	public static double totalTubeVolume(String iF)
	{
		int size = 0;
		try {
			Scanner scan = new Scanner(new File(iF));
			while (scan.hasNextLine())
			{
				scan.nextLine();
				size ++;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//creates String[] of tubes
		String[] tubes = new String[size];
		Scanner scan;
		try {
			scan = new Scanner(new File(iF));
			for (int i = 0; i < size; i++) {
				
				if (scan.hasNextLine() || i == size - 1)
				{
					tubes[i] = scan.nextLine();
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//splits strings and finds total volume
		double volumeTotal = 0;
		for (int i = 0; i < size; i++)
		{
			String[] currentTube = tubes[i].split("\t");
			if (currentTube.length == 3)
			{
				volumeTotal += Math.PI * Math.pow(((double)(Double.valueOf(currentTube[1]))),2)*((double)(Double.valueOf(currentTube[2])));
			}
		}
		return volumeTotal;
	}
}
