/*
 * Remy Rogers
 */

import java.util.Scanner;

public class Sorter {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		boolean cont =  true;
	
		while (cont)
		{
			GenLL<SortWords> list = new GenLL<SortWords>();
			String ans = "";
			//intro
			System.out.println("Enter any number of strings to be sorted by SORTS. Once you are done entering strings, please enter 'quit'.");
			while (cont)
			{
				ans = scan.nextLine();
				if (ans.equalsIgnoreCase("quit"))
				{
					break;
				}
				String input = ans.toLowerCase();
				if (input.contains("sort"))
				{
					int count = 0;
					while(input.contains("sort")){
					      count++;
					      input=input.substring(input.indexOf("sort")+4);
					  }
					SortWords curr = new SortWords(ans, count);
					list.add(curr);
				}
				else
				{
					SortWords curr = new SortWords(ans, 0);
					list.add(curr);
				}
			}
			list.reset();
			System.out.println("Generating sorted words!");
			
			//computes greatest count and returns sorted list
			int gCount = greatestCount(list);
			for (int i = 0; i <= gCount; i++)
			{
				list.reset();
				while (!list.isLastNode())
				{
					if (list.getCurrent().getCount() == i)
					{
						System.out.println(list.getCurrent().getWord());
					}
					list.gotoNext();
				}
			}
			
			//repeats code or ends
			System.out.println("Would you like to sort more strings? (y/n)");
			if (scan.nextLine().equals("n"))
			{
				System.out.println("Goodbye!");
				cont = false;
			}
		}
		
	}
	

    private static int greatestCount(GenLL<SortWords> aList) {
        int gCount = 0;
        aList.reset();
        while (!aList.isLastNode()) {
            if (aList.getCurrent() != null && aList.getCurrent().getCount() > gCount)
            {
            	gCount = aList.getCurrent().getCount();
            }
            aList.gotoNext();
        }
        return gCount;
    }
}
