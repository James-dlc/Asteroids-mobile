package com.jdlc.asteroids;

public class MissileLauncher extends MovableGameObject implements ISteerable{
	
	// Constructor with random or preset angle setting
	public MissileLauncher(int defaultAngle) {
		setAngle(defaultAngle);
	}
	
	// Returns MissileLauncher's current angle
	public int getLauncherAngle() {
		return getAngle();
	}
	
	// Sets the MissileLauncher's angle
	public void setLauncherAngle(int newDegrees) {
		setAngle(newDegrees);
	}
	
	@Override
	// Calls setAngle to input current angle with the added amount in the deltaAngle parameter.
	// Limits range of degrees from 0 - 359 to make sure player can never overflow angle var.
	public void steer(int deltaAngle) {
		if (getAngle() == 359 && deltaAngle > 0) {
			setAngle(0);
			return;
		}
		else if (getAngle() == 0 && deltaAngle < 0) {
			setAngle(359);
			return;
		}
		else {
			setAngle(getAngle() + deltaAngle);
		}
	}
	
	public String toString() {
		return " Missile Launcher Direction = " + getAngle();
	}
}
