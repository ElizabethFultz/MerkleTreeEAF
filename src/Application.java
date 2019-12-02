import java.util.Scanner;
import StackAndQueuePackage.*;

/**
 * This class exists to allow a user to input a file to create a Merkle Tree
 * 
 * @author Elizabeth Fultz
 * @version 1.0
 * Merkle Tree Project
 * Fall 2019
 */

public class Application {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\nPlease enter the name of the file to process: ");
		String fileName = scan.next();
		
		LinkedQueue<dataBlock> dataQueue = new LinkedQueue<dataBlock>();
		
		dataReader reader = new dataReader(fileName, dataQueue);
		
		merkleTree merkle = new merkleTree();
		
		LinkedQueue<String> hashesQueue = new LinkedQueue<String>();
		
		LinkedStack<String> nodes = new LinkedStack<String>();

		while(!dataQueue.isEmpty()) { 
			
			dataBlock block = dataQueue.dequeue();
			merkle.calculateHash(block);
			String hash = merkle.getHash();
			hashesQueue.enqueue(hash);	
			nodes.push(hash);
			System.out.println(hash);
			
		}//end while loop	
		
		while(!hashesQueue.isEmpty()) {
			
			String hash1 = hashesQueue.dequeue();
			
			if(!hashesQueue.isEmpty()) {
				
				String hash2 = hashesQueue.dequeue();
				String combinedHash = hash1 + hash2;
				merkle.calculateRoot(combinedHash);
				String finalHash = merkle.getHash();
				hashesQueue.enqueue(finalHash);
				nodes.push(finalHash);
				System.out.println(finalHash);
				
			}//end if
			
			else {
				
				while(!nodes.isEmpty()) {
					
					String node = nodes.pop();
					merkle.addData(node);
					
				}//end while
				
			}//end else
			
		}//end while loop
		
		

	}//end main

}//end Application
