package classes;

import java.util.Map;

public class MapOfTheGame {

	private int xBound;
	private int yBound;
	private int startingX;
	private int startingY;
	private int currentX;
	private int currentY;
	private int direction;
	private int oTreasureX;
	private int oTreasureY;
	private int totalTresure;
	private Map<Integer, Integer> treasureXY;
	private int score;
	private int lifetime = 0;
	private String in;

	public int getxBound() {
		return xBound;
	}

	public void setxBound(int xBound) {
		this.xBound = xBound;
	}

	public int getyBound() {
		return yBound;
	}

	public void setyBound(int yBound) {
		this.yBound = yBound;
	}

	public int getStartingX() {
		return startingX;
	}

	public void setStartingX(int startingX) {
		this.startingX = startingX;
	}

	public int getStartingY() {
		return startingY;
	}

	public void setStartingY(int startingY) {
		this.startingY = startingY;
	}

	public int getCurrentX() {
		return currentX;
	}

	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getoTreasureX() {
		return oTreasureX;
	}

	public void setoTreasureX(int oTreasureX) {
		this.oTreasureX = oTreasureX;
	}

	public int getoTreasureY() {
		return oTreasureY;
	}

	public void setoTreasureY(int oTreasureY) {
		this.oTreasureY = oTreasureY;
	}

	public int getTotalTresure() {
		return totalTresure;
	}

	public void setTotalTresure(int totalTresure) {
		this.totalTresure = totalTresure;
	}

	public Map<Integer, Integer> getTreasureXY() {
		return treasureXY;
	}

	public void setTreasureXY(Map<Integer, Integer> treasureXY) {
		this.treasureXY = treasureXY;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLifetime() {
		return lifetime;
	}

	public void setLifetime(int lifetime) {
		this.lifetime = lifetime;
	}

	public String getIn() {
		return in;
	}

	public void setIn(String in) {
		this.in = in;
	}
	
	public void grip() {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Pinch Strength BITCHES!!!");
	}

	@Override
	public String toString() {
		return "MapofTheGame [xBound=" + xBound + ", yBound=" + yBound + ", startingX=" + startingX + ", startingY="
				+ startingY + ", currentX=" + currentX + ", currentY=" + currentY + ", direction=" + direction
				+ ", oTreasureX=" + oTreasureX + ", oTreasureY=" + oTreasureY + ", totalTresure=" + totalTresure
				+ ", treasureXY=" + treasureXY + ", score=" + score + ", lifetime=" + lifetime + ", in=" + in + "]";
	}

}