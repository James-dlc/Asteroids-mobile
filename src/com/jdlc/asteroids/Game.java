package com.jdlc.asteroids;
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
		
	}
}
