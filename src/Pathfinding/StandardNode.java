/*
 * StandardNode.java
 *
 * Jan 3, 2016
 */
package Pathfinding;

/* 
 * @author Per Eresund
 */
public class StandardNode implements Pathfindable {
	private int cost;
	private boolean isWalkable;

	public StandardNode(int cost, boolean isWalkable) {
		this.cost = cost;
		this.isWalkable = isWalkable;
	}
	
	@Override
	public boolean isWalkable() {
		return isWalkable;
	}

	@Override
	public int getCost() {
		return cost;
	}
}