
   /*
    *   AStarfarer81.java
    *
    *   Jan 8, 2016
    */
package Pathfinding.AStar;

import Pathfinding.Pathfindable;
import java.util.ArrayList;
import java.util.HashMap;

    /* 
     * @author Per Eresund
     */

public final class AStarfarer81 {
	private static final double weight = 1;
	
	public static int getX(long pos) {
		return (int)pos;
	}
	
	public static int getY(long pos) {
		return (int)(pos >> 32);
	}
	
	public static long getPos(int x, int y) {
		return (long)x + ((long)y << 32);
	}
	
	static int getHeuristic(long srcPos, long trgPos) {
		return 1;
//		return Math.abs(getX(srcPos) - getX(trgPos)) + Math.abs(getY(srcPos) - getY(trgPos));
//		double h = (Math.abs(getX(srcPos) - getX(trgPos)) + Math.abs(getY(srcPos) - getY(trgPos))) * weight;
//		int dx = getX(srcPos) - getX(trgPos);
//		int dy = getY(srcPos) - getY(trgPos);
//		h = Math.sqrt(dx*dx + dy*dy) * h;
//		return (int)h;
	}
	
	static int getCost(long srcPos, long trgPos, Pathfindable[][] map) {
		return map[getX(trgPos)][getY(trgPos)].getCost();
	}
	
	private Pathfindable[][] map;
	private long srcPos, trgPos;
	
	private final ArrayList<Position> frontier;
	private final HashMap<Long, Long> cameFrom;
	private final HashMap<Long, Integer> costSoFar;
	
	public ArrayList<Long> path;
	
	public AStarfarer81(Pathfindable[][] map, int srcX, int srcY, int trgX, int trgY) {
		this.map = map;
		srcPos = getPos(srcX, srcY);
		trgPos = getPos(trgX, trgY);
		
		frontier = new ArrayList<>();
		cameFrom = new HashMap<>();
		costSoFar = new HashMap<>();
		path = new ArrayList<>();
	}
	
	public void setPoses(Pathfindable[][] map, int srcX, int srcY, int trgX, int trgY) {
		long newSrc = getPos(srcX, srcY);
		long newTrg = getPos(trgX, trgY);
		
		if (srcPos != newSrc || trgPos != newTrg || this.map != map) {
			path.clear();
			this.map = map;
			srcPos = newSrc;
			trgPos = newTrg;
		}
	}
	
	boolean isWalkable(long pos) {
		return isWalkable(getX(pos), getY(pos));
	}
	
	boolean isWalkable(int x, int y) {
		if (x < 0 || y < 0 || x >= map.length ||y >= map[0].length) return false;
		if (map[x][y] != null) if (!map[x][y].isWalkable()) return false;
		return true;
	}
		
	
	/*
	 * 
	 * Neighbor indices:
	 * - 0 -
	 * 1 - 2
	 * - 3 -
	 * 
	 */
	void getNeighbors(long pos, long[] neighbors) {
		int x = getX(pos);
		int y = getY(pos);
		
//		neighbors[0] = getPos(x, y-1);
//		neighbors[1] = getPos(x-1, y);
//		neighbors[2] = getPos(x+1, y);
//		neighbors[3] = getPos(x, y+1);
		
		neighbors[0] = getPos(x+1, y);
		neighbors[1] = getPos(x, y+1);
	}
	
	void addPrioritized(long pos, int priority, int heuristic) {
		Position newPos = new Position(pos, priority, heuristic);
		for (int i = 0; i < frontier.size(); i++) {
			Position checkPos = frontier.get(i);
			if (checkPos.compareTo(newPos) < 0) {
				frontier.add(i, newPos);
				return;
			}
		}
		frontier.add(newPos);
	}
	
	void printFrontier() {
		int i = 0;
		for(Position p : frontier) {
			System.out.println("i: " + i++ + ", prio: " + p.priority);
		}
	}
	
	public void start() {
		frontier.clear();
		cameFrom.clear();
		costSoFar.clear();
		
		addPrioritized(srcPos, 0, 0);
		printFrontier();
		costSoFar.put(srcPos, getCost(0, srcPos, map));
		
		long current, next;
		long[] neighbors = new long[2];
		int newCost, priority;
		int a = 0;
		while(!frontier.isEmpty()) {
			current = frontier.get(0).pos;
			frontier.remove(0);
			
			if (current == trgPos) {
				break;
			}
			
			getNeighbors(current, neighbors);
			
			for (int i = 0; i < neighbors.length; i++) {
				
				next = neighbors[i];
//				if (!isWalkable(next) && next != trgPos) continue;
				if (!isWalkable(next)) continue;
				
				newCost = costSoFar.get(current) + getCost(current, next, map);
				
				boolean goThrough = false;
				if (!costSoFar.containsKey(next)) {
					goThrough = true;
				} else if (newCost < costSoFar.get(next)) {
					goThrough = true;
				}
				if (!goThrough) continue;
				
				costSoFar.put(next, newCost);
				cameFrom.put(next, current);
				a++;
				int heuristic = getHeuristic(next, trgPos);
				priority = newCost + heuristic;
				addPrioritized(next, priority, heuristic);
			}
		}
		System.out.println("a: " + ++a);
	}
	
	public void generatePath() {
		ArrayList<Long> lastPath = (ArrayList<Long>) path.clone();
		path.clear();
		try {
			long next = trgPos;
			while (next != -1L) {
				path.add(0, next);
				next = cameFrom.getOrDefault(next, -1L);
			}
		} catch (java.lang.NullPointerException e) {
			if (cameFrom.containsKey(trgPos)) {
				path = lastPath;
			} else {
				path.clear();
			}
		}
	}
	
	public void generatePath(int x, int y) {
		ArrayList<Long> lastPath = (ArrayList<Long>) path.clone();
		path.clear();
		long trgPos = getPos(x, y);
		try {
			long next = trgPos;
			while (next != -1L) {
				path.add(0, next);
				next = cameFrom.getOrDefault(next, -1L);
			}
		} catch (java.lang.NullPointerException e) {
			if (cameFrom.containsKey(trgPos)) {
				path = lastPath;
			} else {
				path.clear();
			}
		}
	}
	
	public int getCost(int x, int y) {
		long pos = getPos(x, y);
		return costSoFar.get(pos);
	}
}