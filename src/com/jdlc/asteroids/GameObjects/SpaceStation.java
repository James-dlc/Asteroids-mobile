package com.jdlc.asteroids.GameObjects;

public class SpaceStation extends FixedGameObject{
	
	private int id;
	private int blinkRate;
	private boolean lightOn;
	
	// Initializes Space Station with a unique ID, random blink rate from 1-4 game ticks,
	// boolean that determines if the Space Station light is on, and a teal color rgb code.
	public SpaceStation() {
		id = getfId();
		blinkRate = random.nextInt(4) + 1;
		lightOn = true;
		setColor(64, 224, 208);
	}
	
	// This method works with GameWorld's tick method; the game's "clock". The Space Station
	// will blink every game tick, or every 2nd, 3rd, or 4th tick.
	public void blink(int currTick) {
		if (currTick % blinkRate == 0) {
			lightOn ^= true;
		}
	}
	
	// Returns Space Station's blink rate
	public int getRate() {
		return blinkRate;
	}
	
	// Returns Space Station's ID
	public int getId() {
		return id;
	}
	
	// Overriding toString method to correctly print the details of the object and calls
	// parent (GameObject) details as well
	public String toString() {
		String parentString = super.toString();
		String thisString = "ID: " + id + " blink rate = " + blinkRate;
		return "Station: " + parentString + thisString;
	}
}