package ie.atu.sw;

import java.util.ArrayList;


/**
 * 
 * @author G00411268
 * 
 * this class Word is breaking down the instances of words appearing in the text file and getting the definition of each 
 * this is used by the executor file to display the word/definition/instance.
 *
 */

public class Word {
	public static ArrayList<Word> words = new ArrayList<Word>();
	String word;
	String definition;
	int occurrences = 1;
	
	ArrayList<Integer> pages = new ArrayList<Integer>();	
	
	public Word(String inputWord) {
		word = inputWord;
		
		//get definition 
		definition = Menu.dictionaryWords.get(word); 
	}
	// finding the word in the file, iterating over each word until the end of the file.
	public static int findWord(String searchWord) {
		for(int i = 0; i< words.size(); i++) {
			if (words.get(i).word.equals(searchWord)) {
				return i;
			}
		}
		return -1;
	}
}
