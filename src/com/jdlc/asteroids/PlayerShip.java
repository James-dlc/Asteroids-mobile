package com.jdlc.asteroids;

public class PlayerShip extends MovableGameObject implements ISteerable{
	
	private static final int MAXMISSILES = 10;
	private int missileCount;
	private MissileLauncher launcher;
	
	// Speed, angle, color, and spawning location all from GameObject class. Defaults are
	// 0 speed, ship faces top of screen, same teal color as space station, and ship spawns
	// center of screen. 
	// Instance of MissileLauncher and missileCount starts off at max amount.
	public PlayerShip() {
		setSpeed(0);
		setAngle(90);
		setColor(64, 224, 208);
		setCoordinates(512, 384);
		launcher = new MissileLauncher(0);
		missileCount = MAXMISSILES;
		
	}
	
	// Increases speed by 1
	public void incSpeed() {
		if (getSpeed() <= 10) {
			setSpeed(getSpeed() + 1);
			return;
		}
		System.out.println("Player Ship at max speed!");
	}
	
	// Decreases speed by 1
	public void decSpeed() {
		if (getSpeed() >= 0) {
			setSpeed(getSpeed() - 1);
			return;
		}
		System.out.println("Player Ship at lowest speed.");
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
	
	@Override
	public void move() {
		super.move();
	}
	
	public void steerLauncher(int deltaAngle) {
		launcher.steer(deltaAngle);
	}
	
	public int getLauncherAngle() {
		return launcher.getAngle();
	}
	
	public int getMissileCount() {
		return missileCount;
	}
	
	public void fire() {
		missileCount--;
	}
	
	public void reload() {
		missileCount = MAXMISSILES;
	}
	
	public void center() {
		setCoordinates(512, 384);
	}
	
	
	public String toString() {
		String parentString = super.toString();
		String thisString = " missiles = " + missileCount;
		return "Player Ship: " + parentString + thisString + launcher.toString();
	}
	
}
