//Remy Rogers

//java classes
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Showcase {
	public static void main(String[] args)
	{
		int size = -1;
		try {
			Scanner scanFile = new Scanner(new File("./prizeList.txt"));
			while (scanFile.hasNextLine())
			{
				scanFile.nextLine();
				size ++;
			}
			size++;
			scanFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String[] prizes = new String[size];
		
		Scanner scanFile2;
		try {
			scanFile2 = new Scanner(new File("./prizeList.txt"));
			for (int i = 0; i < size; i++) {
				
				if (scanFile2.hasNextLine() || i == size - 1)
				{
					prizes[i] = scanFile2.nextLine();
				}
			}
			scanFile2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Program introduction
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Showcase Showdown!\nYour prizes are:");
		boolean playing = true;
		while (playing)
		{
			String[] randomPrizes = new String[5];
			for (int i = 0; i < randomPrizes.length; i++)
			{
				int random = (int)(Math.random() * size);
				if (!prizes[random].equals(null) && !prizes[random].equals(randomPrizes[0]) && !prizes[random].equals(randomPrizes[1]) && !prizes[random].equals(randomPrizes[2]) && !prizes[random].equals(randomPrizes[3]) && !prizes[random].equals(randomPrizes[4]))
				{
					randomPrizes[i] = prizes[random];
				}
				else
				{
					i--;
				}
			}
			
			int prizeCost = 0;
			
			String[] rP1 = randomPrizes[0].split("\t");
			String[] rP2 = randomPrizes[1].split("\t");
			String[] rP3 = randomPrizes[2].split("\t");
			String[] rP4 = randomPrizes[3].split("\t");
			String[] rP5 = randomPrizes[4].split("\t");
			
			//checks if the format is correct
			if (rP1.length != 2)
			{
				while (rP1.length != 2)
				{
					rP1 = prizes[(int)(Math.random() * size)].split("\t");
				}
			}
			if (rP2.length != 2)
			{
				while (rP2.length != 2)
				{
					rP2 = prizes[(int)(Math.random() * size)].split("\t");
				}
			}
			if (rP3.length != 2)
			{
				while (rP3.length != 2)
				{
					rP3 = prizes[(int)(Math.random() * size)].split("\t");
				}
			}
			if (rP4.length != 2)
			{
				while (rP4.length != 2)
				{
					rP4 = prizes[(int)(Math.random() * size)].split("\t");
				}
			}
			if (rP5.length != 2)
			{
				while (rP5.length != 2)
				{
					rP5 = prizes[(int)(Math.random() * size)].split("\t");
				}
			}
			
			Integer num1 = Integer.valueOf(rP1[1]);
			System.out.println(rP1[0]);
			prizeCost += (int)(num1);
			
			Integer num2 = Integer.valueOf(rP2[1]);
			System.out.println(rP2[0]);
			prizeCost += (int)(num2);
			
			Integer num3 = Integer.valueOf(rP3[1]);
			System.out.println(rP3[0]);
			prizeCost += (int)(num3);
			
			Integer num4 = Integer.valueOf(rP4[1]);
			System.out.println(rP4[0]);
			prizeCost += (int)(num4);
			
			Integer num5 = Integer.valueOf(rP5[1]);
			System.out.println(rP5[0]);
			prizeCost += (int)(num5);
			

			System.out.println("You must guess the total cost of the prizes without going over and within $1,300 of its actual price");
			int ans = scan.nextInt();
			if (ans > (prizeCost - 1300) && ans < (prizeCost + 1300))
					{
				System.out.println("You won!!");
					}
			else if (ans > prizeCost + 1300)
			{
				System.out.println("You lost. You were over the cost.");
			}
			else
			{
				System.out.println("You lost. You were under the cost.");
			}
			System.out.println("Would you like to quit? Enter 'yes' to quit");
			if (!scan.next().equals("yes"))
			{
				playing = true;
			}
			else
			{
				playing = false;
				System.out.println("Goodbye!");
			}
		}
		
	}
}
