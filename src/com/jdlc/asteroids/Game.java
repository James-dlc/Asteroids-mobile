package com.jdlc.asteroids;
import com.codename1.ui.Form;

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
		
	}
}
