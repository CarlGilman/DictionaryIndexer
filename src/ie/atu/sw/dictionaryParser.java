package ie.atu.sw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
/**
 * 
 * @author G00411268
 * 
 * this file is bringing in the dictionary file as a hashmap and running virtual threads against it.
 * from here the dictionary is converted to lower case as does the file in executor so that it can more
 * accurately match the words to each other. 
 *
 */
public class dictionaryParser {

	public static HashMap<String, String> dictionaryFile(String fileName) {
		HashMap <String, String> words = new HashMap<String, String>();
		
		try {
			Files.lines(Path.of(fileName))
			//.forEach(text -> process(words,text));
			.forEach(text -> Thread.startVirtualThread(()-> process(words,text)));
		
		} catch (IOException e) {
			
		}
		return words;
		
	}
	 public static void process(HashMap<String, String> words, String text) {
		// System.out.println(text);
		 String[] splitText =  text.split(",");
		 String word = splitText[0].toLowerCase();
		 String definition = splitText[1];
		 words.put(word, definition);
	}
	// public static void main(String[] args) {
	//	HashMap<String, String> myHashMap = dictionaryFile("dictionary.csv");
	//	System.out.println(Arrays.asList(myHashMap));
	//	System.out.println(myHashMap.size());
	//	System.out.println(myHashMap.entrySet().iterator().next());
	//	System.out.println(myHashMap);
	//	System.out.println(myHashMap.get("Japan"));
	// }

}