package com.jdlc.asteroids.GameObjects;

import com.codename1.ui.geom.Point2D;

public class Missile extends MovableGameObject{
	
	private int fuelLevel;
	private String missileSource;
	
	// Missiles are tied with either the Player's or NPS's coordinates and speed.
	// Using missileSource enum to determine who shot the missile.
	// If missiles are from PLayerShip then they are blue but if they are from
	// NPS then they are red.
	public Missile(int launcherAngle, int speed, Point2D coord, String source) {
		setAngle(launcherAngle);
		setSpeed(speed);
		setCoordinates(coord.getX(), coord.getY());
		fuelLevel = 10;
		missileSource = source;
		
		if (missileSource == "PLAYERSHIP") {
			setColor(0, 0, 255);
		}
		else if (missileSource == "NONPLAYERSHIP") {
			setColor(255, 0, 0);
		}
		else {
			System.out.println("Missile spawn error. Check calling method's source input.");
		}
	}
	
	public int getFuel() {
		return fuelLevel;
	}
	
	public String getSource() {
		return missileSource;
	}
	
	@Override
	public void move() {
		fuelLevel--;
		super.move();
	}
	
	
	public String toString() {
		String parentString = super.toString();
		String thisString = " fuel = " + fuelLevel;
		if (missileSource == "PLAYERSHIP") {
			return "PS' Missile: " + parentString + thisString;
		}
		else {
			return "NPS' Missile: " + parentString + thisString;
		}
	}
}