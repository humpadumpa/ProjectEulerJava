/*
 * Problem1SC.java
 *
 * Oct 1, 2015
 */
package Problem1;

/* 
 * @author Per Eresund
 */
public class Problem1SC {
	private static final long MAX_NUM = 10000000000L;
	
	public static void problem1SC() {
//		if (true) return;
		long sum = 0;
//		for (long i = 0; i < MAX_NUM; i++) {
//			if (i % 3 == 0 || i % 5 == 0) sum += i;
//		}
		for (long i = 3;;) {
			sum += i;
			i += 2;
			if (i >= MAX_NUM) break;
			sum += i;
			i += 1;
			if (i >= MAX_NUM) break;
			sum += i;
			i += 3;
			if (i >= MAX_NUM) break;
			sum += i;
			i += 1;
			if (i >= MAX_NUM) break;
			sum += i;
			i += 2;
			if (i >= MAX_NUM) break;
			sum += i;
			i += 3;
			if (i >= MAX_NUM) break;
			sum += i;
			i += 3;
			if (i >= MAX_NUM) break;
		}
		System.out.println("sum: " + sum);
	}
}