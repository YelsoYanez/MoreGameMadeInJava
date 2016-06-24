package com.thecherno.rain.entity.mob;

import com.thecherno.rain.input.Keyboard;

public class Player extends Mob {
	
	private Keyboard input;
	//basic structure for our player
	public Player(Keyboard input){
		this.input = input;
	}
	
	public Player(int x, int y, Keyboard input){
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	public void update(){
		//this code overwrite update from mob
		//making character move up
		/*if(input.up) y--;
		if(input.down) y++;
		if(input.left) x--;
		if(input.right) x++;
		*/
		//different way to move the player
		int xa = 0, ya = 0;
		if(input.up) ya--;
		if(input.down) ya++;
		if(input.left) xa --;
		if(input.right) xa++;
		
		if(xa !=0 || ya != 0) move(xa, ya);
	}
	
	public void render(){
		
	}
}
