package com.thecherno.rain.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	//making an array of boolean for keys
	private boolean[] keys = new boolean[120];
	
	//variable that control variables
	public boolean up, down, left, right;
	
	public void update(){
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		
		//this line is use for testing only
		//System.out.println(up);
		
		//this line is only made to find lines of the key map
		for(int i = 0; i < keys.length; i++){
			if(keys[i]){
				System.out.println("KEY" + i);
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;	
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
		
	}	

}
