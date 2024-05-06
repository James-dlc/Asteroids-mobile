package com.jdlc.asteroids.GameObjects;

public abstract class FixedGameObject extends GameObject{
	
	private static int fId = 0;
	
	// Initializes and holds unique fixed ID
	public FixedGameObject() {
		fId++;
	}
	
	// Returns the fixed ID
	public int getfId() {
		return fId;
	}
}
