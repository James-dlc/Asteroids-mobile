package com.jdlc.asteroids;

import java.util.Observable;
import com.jdlc.asteroids.Interfaces.IGameWorld;

public class GameWorldProxy extends Observable implements IGameWorld{

	private GameWorld gwp;
	
	// GameWorldProxy is basically a "buffer" between the data being sent from GameWorld to the Views
	public GameWorldProxy(GameWorld gw) {
		gwp = gw;
	}
	
	
	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return gwp.getScore();
	}

	@Override
	public int getTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLives() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMissileCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getSoundSetting() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GameCollection getCollection() {
		// TODO Auto-generated method stub
		return null;
	}

}
