/*
 * Problem82.java
 *
 * Jan 8, 2015
 */
package Problem82;

import Pathfinding.AStar.AStarfarer82;
import Pathfinding.StandardNode;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* 
 * @author Per Eresund
 */
public class Problem82 {
	public static void run(String timeFormat) {
		long t0 = System.nanoTime();
		int size = 80;
		StandardNode[][] map = new StandardNode[size][size];
		File f = new File("src/p083_matrix.txt");
		Scanner scan;
		try {
			scan = new Scanner(f);
		} catch (FileNotFoundException ex) {
			System.out.println("file not found");
			return;
		}
		int x = 0, y = 0;
		scan.useDelimiter(", \n");
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			StringTokenizer tok = new StringTokenizer(line);
			while (tok.hasMoreTokens()) {
				int cost = Integer.parseInt(tok.nextToken(","));
				map[x][y] = new StandardNode(cost, true);

				x++;
				if (x > size-1) { x = 0; y++; }
			}
		}
		
		AStarfarer82 finder;
		int min = Integer.MAX_VALUE;
		for (int y0 = 0; y0 < size; y0++) {
			finder = new AStarfarer82(map, 0, y0, size-1, -1);
			finder.start();
			
			for (y = 0; y < size; y++) {
				min = Math.min(min, finder.getCost(size-1, y));
			}
		}
		
        double t = ((System.nanoTime() - t0) / 1000000d);
		
		System.out.printf("Problem82 (" + timeFormat + " ms) - Minimal path sum for 3 ways: %s\n" , t, min);
		
//		for (y = 0; y < size; y++) {
//			for (x = 0; x < size; x++) {
//				try {
//					System.out.printf("%6d ", finder.getCost(x, y));
//				} catch (NullPointerException e) {
//					System.out.printf("%6d ", -1);
//				}
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for (y = 0; y < size; y++) {
//			System.out.print( "| ");
//			for (x = 0; x < size; x++) {
//				if (finder.path.contains(AStarfarer.getPos(x, y)))  {
//					System.out.printf("%6d ", finder.getCost(x, y));
//				} else {
//					System.out.printf("------ ");
//				}
//			}
//			System.out.print( " |\n");
//		}
//		System.out.print( "\n\n\n");
	}
}
