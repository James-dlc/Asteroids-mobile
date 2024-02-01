package com.jdlc.asteroids;

import java.util.Vector;

import com.jdlc.asteroids.Missile.MissileSource;;

public class GameWorld {
	public Vector<GameObject> gwObjects;
	
	private int score;
	private int time;
	private int lives;
	private boolean gameOver;
	
	// initializes GameWorld with starting variable values
	public void init() {
		gwObjects = new Vector<GameObject>();
		
		score = 0;
		time = 0;
		lives = 3;
		gameOver = false;
	}
	
	/*
	 *  Methods to create game objects: ASTEROIDS, PLAYER SHIP, NON-PLAYER SHIPS, AND SPACE STATIONS
	 */
	
	// Adds an asteroid to the game world
	public void addAsteroid() {
		Asteroid asteroid = new Asteroid();
		gwObjects.add(asteroid);
		System.out.println("An ASTEROID has been created.");
	}
	
	// Adds an NPS to the game world
	public void addNPS() {
		NonPlayerShip nps = new NonPlayerShip();
		gwObjects.add(nps);
		System.out.print("A NON-PLAYER SHIP has been created.");
	}
	
	// Adds a Space Station to the game world
	public void addSpaceStation() {
		SpaceStation ss = new SpaceStation();
		gwObjects.add(ss);
		System.out.print("A BLINKING SPACE STATION has been created.");
	}
	
	// Adds Player Ship to the game world
	public void addPlayerShip() {
		// Checking Vector to see if there is already a Player Ship in it
		if (findPlayerShip() != null) {
			System.out.println("There is already a PLAYER SHIP in the game.");
			return;
		}
		// If there is no Player Ship in the Vector then the following creates and adds to Vector
		else {
			PlayerShip ps = new PlayerShip();
			gwObjects.add(ps);
			System.out.println("A new PLAYER SHIP has been created.");
		}

	}
	
	/*
	 * End of Game Object creation methods
	 */
	
	
	
	
	/*
	 * PLAYER SHIP and NON-PLAYER SHIP functionality methods: firing missiles
	 * reloading, turning, rotating launcher, speeding up, slowing down
	 */
	
	// Increases current Player Ship's speed
	public void incPlayerShipSpeed() {
		PlayerShip ps = findPlayerShip();
		ps.incSpeed();
	}
	
	// Decreases current Player Ship's speed
	public void decPlayerShipSpeed() {
		PlayerShip ps = findPlayerShip();
		ps.decSpeed();
	}
	
	// Adjusts Player Ship direction to the left
	public void turnLeft() {
		PlayerShip ps = findPlayerShip();
		ps.steer(1);
	}
	
	// Adjusts Player Ship direction to the right
	public void turnRight() {
		PlayerShip ps = findPlayerShip();
		ps.steer(-1);
	}
	
	// Rotate the ship's missile launcher counter-clockwise
	public void rotateLauncherL() {
		PlayerShip ps = findPlayerShip();
		ps.steerLauncher(1);
	}
	
	// Rotate the ship's missile launcher clockwise
	public void rotateLauncherR() {
		PlayerShip ps = findPlayerShip();
		ps.steerLauncher(-1);
	}
	
	// Fire Player Ship's missiles if they have any, if not prompt player.
	public void fireMissile() {
		PlayerShip ps = findPlayerShip();
		if (ps.getMissileCount() > 0) {
			ps.fire();
			return;
		}
		else {
			System.out.println("Player Ship is out of missiles.");
		}
	}
	
	// Reload Player Ship's missiles
	public void reloadPlayerShip() {
		PlayerShip ps = findPlayerShip();
		ps.reload();
	}
	
	// Places Player Ship's location at center of map
	public void center() {
		PlayerShip ps = findPlayerShip();
		ps.center();
	}
	
	
	// Fire Non-Player Ship missile if it has any left
	public void fireNPSMissile() {
		NonPlayerShip nps = findNonPlayerShip();
		if (nps.getMissileCount() > 0) {
			nps.fire();
			return;
		}
		else {
			System.out.println("Non-Player Ship is out of missiles.");
		}
	}
	
	
	/*
	 * End PLAYER SHIP, NON-PLAYER SHIP functionality methods
	 */
	
	
	
	
	/*
	 * Destruction methods
	 */
	
	// Player Ship's missile hits an asteroid
	// The 'find' methods will look for and remove the objects: missile and asteroid and add 10 to score
	public void asteroidDestroyed() {
		String playerMissile = "PLAYERSHIP";
		removeMissile(playerMissile);
		removeAsteroid();
		
		score += 10;
	}
	
	// Player Ship's missile hits a Non-Player Ship
	public void npsDestroyed() {
		String playerMissile = "PLAYERSHIP";
		removeMissile(playerMissile);
		removeNPS();
		
		score += 15;
	}
	
	// Player Ship destroyed by NPS missile (lose life)
	public void missileHitPS() {
		String npsMissile = "NONPLAYERSHIP";
		removeMissile(npsMissile);
		removePlayerShip();
		
		lives--;
	}
	
	
	// Player Ship destroyed by asteroid collision (lose life)
	public void asteroidCollisionPS() {
		removeAsteroid();
		removePlayerShip();
		
		lives--;
	}
	
	// Player Ship collision with Non-Player Ship (lose life)
	public void npsCollisionPS() {
		removeNPS();
		removePlayerShip();
		
		lives--;
	}
	
	// Asteroid collision with another asteroid
	public void asteroidCollisionAsteroid() {
		removeAsteroid();
		removeAsteroid();
		
	}
	
	// Non-Player Ship collision with asteroid
	public void npsCollisionAsteroid() {
		removeNPS();
		removeAsteroid();
	}
	
	/*
	 * End of destruction methods
	 */
	
	
	
	
	/*
	 * Game "engine" methods
	 */
	
	// With each clock "tick", every game object that's an instance of IMoveable has it's
	// move() method called. If the object is also a Missile, there's a check to see if the
	// missile still has enough fuel to exist. If it doesn't it is removed from the vector list
	public void gameClockTick() {
		for (int i = 0; i < gwObjects.size(); i++) {
			// Checks if object is able to call the move() method (extends IMovable)
			if (gwObjects.elementAt(i) instanceof IMovable) {
				// Missile fuel check and removal block
				if (gwObjects.elementAt(i) instanceof Missile) {
					Missile missile = (Missile) gwObjects.elementAt(i);
					
					// If missile is out of fuel then remove missile and decrement i for counter so
					// next object isn't skipped from the removal method. 
					if (missile.getFuel() == 0) {
						gwObjects.remove(i);
						i--;
						continue;
					}
					// If missile still has fuel then the move method is called. **Fuel is "consumed"
					// in Missile's overwritten move method.
					missile.move();
					continue;
				}
				
				// Space Station check and blink call
				if (gwObjects.elementAt(i) instanceof SpaceStation) {
					SpaceStation spaceStation = (SpaceStation) gwObjects.elementAt(i);
					spaceStation.blink(time);
					continue;
				}
				
				// All other movable objects call their move method
				IMovable moveGWObject = (IMovable) gwObjects.get(i);
				moveGWObject.move();
				
			}
		}
		
		time++;
	}
	
	// Prints all objects in the game world vector list
	public void map() {
		System.out.flush();
		for (int i = 0; i < gwObjects.size(); i++){
			System.out.println(gwObjects.get(i));
		}
	}
	
	/*
	 * End game "engine" methods
	 */
	
	
	
	
	/*
	 * Search algorithms
	 */
	
	// Search for and return Player Ship  
	public PlayerShip findPlayerShip() {
		for (int i = 0; i < gwObjects.size(); i++) {
			if (gwObjects.elementAt(i) instanceof PlayerShip) {
				PlayerShip ps = (PlayerShip) gwObjects.elementAt(i);
				return ps;
			}
		}
		System.err.println("Player Ship not found.");
		return null;
	}
	
	// Search for and return Non-Player Ship
	public NonPlayerShip findNonPlayerShip() {
		for (int i = 0; i < gwObjects.size(); i++) {
			if (gwObjects.elementAt(i) instanceof NonPlayerShip) {
				NonPlayerShip nps = (NonPlayerShip) gwObjects.elementAt(i);
				return nps;
			}
		}
		System.err.println("Non-Player Ship not found.");
		return null;
	}
	
	// Search for and remove Missile. Parameter determines whether it is from PS or NPS
	// Using same search algorithm to find instance of missile. Once it's found, there's a check
	// to see if it's from the PS or NPS.
	// The parameters take in who the shooter is 
	// **** that parameter may not be needed since there will be a collision check later to make sure
	// **** that the right colliding objects are removed
	private void removeMissile(String missileShooter) {
		for (int i = 0; i < gwObjects.size(); i++) {
			if (gwObjects.elementAt(i) instanceof Missile) {
				Missile missile = (Missile) gwObjects.elementAt(i);
				
				// Later will add a collision detect/coordinate check to make sure the right missile
				// was found if needed.
				if (missile.getSource() == missileShooter) {
					gwObjects.removeElementAt(i);
				}
			}
		}
		System.err.println("Missile not found.");
	}
	
	
	// Search for and remove Asteroid
	public void removeAsteroid() {
		for (int i = 0; i < gwObjects.size(); i++) {
			if (gwObjects.elementAt(i) instanceof Asteroid) {
				Asteroid asteroid = (Asteroid) gwObjects.elementAt(i);
				// Later will add a collision detect/coordinate check to make sure the right asteroid
				// was found 
				gwObjects.removeElementAt(i);
			}
		}
		System.err.println("Asteroid not found.");
	}
	
	// **** test removeElement vs removeElementAt 
	// Calls the search for NPS then removes from gwObjects
	public void removeNPS() {
		NonPlayerShip nps = findNonPlayerShip();
		gwObjects.removeElement(nps);
	}
	// **** test **** //
	
	// Finds and removes Player Ship
	public void removePlayerShip() {
		for (int i = 0; i < gwObjects.size(); i++) {
			if (gwObjects.elementAt(i) instanceof PlayerShip) {
				PlayerShip ps = (PlayerShip) gwObjects.elementAt(i);
				gwObjects.removeElementAt(i);
			}
		}
		System.err.println("Player Ship not found.");
	}
}









