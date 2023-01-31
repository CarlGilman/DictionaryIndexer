package ie.atu.sw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;


/**
 * 
 * @author G00411268
 * 
 * this class reads in the google 1000 words document so that the system can then remove the 1000 words in the executor 
 * class. this is ran via virtual threads to process the 1000 words. this is processed into a hashset which can be
 * used in an easier format against the text files.
 *
 */

public class ReadInTest{
//  public static void main(String[] args) {
//	 HashSet<String> myHashSet = readInFile("google-1000.txt"); // 0(1) time linear?
//	 for (String val : myHashSet) {
//		System.out.println(val);
//	}
//	 System.out.println(myHashSet);
//	 System.out.println(myHashSet.size());
	 
 // }
  
  public static HashSet<String> readInFile(String fileName) {
	HashSet<String> Words = new HashSet<String>();
//	
	try {
		Files.lines(Path.of(fileName))
			//.forEach(text -> process(Words,text));
			.forEach(text -> Thread.startVirtualThread(()-> process(Words,text)));
	
	} catch (IOException e) {
		
	}
	
//    try {
//      File myObj = new File(fileName);
//      Scanner myReader = new Scanner(myObj);
//      while (myReader.hasNextLine()) {
//        String data = myReader.nextLine();
//        Words.add(data);
//        
//        System.out.println(data);
//      }
//      myReader.close();
//    } catch (FileNotFoundException e) {
//      System.out.println("An error occurred.");
//      e.printStackTrace();
//    }
 
  
  return Words;
  }
  
  public static void process(HashSet<String> words, String text) {
	  words.add(text);
	  
  }
  
  
}