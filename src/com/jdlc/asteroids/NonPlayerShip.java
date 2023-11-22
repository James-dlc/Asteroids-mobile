package com.jdlc.asteroids;

public class NonPlayerShip extends MovableGameObject{
	private static final int MAXENEMYMISSILES = 2;
	private int size;
	private int missileCount;
	
	// NPS size are either 10 or 20 (small or large), capped off at 2 missiles and are red.
	public NonPlayerShip() {
		size = (random.nextInt(2) + 1) * 10;
		missileCount = MAXENEMYMISSILES;
		setColor(255, 0, 0);
	}
	
	public int getSize() {
		return size;
	}
	
	public int getMissileCount() {
		return missileCount;
	}
	
	public void fire() {
		missileCount--;
	}
	
	@Override
	public void move() {
		super.move();
	}
	
	
	public String toString() {
		String parentString = super.toString();
		String thisString = " size = " + size;
		return "Non-Player Ship: " + parentString + thisString;
	}
}
