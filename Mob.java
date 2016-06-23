package com.thecherno.rain.entity.mob;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.graphics.Sprite;

public abstract class Mob extends Entity{
	
	//we add sprite for our mob
	protected Sprite sprite;
	protected int dir = 0; //dir direction 0 north, 1 east, 2 south, 3 west
	protected boolean moving = false;
	
	public void move(){
		
	}
	
	public void update(){
		
	}
	
	private boolean collision(){
		//return false is add to just get rid off the error
		return false;
	}
	
	

}
