package com.jdlc.asteroids;

public class Asteroid extends MovableGameObject{
	
	private int size = 0;
	
	// Constructor that randomizes Asteroid color and size between 6 and 30
	public Asteroid() {
		setColor(random.nextInt(256), random.nextInt(256), random.nextInt(256));
		size = random.nextInt(25) + 6;
	}
	
	// Returns Asteroid size
	public int getSize() {
		return size;
	}
	
	// Overrides move to MovableGameObject
	public void move() {
		super.move();
	}
	
	public String toString() {
		String parentString = super.toString();
		String thisString = " size = " + size;
		return "Asteroid: " + parentString + thisString;
	}
}