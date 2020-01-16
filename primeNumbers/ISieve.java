package primeNumbers;

import java.io.FileNotFoundException;
/**
 * Interface class that has getPrimes(), and savePrimes().
 * @author Britain Mackenzie
 *
 */
public interface ISieve {
	/**
	 * Uses Euler's sieve to find primes in a range
	 */
	public void getPrimes();
	/**
	 * Saves prime array to file
	 * @throws FileNotFoundException If no folder at file path throws exception.
	 */
	public void savePrimes() throws FileNotFoundException;
}

