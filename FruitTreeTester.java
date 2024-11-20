/* 
 * Remy Rogers
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FruitTreeTester {
	public static void main(String[] args)
	{
		LinkedBST<Fruit> fruits = new LinkedBST<Fruit>();
		Scanner scan = new Scanner(System.in);
		//intro
		System.out.println("Welcome to the fruit tree!\nPlease enter a fruit file name:");
		String ans = scan.nextLine();
			Scanner scanFile;
			try {
				scanFile = new Scanner(new File(ans));
				while(scanFile.hasNextLine())
				{
					String fileLine = scanFile.nextLine();
					String[] splitLines = fileLine.split("\t");
					//Check if it is the correct size
					if(splitLines.length != 2)
					{
						continue;
					}
					String type = splitLines[0];
					double weight = Double.parseDouble(splitLines[1]);
					Fruit f = new Fruit(type,weight);
					//System.out.println(f.toString());
					fruits.add(f);
				}
				scanFile.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			scan.close();
		//Printing results
		System.out.println("Populating tree file");
		System.out.println("\nPrinting the in-order transversal:");
		fruits.printInorder();
		System.out.println("\nPrinting the pre-order transversal:");
		fruits.printPreorder();
		System.out.println("\nPrinting the post-order transversal:");
		fruits.printPostorder();
		
		//Printing results post fruit deletion
		System.out.println("\nDeleting: Apple ~ 0.4859853412170728");
		Fruit removed = new Fruit("Apple",0.4859853412170728);
		fruits.remove(removed);
		System.out.println("\nPrinting the in-order transversal:");
		fruits.printInorder();
	}
}
