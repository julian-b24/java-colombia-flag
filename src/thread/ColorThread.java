package thread;

import java.util.Random;

import model.Color;

public class ColorThread extends Thread{
	
	public final static String ESC   = "\u001b[";
	public final static String UP    = ESC+"A";
	public final static String DOWN  = ESC+"B";
	public final static String RIGHT = ESC+"C";
	public final static String LEFT  = ESC+"D";
	public final static String NXLN  = ESC+"1E";
	
	private Color color;
	private int minY;
	private int maxY;
	private int minX;
	private int maxX;
	private int sleep;

	public ColorThread(Color col, int mnY, int mxY, int mnX, int mxX) {
		color = col;
		minY = mnY;
		maxY = mxY;
		minX = mnX;
		maxX = mxX;
		sleep = getRandomSleep();
	}
	
	@Override
	public synchronized void run() {
		
		for (int j = minX; j <= maxX; j++) {
			for (int i = minY; i <= maxY; i++) {
				
				System.out.print(ESC+ color.getCurrentX() +"G"+ESC + color.getCurrentY() +"d");
				System.out.print(ESC + color.getCode() + "m" + color.getChar());
				System.out.print(DOWN + UP);
				color.moveY(minY, maxY);
				try {
					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			color.moveX();
		}
	}
	
	public int getRandomSleep() {
		Random random = new Random();
		return random.nextInt(40) + 10;
	}
}
