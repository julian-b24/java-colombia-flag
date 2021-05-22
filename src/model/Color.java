package model;

public class Color {
	
	private int code;
	private int width;
	private char ch;
	
	private int currentX;
	private int currentY;

	
	public Color(int cod, int wid, char c, int currX, int currY) {
		code = cod;
		width = wid;
		ch = c;
		setCurrentX(currX);
		setCurrentY(currY);
	}
	
	public synchronized void moveX() {
		currentX++;
	}
	
	public synchronized void moveY(int min, int max) {
		if(currentY >= max) {
			currentY = min;
		} else {
			currentY++;
		}
	}
	
	public int getCode() {
		return code;
	}
	
	public int getWidth() {
		return width;
	}
	
	public char getChar() {
		return ch;
	}

	public int getCurrentY() {
		return currentY;
	}

	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}

	public int getCurrentX() {
		return currentX;
	}

	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

}
