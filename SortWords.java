/*
 * Remy Rogers
 */

public class SortWords {
	//private variables
	private String word;
	private int count;
	//initialize
	public SortWords(String aWord, int aCount)
	{
		word = aWord;
		count = aCount;
	}
	
	//getters and setters
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void print()
	{
		System.out.println("Word: " + word + " Count: " + count);
	}
}
