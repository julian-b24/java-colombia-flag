package ui;

import model.Color;
import thread.ColorThread;

public class Main {

	public final static String ESC   = "\u001b[";
	public final static String UP    = ESC+"A";
	public final static String DOWN  = ESC+"B";
	public final static String RIGHT = ESC+"C";
	public final static String LEFT  = ESC+"D";
	public final static String NXLN  = ESC+"1E";
	
	public final static int YELLOW = 43;
	public final static int BLUE = 44;
	public final static int RED = 41;

	public static void main(String[] args) throws InterruptedException {
		
		char ch = ' ';
		int max_width = 25;
		
		System.out.print(ESC+"2J");
		
		Color yellow = new Color(YELLOW, 15, ch, 0, 0);
		Color blue = new Color(BLUE, 5, ch, 0, 15);
		Color red = new Color(RED, 5, ch, 0, 20);
		
		ColorThread yellowThread = new ColorThread(yellow, 0, 15, 0, 100);
		ColorThread blueThread = new ColorThread(blue, 16, 20, 0, 100);
		ColorThread redThread = new ColorThread(red, 21, max_width, 0, 100);
		
		yellowThread.start();
		blueThread.start();
		redThread.start();
		
		yellowThread.join();
		blueThread.join();
		redThread.join();
		
		
		System.out.println("\u001b[49m");
	}
}
