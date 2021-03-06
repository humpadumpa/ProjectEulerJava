/*
 * Problem22.java
 *
 * Jan 8, 2016
 */
package Problem23;

import java.util.ArrayList;


/* 
 * @author Per Eresund
 */
public class Problem23 {
	private static boolean isSumOfTwoAbundants(int num, ArrayList<Integer> abundants) {
		for (int a : abundants) {
			for (int b : abundants) {
				if (a + b == num) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean isAbundant(int num) {
		int sum = 0;
		for (int i = 1; i < num/2+1; i++) {
			if (num % i == 0) {
				sum += i;
			}
		}
		return (sum > num);
	}
	
	public static void run(String timeFormat) {
		long t0 = System.nanoTime();
		
		ArrayList<Integer> abundants = new ArrayList<>();
		int totalSum = 0;
		for (int i = 1; i < 28134; i++) {
			if (!isSumOfTwoAbundants(i, abundants)) {
				totalSum += i;
			}
			if (isAbundant(i)) {
				abundants.add(i);
			}
		}
		double t = ((System.nanoTime() - t0) / 1000000d);
		
		System.out.printf("Problem23 (" + timeFormat + " ms) - Total sum of non-abundant sums: %s\n" , t, totalSum);
	}
}