/*
 * Problem22.java
 *
 * Jan 8, 2016
 */
package Problem24;

import java.util.ArrayList;


/* 
 * @author Per Eresund
 */
public class Problem24 {
	public static void run(String timeFormat) {
		long t0 = System.nanoTime();
        int totalSum = 0;
        double t = ((System.nanoTime() - t0) / 1000000d);
        
		System.out.printf("Problem24 (" + timeFormat + " ms) - ?: %s\n" , t, totalSum);
	}
}