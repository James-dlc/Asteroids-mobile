package com.jdlc.asteroids.gamelaws;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent; 
import java.lang.String;

public class Game extends Form{
	private GameWorld gw;
	
	// Initializes a game
	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}
	
	// Method to place player input/controls which the functions will be in GameWorld
	private void play() {
		Label myLabel = new Label("Enter a Command:");
		this.addComponent(myLabel);

		final TextField myTextField = new TextField();
		this.addComponent(myTextField);

		this.show();
		myTextField.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent evt) {
				String sCommand=myTextField.getText().toString();
				myTextField.clear();
				if (!sCommand.equals(null) && sCommand.length() > 0) {
					
					switch (sCommand.charAt(0)){
						case 'e':
							// PS destroys NPS
							gw.npsDestroyed();
							break;
						case 'a':
							// Spawn Asteroid
							gw.addAsteroid();
							break;
						case 'y':
							// Spawn NPS
							gw.addNPS();
							break;
						case 'b':
							// Spawn Space Station
							gw.addSpaceStation();
							break;
						case 's':
							// Spawn PS
							gw.addPlayerShip();
							break;
						case 'i':
							// Increase PS's speed
							gw.incPlayerShipSpeed();
							break;
						case 'd':
							// Decrease PS's speed
							gw.decPlayerShipSpeed();
							break;
						case 'l':
							// PS turns left
							gw.turnLeft();
							break;
						case 'r':
							// PS turns right
							gw.turnRight();
							break;
						case '<':
							// Rotates launcher counter-clockwise
							gw.rotateLauncherL();
							break;
						case '>':
							// Rotates launcher clockwise
							gw.rotateLauncherR();
							break;
						case 'f':
							// PS fires missile
							gw.fireMissile();
							break;
						case 'L':
							// NPS fires missile
							gw.fireNPSMissile();
							break;
						case 'j':
							// PS centered on middle screen
							gw.center();
							break;
						case 'n':
							// PS reload missiles
							gw.reloadPlayerShip();
							break;
						case 'k':
							// PS destroys Asteroid
							gw.asteroidDestroyed();
							break;
						case 'E':
							// NPS kills PS
							gw.missileHitPS();
							break;
						case 'c':
							// PS crashes into asteroid
							gw.asteroidCollisionPS();
							break;
						case 'h':
							// PS crashes into NPS
							gw.npsCollisionPS();
							break;
						case 'x':
							// Asteroids collide with each other
							gw.asteroidCollisionAsteroid();
							break;
						case '|':
							// Asteroid collide with NPS
							gw.npsCollisionAsteroid();
							break;
						case 't':
							// Advance the game 1 game clock "tick"
							gw.gameClockTick();
							break;
						case 'p':
							// Displays current game stats
							gw.gameStats();
							break;
						case 'm':
							// Displays all game object locations and other details
							gw.map();
							break;
						case 'q':
							//set isQuitting to true so that entering "y" allows user to quit or "n" cancels
							if (gw.endGame() == true) {
								System.exit(0);
							
							}
							break;
						default:
							System.out.println("Error, not a valid command");
							break;
					} //if statement
				} //switch
			}//actionPerformed
		} //new ActionListener()
	); //addActionListener*/
	}
}
