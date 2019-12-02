import java.io.*;
import java.util.Scanner;
import StackAndQueuePackage.*;

/**
 * This class reads from a file and places the contents into a data block.
 * 
 * @author Elizabeth Fultz
 * @version 1.0
 * Merkle Tree Project
 * Fall 2019
 */

public class dataReader {
	
	/**
	 * This is the empty constructor
	 */
	public dataReader() {
			
	}//end empty constructor
	
	
	/**
	 * 
	 * @param fileName the file to be read
	 * @param queue the queue to put the data into
	 */
	public dataReader(String fileName, LinkedQueue <dataBlock> queue) {
		
		File file = new File(fileName);
		
		String data = "";
		
		try {
					
			Scanner fileScanner = new Scanner(file);
			
			while(fileScanner.hasNextLine()) {
				data = fileScanner.nextLine();
			
				dataBlock block = new dataBlock(data);
				
				queue.enqueue(block);
			}//end while
			
		}//end try
		
		catch(FileNotFoundException ex) {}
		
	}//end preferred constructor
	


}//end class
