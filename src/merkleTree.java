import java.security.*;
import TreePackage.*;

/**
 * This class creates a Merkle Tree and computes the hashes for the given data
 * 
 * @author Elizabeth Fultz
 * @version 1.0
 * Merkle Tree Project
 * Fall 2019
 */

public class merkleTree {
	
	String hash; //will be used to hold the hash that is created
	BinarySearchTree<String> tree; //creates a binary tree 
	
	/**
	 * The empty constructor
	 */
	public merkleTree() {
		
		hash = "";
		tree = new BinarySearchTree<String>();
		
	}//end empty constructor
	
	
	/**
	 * Adds a node to the Merkle Tree
	 * @param data the data to be put into a node
	 */
	public void addData(String data) {
		
		tree.add(data);
		
	}//end add
	
	
	/**
	 * Calculates the hash of a data block
	 * @param block the data block to be hashed
	 */
	public void calculateHash(dataBlock block) {
		
		try {
			
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(block.getByteArray());
			byte[] byteArray = md.digest();
			StringBuffer hexString = new StringBuffer();
			
			for(int i = 0;i < byteArray.length; i++) {

				hexString.append(Integer.toHexString(0xFF & byteArray[i]));
				
			}//end for loop
			
			hash = hexString.toString();			

		}//end try
		
		catch(NoSuchAlgorithmException ex){}//end catch
		
		
	}//end calculateHash

		
	/**
	 * This calculates the hash of the root of two nodes
	 * @param initalHash the initial hash to be hashed again
	 */
	public void calculateRoot(String initalHash) {
		
		try {
			
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(initalHash.getBytes());
			byte[] byteArray = md.digest();
			StringBuffer hexString = new StringBuffer();
			
			for(int i = 0;i < byteArray.length; i++) {

				hexString.append(Integer.toHexString(0xFF & byteArray[i]));
				
			}//end for loop
			
			hash = hexString.toString();
			
			
		}//end try
		
		catch(NoSuchAlgorithmException ex) {}//end catch

	}//end calculateRoot
	
	/**
	 * 
	 * @param value the value to be set
	 */
	public void setHash(String value) {
		
		hash = value;
		
	}//end setHash

	/**
	 * 
	 * @return the value of hash
	 */
	public String getHash() {
		
		return hash;
		
	}//end getHash

}//end class

