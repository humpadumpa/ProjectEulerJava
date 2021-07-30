/*
 * Problem15.java
 *
 * Jan 8, 2016
 */
package Problem15;

/* 
 * @author Per Eresund
 */
public class Problem15 {
	private static long getCol(int y, int h) {
		return h - y;
	}
	
	private static long p = 0;
	private static long getRow(int w, int y, int h) {
		long tot = h-y;
		
//		for (int y1 = y-1; y1 > 0; y1--) {
			for (int x = 1; x <= w-1; x++) {
			tot += getRow(x, y-1, h);
//				tot += getRow(x, y1, h);
//				p++;
			}
//		}
//		if (p % 1 == 0)System.out.println(p);
		
		return tot;
	}
	
	private static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	private static int getSumUpTo(int n) {
		int x = 1;
		for (int i = 2; i <= n; i++) {
			x += i;
		}
		return x;
	}
	
	public static void run() {
		int w = 20;
		int h = 20;
		int tot = 0;
		
		int[] arr = new int[w-1];
//		while(arr[0] != 20) {
			for (int x = w-1; x >= 0; x--) {
				int y = arr[x];
				
				for (int n = w-1; n > x; n++) {
					tot += 
				}
				
			}
//		}
		
//		long n = 1;
//		for (int y = h+1; y > 0; y--) {
//			n += y*w;
////			for (int x = w; x >= 0; x--) {
////				n += y*w;
////			}
//		}
		System.out.println(getRow(w, 0, h));
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