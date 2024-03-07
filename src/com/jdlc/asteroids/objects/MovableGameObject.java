package com.jdlc.asteroids.objects;

import com.codename1.ui.geom.Point2D;
import com.jdlc.asteroids.interfaces.IMovable;

public abstract class MovableGameObject extends GameObject implements IMovable{
	
	private int speed;
	private int angle;
	
	// Every movable object is first initialized to random speed and angle. 
	// Certain movable objects will have their own presets, like PlayerShip
	// PlayerShip has a speed range of 0 - 10, while everything else that moves
	// has a speed range of 1 - 10
	public MovableGameObject() {
		speed = random.nextInt(10) + 1;
		angle = random.nextInt(360);
	}
	
	// Returns object's speed
	public int getSpeed() {
		return speed;
	}
	
	// Sets object's speed to s
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}
	
	// Returns object's angle
	public int getAngle() {
		return angle;
	}
	
	// Sets object's angle to a
	public void setAngle(int newAngle) {
		angle = newAngle;
	}
	
	// Override move() method
	public void move() {
		Point2D oldCoord = getCoordinates();
		int newX = 0;
		int newY = 0;
		
		newX = (int) (Math.cos(Math.toRadians(angle)) * speed);
		newY = (int) (Math.sin(Math.toRadians(angle)) * speed);
		
		setCoordinates(oldCoord.getX() + newX, oldCoord.getY() + newY);
		
	}
	
	public String toString() {
		String parentString = super.toString();
		String thisString = "speed = " + speed + " angle = " + angle + " ";
		return parentString + thisString;
	}
}