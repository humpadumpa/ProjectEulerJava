package Problem1;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Problem1 {
	private static final long MAX_NUM = 1000L;

	private long[] sum;
	public Problem1() {
	}
	
	public void run(int nthreads) {
		Thread[] t = new Thread[nthreads];
		long partStart = 0;
		long partEnd = MAX_NUM / nthreads;
		sum = new long[nthreads];
		long t0 = System.nanoTime();
		for (int i = 0; i < nthreads; i++) {
			if (i == nthreads - 1) partEnd = MAX_NUM;
			
			t[i] = new Thread(new CalculatorFork(partStart, partEnd, i));
			t[i].start();
			try {
				Thread.sleep(0);
			} catch (InterruptedException ex) {
				Logger.getLogger(Problem1.class.getName()).log(Level.SEVERE, null, ex);
			}
			
			partStart = partEnd;
			if (i == nthreads-1) {
				partEnd = MAX_NUM;
			} else {
				partEnd = partEnd + MAX_NUM / nthreads;
			}
		}
		//System.out.println("time: " + ((System.nanoTime() - t0) / 1000000f) + " ms");

		try {
			for (int i = 0; i < nthreads; i++) {
				t[i].join();
			}
		} catch (InterruptedException ex) {
			System.out.println("Noob.");
			ex.printStackTrace(System.err);
		}
		long sums = 0;
		for (int i = 0; i < sum.length; i++) {
			sums += sum[i];
		}
		
		System.out.println(Arrays.toString(sum));
		System.out.println("Sum: " + sums);
	}
    
    private class CalculatorFork implements Runnable {
		private final long start, end;
		private int num;
        
		private CalculatorFork(long start, long end, int num) {
			this.start = start;
			this.end = end;
			this.num = num;
        }

        @Override
        public void run() {
			long t0 = System.nanoTime();
//			long i = Math.max(start, 3);
//			for (; i < end; i++) {
//				if (i % 3 == 0) {
//					break;
//				}
//				if (i % 5 == 0) sum[num] += i;
//			}
//			
////			while(true) {
////				
////			}
			for (long i = start; i < end; i++) {
				if (i % 3 == 0 || i % 5 == 0) sum[num] += i;
			}
			
			double t = ((System.nanoTime() - t0) / 1000000d);
			
			System.out.println("Thread " + num + " finished in " + t + " ms!");
		}
    }
}
