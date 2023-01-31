package ie.atu.sw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * 
 * @author G00411268
 * this is the page that saves the file location for use in the executor class
 *
 */
	public class SaveFileLocation implements ActionListener {

		static String fileLocation;

		SaveFileLocation() {
		}	

		public void actionPerformed(ActionEvent e) {
			
			fileLocation = MyDirectory.l.getText();

			System.out.println(fileLocation);
		}
		

	}
	

