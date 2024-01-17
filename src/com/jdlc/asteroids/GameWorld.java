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
	 * End of creation methods
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
	public void asteroidDestroyed() {
		Missile missileObj = FindMissile(MissileSource.PLAYERSHIP);
	}
	
	// Player Ship's missile hits a Non-Player Ship
	public void npsDestroyed() {
		
	}
	
	// Player Ship destroyed by NPS missile (lose life)
	public void missileHitPS() {
		
	}
	
	
	// Player Ship destroyed by asteroid collision (lose life)
	public void asteroidCollisionPS() {
		
	}
	
	// Player Ship collision with Non-Player Ship (lose life)
	public void npsCollisionPS() {
		
	}
	
	// Asteroid collision with another asteroid
	public void asteroidCollisionAsteroid() {
		
	}
	
	// Non-Player Ship collision with asteroid
	public void npsCollisionAsteroid() {
		
	}
	
	/*
	 * End of destruction methods
	 */
	
	
	
	
	/*
	 * Game "engine" methods
	 */
	
	public void gameClockTick(int time) {
		
	}
	
	// Prints all objects in the game world vector list
	public void map() {
		
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
	
	// Search for and return Missile. Parameter determines whether it is from PS or NPS
	private Missile findMissile(String missileType) {
		for (int i = 0; i < gwObjects.size(); i++) {
			if (gwObjects.elementAt(i) instanceof Missile) {
				Missile missile = (Missile) gwObjects.elementAt(i);
				//if (missile.getSource() == missileType) {
					
					return missile;
				}
			}
		}
		System.err.println("Missile not found.");
		return null;
	}
	
	
	// Search for and return Asteroid
	public Asteroid findAsteroid() {
		for (int i = 0; i < gwObjects.size(); i++) {
			if (gwObjects.elementAt(i) instanceof Asteroid) {
				Asteroid asteroid = (Asteroid) gwObjects.elementAt(i);
				return asteroid;
			}
		}
		System.err.println("Asteroid not found.");
		return null;
	}
	
}









