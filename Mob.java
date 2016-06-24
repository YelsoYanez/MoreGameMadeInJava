package com.thecherno.rain.entity.mob;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.graphics.Sprite;

public abstract class Mob extends Entity{
	
	//we add sprite for our mob
	protected Sprite sprite;
	protected int dir = 0; //dir direction 0 north, 1 east, 2 south, 3 west
	protected boolean moving = false;
	
	public void move(int xa, int ya){
		//x and y axis will be constanli changing
		// put in -1 or 0 or 1, also need to check collision
		
		if(xa > 0) dir = 1;
		if(xa < 0) dir = 3;
		if(ya > 0) dir = 2;
		if(ya < 0) dir = 0;
		
		if(!collision()){
			x += xa;
			y += ya;
		
		}
	}
	
	public void update(){
		
	}
	
	private boolean collision(){
		//return false is add to just get rid off the error
		return false;
	}
	
	public void render(){
		
	}
	

}
