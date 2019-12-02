/**
 * This class takes a string and places it into a Data Block.
 * 
 * @author Elizabeth Fultz
 * @version 1.0
 * Merkle Tree Project
 * Fall 2019
 */

public class dataBlock {
	
	String data = "";
	
	/**
	 * This is the empty constructor
	 */
	dataBlock() {
		
	}//end empty constructor
	
	
	/**
	 * 
	 * @param input is the String that the data block will hold
	 */
	dataBlock(String input){
		
		data = input;
		
	}//end preferred constructor
	
	
	/**
	 * This method takes the string and converts it into a byte array
	 * @return the byte array
	 */
	
	public byte[] getByteArray() {
		
		return data.getBytes();
		
	}//end getByteArray

}//end class
