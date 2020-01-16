package primeNumbers;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Outputs a file containing prime numbers to a user generated max value.
 * Utilizes Euler's algorithm in order to find primes
 * @author Britain Mackenzie
 * @author A00561831
 */

public class Sieve implements ISieve{
	/**
	 * Holds user entered max number to find primes to
	 */
	int max;
	/**
	 * Holds numbers in sequential order up to max
	 */
	ArrayList<Integer>  nums = new ArrayList<Integer>();
	/**
	 * Holds the destination file name provided by user
	 */
	String name;
	/**
	 * 
	 * Uses Euler's sieve algorithm to find all primes below the user generated max number
	 * 
	 */
	public void getPrimes() {
		/**
		 * Populates the ArrayList with sequential numbers from 2-max
		 */
		for(int i = 2; i <= max; i++)
		{
			nums.add(i);
		}
		
		/**
		 * Counter for do loop to move through array sequentially after removal of non-primes
		 */
		int x=0;
		Boolean yep = true;
		
		/**
		 * 
		 * Euler's sieve algorithm
		 * Removes all elements that have factors, incrementing by array location and removing multiples of each prime.
		 * Primes are determined by not having factors, and are cycled down array by position.
		 * 
		 */
		do{
			for(int y = x+1; y<nums.size(); y++)
			{
				    
					if(nums.get(y)%nums.get(x) == 0){
							nums.remove(y);
					}
			}
			x++;
			if(x>=nums.size())
			{
				yep = false;
			}
		}while(yep==true);	
	}
	/**
	 * 
	 * Creates path to output file by concating the user input file name to the filepath
	 * Creates file if none exists, or overwrites if the file already exists
	 * Writes prime list to file using an iterator.
	 * @throws  FileNotFoundException if filepath doesn't exist
	 */
	public void savePrimes() throws FileNotFoundException {
		String filePath = "/Users/britainmackenzie/eclipse-workspace/primeNumbers/";
		
		filePath = filePath.concat(name).concat(".txt");
		
		PrintWriter out = new PrintWriter(filePath);
		
		Iterator<Integer> it = nums.iterator();
		while(it.hasNext()) {
			out.print(it.next()+" ");
		}
		out.close();
	}
	/**
	 * Main: Finds all prime numbers below a user generated number and saves those prime to a file named by the user.
	 * 
	 * @param args Main funct
	 * @throws FileNotFoundException	If no folder at file path throws exception
	 */
public static void main(String[] args) throws FileNotFoundException {
	/**
	 * Creates new Sieve object 
	 */
	Sieve sieve = new Sieve();
	/**
	 * Creates scanner for user input
	 */
	Scanner scan = new Scanner(System.in);
	/**
	 * Fetches user generated max number, and requires it be in range
	 */
	do {
	System.out.println("Find all primes below: ");
	sieve.max = scan.nextInt();
	scan.nextLine();
	}while(sieve.max<2);
	/**
	 * Fetches user generated file name, and repeats if no entry
	 */
	do {
	System.out.println("File name to save to: ");
	sieve.name = scan.nextLine();
	}while(sieve.name.isEmpty());
	
	scan.close();
	/**
	 * Calls methods to calculate primes and write them to file
	 */
		sieve.getPrimes();
		sieve.savePrimes();
		
	System.out.println(sieve.max + "primes exported to folder.");
	}
}