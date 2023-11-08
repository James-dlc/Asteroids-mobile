package com.jdlc.asteroids;

public class SpaceStation extends FixedGameObject{
	
	private int id;
	private int blinkRate;
	private boolean lightOn;
	
	public SpaceStation() {
		id = getfId();
		blinkRate = random.nextInt(9) + 1;
		lightOn = true;
		setColor(0, 255, 0);
	}
	
	
}
