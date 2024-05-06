package com.jdlc.asteroids.Interfaces;
import com.jdlc.asteroids.GameObjects.GameObject;

public interface ICollection {
	
	// Adds the passed object "obj" to the list
	public void addObject(GameObject obj);
	
	// Returns Iterator to manage the collection of GameObjects
	public IIterator getIterator();
	
	// Returns integer value of the total size of the collection of GameObjects
	public int getSize();
}
