/*
 * Problem15.java
 *
 * Jan 8, 2016
 */
package Problem15;

import java.math.BigInteger;

/* 
 * @author Per Eresund
 */
public class Problem15 {
	private static int max = 20;
	
	private static BigInteger[][] savedLengths = new BigInteger[max+1][max+1];
	
	private static BigInteger parsePos(int x, int y) {
		int min1 = Math.min(max-x, max-y);
		int max1 = Math.max(max-x, max-y);
		
		if (savedLengths[min1][max1] != null) {
			return savedLengths[min1][max1];
		}
		
		BigInteger tot = BigInteger.valueOf(1);
		if (x < max-1) {
			tot = tot.add(Problem15.parsePos(x+1, y));
		}
		if (y < max-1) {
			tot = tot.add(Problem15.parsePos(x, y+1));
		}
		
		savedLengths[min1][max1] = tot;
//		System.out.printf("paths (%d, %d): %s\n", min1, max1, tot.toString());
		
		return tot;
	}
	
	public static void run() {
		BigInteger tot = Problem15.parsePos(0, 0).add(BigInteger.ONE);
		
		System.out.println("Problem15 - Total number of paths: " + tot.toString());
	}
}


/*
 * --------------
 * 
 * 0 0
 * 0 1
 * 0 2
 * 1 1
 * 1 2
 * 2 2
 * 
 * --------------
 * 
 * 0 0 0
 * 0 0 1
 * 0 0 2
 * 0 1 1
 * 0 1 2
 * 0 2 2
 * 1 1 1
 * 1 1 2
 * 1 2 2
 * 2 2 2
 * 
 * --------------
 * 
 * 0 0 0 0
 * 0 0 0 1
 * 0 0 0 2
 * 
 * 0 0 1 1
 * 0 0 1 2
 * 0 0 2 2
 * 
 * 0 1 1 1
 * 0 1 1 2
 * 0 1 2 2
 * 0 2 2 2
 * 
 * 1 1 1 1
 * 1 1 1 2
 * 1 1 2 2
 * 1 2 2 2
 * 2 2 2 2
 * 
 * --------------
 * 
 * 0 0 0
 * 0 0 1
 * 0 0 2
 * 0 0 3
 * 0 0 4
 * 
 * 0 1 1
 * 0 1 2
 * 0 1 3
 * 0 1 4
 * 0 2 2
 * 0 2 3
 * 0 2 4
 * 0 3 3
 * 0 3 4
 * 0 4 4
 * 
 * 1 1 1
 * 1 1 2
 * 1 1 3
 * 1 1 4
 * 1 2 2
 * 1 2 3
 * 1 2 4
 * 1 3 3
 * 1 3 4
 * 1 4 4
 * 2 2 2
 * 2 2 3
 * 2 2 4
 * 2 3 3
 * 2 3 4
 * 2 4 4
 * 3 3 3
 * 3 3 4
 * 3 4 4
 * 4 4 4
 * 
 * 
 * 
 * --------------
 * 
 * 0 0 0 0
 * 0 0 0 1
 * 0 0 0 2
 * 0 0 0 3
 * 
 * 0 0 1 1
 * 0 0 1 2
 * 0 0 1 3
 * 0 0 2 2
 * 0 0 2 3
 * 0 0 3 3
 * 
 * 0 1 1 1
 * 0 1 1 2
 * 0 1 1 3
 * 0 1 2 2
 * 0 1 2 3
 * 0 1 3 3
 * 0 2 2 2
 * 0 2 2 3
 * 0 2 3 3
 * 0 3 3 3
 * 
 * 1 1 1 1
 * 1 1 1 2
 * 1 1 1 3
 * 1 1 2 2
 * 1 1 2 3
 * 1 1 3 3
 * 1 2 2 2
 * 1 2 2 3
 * 1 2 3 3
 * 1 3 3 3
 * 2 2 2 2
 * 2 2 2 3
 * 2 2 3 3
 * 2 3 3 3
 * 3 3 3 3
 * 
 * 
 * --------------
 * 
 * 0 0 0
 * 0 0 1
 * 0 0 2
 * 0 0 3
 * 
 * 0 1 1
 * 0 1 2
 * 0 1 3
 * 0 2 2
 * 0 2 3
 * 0 3 3
 * 
 * 1 1 1
 * 1 1 2
 * 1 1 3
 * 1 2 2
 * 1 2 3
 * 1 3 3
 * 2 2 2
 * 2 2 3
 * 2 3 3
 * 3 3 3
 * 
 * --------------
 * 
 */