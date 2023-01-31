package ie.atu.sw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 
 * @author G00411268
 * 
 * this class executor basically runs the bulk of the project. it will run the dictionary and 1000 word files against providing the output
 * of the word and the definition of that word, along with how many times that word has appeared in the text file. it will then output this 
 * to a CSV file format within the directory of the project.
 *
 */

public class Executor {
	
	
	public static void run(String fileName) {
		try {
			Files.lines(Path.of(fileName)).forEach(text -> process(text));
			/*
			.forEach(text -> Thread.startVirtualThread(()-> process(text))
			);
			 */
		} catch (IOException e) {
			
		} //name of file
		FileOutputter fileOutputter =  new FileOutputter("output.csv");
		fileOutputter.createFile();
		fileOutputter.writeOut(Word.words);
	}
	//removing symbols and capitals from doc
	public static void process(String line) {
		String [] words = line.split(" ");
		for(String word : words) {
			word = word.trim().replaceAll(
					"\\?|\\,|\\s+|\\'|\\@|\\$|\\£|\\%|\\^|\\&|\\*|\\(|\\)|\\!|\\.|\\:|\\;|\\/|\\|\\/|\\#|\\~|\\]|\\[|\\{|\\}|\"|\\€|\\_",
					"").toLowerCase();
			
			//check if word in list of common words
		
			if(Menu.commonWords.contains(word) || word.equals("")) {
				continue;
		
			}
			
			int index = Word.findWord(word);
			
			if(index == -1) {
				
				//add word to words - found a new word
				
				Word newWord = new Word(word);
				
				Word.words.add(newWord);
			} else {
					
				//increment occurrences
				Word.words.get(index).occurrences++;
				
				
			}
			
		}
	}
	
}

/*
	
//	Files.lines(Path.of(fileName))
//	.forEach(text -> Thread.startVirtualThread(()-> process(line)
//}))
//	system.out.println(line);

	public static void process (line) {
		for (word.of(line)) {
			if (mostCommonWords.get(word) == null) { //readintest?
				continue;
			}
			index = findWord(word);

			if(index == -1)
				words.add(new Word) word
				dictionaryParser.word.get(word)) // pulling from dictionary?

		}	else {
			Word currentWord = words.get(word);
			currentWord.occourances = currentWord.occourances +1;


		}
	}

}
*/


