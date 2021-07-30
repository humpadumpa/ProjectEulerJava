/*
 * Problem81.java
 *
 * Jan 8, 2016
 */
package Problem81;

import Pathfinding.AStar.AStarfarer81;
import Pathfinding.StandardNode;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/* 
 * @author Per Eresund
 */
public class Problem81 {
	public static void run(String timeFormat) {
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
		
		AStarfarer81 finder = new AStarfarer81(map, 0, 0, size-1, size-1);
		
		long t0 = System.nanoTime();
		finder.start();
		double t = ((System.nanoTime() - t0) / 1000000d);
		
		System.out.printf("Problem81 (" + timeFormat + " ms) - Minimal path sum for 2 ways: %s\n" , t, finder.getCost(size-1, size-1));
		
		finder.generatePath();
		
		if (true) return;
		
		for (y = 0; y < size; y++) {
			for (x = 0; x < size; x++) {
				try {
					System.out.printf("%6d ", finder.getCost(x, y));
				} catch (NullPointerException e) {
					System.out.printf("%6d ", -1);
				}
			}
			System.out.println();
		}
		System.out.println();
		for (y = 0; y < size; y++) {
			System.out.print( "| ");
			for (x = 0; x < size; x++) {
				if (finder.path.contains(AStarfarer81.getPos(x, y)))  {
					System.out.printf("%6d ", finder.getCost(x, y));
				} else {
					System.out.printf("------ ");
				}
			}
			System.out.print( " |\n");
		}
		System.out.print( "\n\n\n");
	}
}
