package com.thecherno.rain.entity;

import java.util.Random;
import com.sun.glass.ui.Window.Level;
import com.thecherno.rain.graphics.Screen;

public abstract class Entity {
	
	//adding values for our entity because is going to be the character that going to be moving
	public int x, y ;
	public boolean removed =  false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update(){
		
	}
	
	public void render(Screen screen){
		
	}
	
	public void remove(){
		//remove from level
		removed = true;
	}
	
	public boolean isRemoved(){
		return removed;
	}
	

}
