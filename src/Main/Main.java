/*
 * Main.java
 *
 * Sep 30, 2015
 */
package Main;

import Problem1.Problem1;
import Problem1.Problem1SC;

/* 
 * @author Per Eresund
 */
public class Main {

    public static void main(String[] args) {
		long t0;
//		t0 = System.nanoTime();
//		Problem1 p1 = new Problem1();
//		p1.run(500000);
//		System.out.println("time: " + ((System.nanoTime() - t0) / 1000000d) + " ms");
//		t0 = System.nanoTime();
//		Problem1SC.problem1SC();
//		System.out.println("time: " + ((System.nanoTime() - t0) / 1000000d) + " ms");
		
		Problem15.Problem15.run();
		Problem22.Problem22.run();
		Problem23.Problem23.run();
		Problem24.Problem24.run();
		Problem81.Problem81.run();
		Problem82.Problem82.run();
		Problem83.Problem83.run();
	}
}