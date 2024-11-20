/*
 * Remy Rogers
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class VideoGames {
	
	private GenLL<VideoGameItem> gamesList;
	private GenLL<VideoGameItem> searchedGames;
	
	public VideoGames()
	{
		gamesList = new GenLL<VideoGameItem>();
		
	}
	public void addVideoGameItem(VideoGameItem v)
	{
		gamesList.add(v);
	}
	//read file method
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
					String name = splitLines[0];
					String console = splitLines[1];
					VideoGameItem g = new VideoGameItem(name,console);
					//Adds the new item to the end of the list
					gamesList.add(g);
				}
			}
			fileScanner.close();//Closes the file Scanner
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//search games method
	public void search(String a, String b)
	{
		GenLL<VideoGameItem> searchedGames2 = new GenLL<VideoGameItem>();
		searchedGames = new GenLL<VideoGameItem>();
		//searches based on name
		//searchedGames.clear();
		gamesList.reset(); 
		VideoGameItem currentG;
		if (a.equals("*"))
		{
			while (gamesList.isNotLastNode())
			{
				currentG = gamesList.getCurrent();
				if (currentG != null)
				{
					searchedGames2.add(currentG);
				}
				gamesList.gotoNext();
			}
		}
		else {
			gamesList.reset();
			while (gamesList.isNotLastNode())
			{
				currentG = gamesList.getCurrent();
				if (currentG != null && currentG.getName().toLowerCase().contains(a))
				{
					searchedGames2.add(currentG);
				}
				gamesList.gotoNext();
			}
		}
		
		//searches based on console
		searchedGames2.reset(); 
		if (b.equals("*"))
		{
			while (searchedGames2.isNotLastNode())
			{
				currentG = searchedGames2.getCurrent();
				if (currentG != null)
				{
					searchedGames.add(currentG);
				}
				searchedGames2.gotoNext();
			}
		}
		else {
			while (searchedGames2.isNotLastNode())
			{
				currentG = searchedGames2.getCurrent();
				if (currentG != null && currentG.getConsole().toLowerCase().contains(b))
				{
					searchedGames.add(currentG);
				}
				searchedGames2.gotoNext();
			}
		}
		//prints final list to console
		searchedGames.print();
	}
	
	//print results to new file
	public void addFile(String fileName, boolean append)
	{
		try {
				searchedGames.reset();
				PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName, append));
				while (searchedGames.isNotLastNode())
				{
					fileWriter.println(searchedGames.getCurrent());
					searchedGames.gotoNext();
				}
				fileWriter.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void printSearched()
	{
		searchedGames.print();
	}
	public void printCurrent()
	{
		gamesList.print();
	}
}
