/*
 * Problem22.java
 *
 * Jan 8, 2016
 */
package Problem22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/* 
 * @author Per Eresund
 */
public class Problem22 {
	private static int getVal(char c) {
		if (Character.isUpperCase(c)) {
			return (int)c - ((int)'A'-1);
		} else {
			return (int)c - ((int)'a'-1);
		}
	}
	
	private static int getVal(String s) {
//		System.out.println("String: " + s);
		
		int val = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
//			System.out.println("Char: " + c + ", val: " + getVal(c));
			val += getVal(c);
		}
		return val;
	}
	
	public static void run() {
		ArrayList<String> names = new ArrayList<>();
		
		File f = new File("src/p022_names.txt");
		Scanner scan;
		try {
			scan = new Scanner(f);
		} catch (FileNotFoundException ex) {
			System.out.println("file not found");
			return;
		}
		
		scan.useDelimiter(", \n\"");
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			StringTokenizer tok = new StringTokenizer(line);
			while (tok.hasMoreTokens()) {
				String name = tok.nextToken(",\"");
//				System.out.println("Added: " + name);
				names.add(name);
			}
		}
		
		Object[] arr = names.toArray();
		Arrays.sort(arr);
		names.clear();
		for (Object name : arr) {
			names.add((String)name);
		}
		
		int total = 0;
		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i);
			total += getVal(name) * (i+1);
		}
		System.out.println("Problem22 - Total name scores: " + total);
	}
}