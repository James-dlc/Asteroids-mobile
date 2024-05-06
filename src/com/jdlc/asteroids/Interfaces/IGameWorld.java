package com.jdlc.asteroids.Interfaces;
import java.util.Vector;

import com.jdlc.asteroids.GameCollection;
import com.jdlc.asteroids.GameObjects.GameObject;

public interface IGameWorld {
	
	// Returns an integer value of the current score
	public int getScore();
	
	// Returns an integer value of the current time
	public int getTime();
	
	// Returns an integer value of the player's current lives
	public int getLives();
	
	// Returns an integer value of the PlayerShip's current missile count
	public int getMissileCount();
	
	// Returns a boolean value if the sound is enabled
	public boolean getSoundSetting();
	
	// Returns the GameCollection
	public Vector<GameObject> getCollection();
}
