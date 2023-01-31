package ie.atu.sw;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 
 * @author G00411268
 * @version 1.0
 * @since 19
 *
 *
 *
 *	this is a general menu for the API that pulls in from various areas of the project.
 *	it brings in various elements such as the <i> file selector, dictionary file , 1000 common words file and the executor </i>
 *	this is how the user can interact and run the API as they wish.
 */
public class Menu {
	private Scanner s;
	public static HashSet<String> commonWords;
	public static HashMap <String, String> dictionaryWords;
	
	
	//keeps menu running when activated
	private boolean keepRunning = true;
	
	public Menu() {
		// allows for input from the user
		s = new Scanner(System.in);
	}


	public void start() {
		while (keepRunning) {
			showOptions();
			// list of choices
			int choice = Integer.parseInt(s.next()); // blocks...

			System.out.println(choice);

			if (choice == 1) {
				System.out.println(
						"Please Select a file to use, once selected please do not close the file browser window"
								+ "\n");
				// Create a frame to select files
				JFrame f = new JFrame("File Selector");
				// set visibility of frame
				f.setVisible(true);
				// enable frame to close
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// set size of frame that appears
				f.setSize(600, 600);

				// button to select the file
				JButton button1 = new JButton("Open File Browser");
				JButton runButton = new JButton("Run with selected file");

				// object of the class
				MyDirectory d1 = new MyDirectory();

				// capture user input on the button
				button1.addActionListener(d1);

				SaveFileLocation listener_SaveFileLocation = new SaveFileLocation();

				runButton.addActionListener(listener_SaveFileLocation); // this -----------
				// panel to add the buttons too
				JPanel p = new JPanel();

				// adding button to the panel frame
				p.add(button1);
				p.add(runButton);

				MyDirectory.l = new JLabel("no file Selected");

				p.add(MyDirectory.l);
				f.add(p);

				f.show();
				// imports code from MyDirectory tab to work in the menu
				// MyDirectory.fileSelection();
				// selecting directory
				start();
				return; 
				
				} else if(choice == 2) {
					//parse dictionary
					dictionaryWords = dictionaryParser.dictionaryFile("dictionary.csv"); // 0(n) time
					System.out.println("configuring dictionary");	
			
				} else if(choice == 3) {
					//parse 1000 common words
					commonWords = ReadInTest.readInFile("google-1000.txt"); // 0(n) time
					System.out.println("configuring common words");
					
				} else if(choice == 4) {
					//run executor
					System.out.println("executing");
					Executor.run(SaveFileLocation.fileLocation);
					
				} else if(choice == 5) {
					
					quit();
					// quit out from program
					System.out.println("[INFO] Shutting down.... Please wait....");
					keepRunning = false;
				} else {
					System.out.println("ERROR Invalid Input");
				}
		}
	}
	
		
	private void quit() {
		
	}
		
	
	
	private void showOptions() {
		
		//UI overlay for menu containing various options
		System.out.println("************************************************************");
		System.out.println("*       ATU - Dept. Computer Science & Applied Physics     *");
		System.out.println("*                                                          *");
		System.out.println("*              Virtual Threaded Text Indexer               *");
		System.out.println("*                                                          *");
		System.out.println("************************************************************");
		System.out.println("(1) Specify Text File");
		System.out.println("(2) Configure Dictionary");
		System.out.println("(3) Configure Common Words");
		System.out.println("(4) Execute");
		System.out.println("(5) Quit");
		
		//Output a menu of options and solicit text from the user
		System.out.print("Select Option [1-5]>");
		System.out.println();

	}
}
