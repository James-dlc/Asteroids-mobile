package com.jdlc.asteroids;

import java.util.Observable;
import java.util.Observer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;
import com.jdlc.asteroids.GameWorldProxy;
import com.jdlc.asteroids.Interfaces.IIterator;

public class MapView  extends Container implements Observer{

	TextArea gameText;
	
	
	// Creation and setup of container to display game objects
	public MapView() {
		this.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.GREEN));
		this.setLayout(new BorderLayout());
		
		gameText = new TextArea();
		gameText.setEditable(false);
		gameText.getAllStyles().setBgTransparency(0);
		
		this.setWidth(1024);
		this.setHeight(768);
		
		this.add(BorderLayout.NORTH, gameText);
	}
	
	// Returns width of the map view
	public double getMapWidth() {
		return (double) this.getWidth();
	}
	
	//Returns height of the map view
	public double getMapHeight() {
		return (double) this.getHeight();
	}
	
	
	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		GameWorldProxy tempProxy = (GameWorldProxy) data;
		IIterator iterator = tempProxy.getCollection().getIterator();
		String fullText = "";
		
		while (iterator.hasNext()) {
			fullText += iterator.getNext().toString()+ "\n";
		}
		
		gameText.setText(fullText);
		this.repaint();
	}

	
}
