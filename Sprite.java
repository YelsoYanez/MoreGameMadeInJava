package com.thecherno.rain.graphics;

public class Sprite {
	
	private final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	//creating constructor to setup our values
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		SIZE = size;
		pixels = new int[SIZE * SIZE] ;
		this.x = x * size; //target specific location of our sprite sheet
		this.y = y * size;
	}
	
	private void load(){
		for(int y = 0; y< SIZE; y++){
			for(int x = 0; x < SIZE; x++)
				//this part of the code access specific sprite and it encapsulate the sprite
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
		}
	}
	

}
