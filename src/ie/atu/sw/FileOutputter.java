package ie.atu.sw;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileOutputter {
	private String outputFileName;

	public FileOutputter(String fileName) {
		outputFileName = fileName;
	}
	
	public void createFile() {
		//Creating file to be written to
		try {
			File createdFile = new File(outputFileName);
			if (createdFile.createNewFile()) {
				System.out.println("File created: " + createdFile.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	public void writeOut(ArrayList<Word> words) {
		//writing out the array to the created file
		try {
			FileWriter myWriter = new FileWriter(outputFileName);
			myWriter.write("\"Word\",\"Definition\",\"Occurrences\"\n");

			for (int i = 0; i <words.size(); i++) {
				myWriter.write("\"" + words.get(i).word +
						"\",\"" + words.get(i).definition +
						"\",\"" + words.get(i).occurrences + "\"\n"
				);
			}

			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}