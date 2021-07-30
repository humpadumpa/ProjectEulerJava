   /*
    *   Position.java
    *
    *   Apr 5, 2015
    */
package Pathfinding.AStar;

    /* 
     * @author Per Eresund
     */

public final class Position implements Comparable {
	final long pos;
	final int priority;
	final int heuristic;
	
	Position(long pos, int priority, int heuristic) {
		this.pos = pos;
		this.priority = priority;
		this.heuristic = heuristic;
	}
	
	@Override
	public int compareTo(Object o) {
		if (o == null) return -1;
		if (!(o instanceof Position)) return -1;
		
		Position pos = (Position) o;
		int d = pos.priority - this.priority;
//		if (d == 0) {
//			d = pos.heuristic - this.heuristic;
//		}
		return d;
	}
}