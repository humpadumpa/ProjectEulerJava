/*
 * Problem83.java
 *
 * Jan 3, 2015
 */
package Problem83;

import Pathfinding.AStar.AStarfarer83;
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
public class Problem83 {
	public static void run() {
//		Scanner scan = new Scanner(System.in);
		System.out.print("");
		
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
//		
//		AStarfarer finder = new AStarfarer(map, 0, 0, size-1, size-1);
//		long t0 = System.nanoTime();
//		finder.start();
//		System.out.println("time: " + ((System.nanoTime() - t0) / 1000000d) + " ms");
//		finder.generatePath();
//		System.out.print(finder.getCost(size-1, size-1) + "\n");
//		
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
//			for (x = 0; x < size; x++) {
//				if (finder.path.contains(AStarfarer.getPos(x, y)))  {
//					System.out.printf("%6d ", finder.getCost(x, y));
//				} else {
//					System.out.printf("%6d ", -1);
//				}
//			}
//			System.out.print( "\n");
//		}
		
//		int size = 10;
//		StandardNode[][] map = new StandardNode[size][size];
//		for (int y = 0; y < size; y++) {
//			for (int x = 0; x < size; x++) {
//				int cost = (int)(Math.random() * 1 + 1D);
//				map[x][y] = new StandardNode(cost, true);
//			}
//		}
		
		AStarfarer83 finder = new AStarfarer83(map, 0, 0, size-1, size-1);
		long t0 = System.nanoTime();
		finder.start();
		System.out.println("time: " + ((System.nanoTime() - t0) / 1000000d) + " ms");
		finder.generatePath();
		System.out.print(finder.getCost(size-1, size-1) + "\n");
//		int x, y;
		
		System.out.println("\n|------------------------------------------|");
		for (y = 0; y < size; y++) {
			System.out.print( "| ");
			for (x = 0; x < size; x++) {
				try {
					System.out.printf("%6d ", finder.getCost(x, y));
				} catch (NullPointerException e) {
					System.out.printf("------ ");
				}
			}
			System.out.print( " |\n");
		}
		
		System.out.println("|------------------------------------------|");
		for (y = 0; y < size; y++) {
			System.out.print( "| ");
			for (x = 0; x < size; x++) {
				if (finder.path.contains(AStarfarer83.getPos(x, y)))  {
					System.out.printf("%6d ", finder.getCost(x, y));
				} else {
					System.out.printf("------ ");
				}
			}
			System.out.print( " |\n");
		}
		System.out.println("|------------------------------------------|");
	}
}
