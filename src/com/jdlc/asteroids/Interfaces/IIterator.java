package com.jdlc.asteroids.Interfaces;
import com.jdlc.asteroids.GameObjects.GameObject;

public interface IIterator {
	
	// Checks to see if there are objects in the list and returns true if there are or false if it's empty
	public boolean hasNext();
	
	// Returns the next GameObject in the list
	public GameObject getNext();
	
	// Returns the current object in the list
	public GameObject getCurrentObj();
	
	// Removes current GameObject in the list
	public void removeObj();
	
	// Removes passed GameObject from the list
	public void removeObj(GameObject obj);
	
}
