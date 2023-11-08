package com.jdlc.asteroids;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public abstract class GameObject {
	
	public Random random = new Random();
	private Point2D coordinates;
	private int color;
	
	// Constructor for Game Objects with randomized initial location
	public GameObject() {
		double x = random.nextInt(1024);
		double y = random.nextInt(768);
		
		coordinates = new Point2D(x,y);
	}
	
	// Returns the integer rgb value assigned to the Game Object
	public int getColor() {
		return color;
	}
	
	// Sets the integer rgb value for the Game Object
	public void setColor(int r, int g, int b) {
		color = ColorUtil.rgb(r, g, b);
	}
	
	// Returns Point2D coordinates of Game Object
	public Point2D getCoordinates() {
		return coordinates;
	}
	
	// Sets x and y coordinates of the Game Object
	public void setLocation(double x, double y) {
		coordinates.setX((double)Math.round(x));
		coordinates.setY((double)Math.round(y));
	}
	
	public String toString() {
		return "loc = " + coordinates.getX() + ", " + coordinates.getY() + " color = [" + 
	ColorUtil.red(color) + ", " + ColorUtil.green(color) + ", " + ColorUtil.blue(color) + "] ";
	}

}
