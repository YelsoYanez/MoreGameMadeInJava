package com.thecherno.rain.graphics;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	//accessing specific sprite in our sprite sheet the 0 ,0 means location of
	//sprite as example 0 x and 0 y axis
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	
	//creating new sprite of black color
	public static Sprite voidSprite = new Sprite(16,0x1B87E0);// 0 means black color
	
	//creating constructor to setup our values
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		SIZE = size;
		pixels = new int[SIZE * SIZE] ;
		this.x = x * size; //target specific location of our sprite sheet
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	//colour is color in australia
	public Sprite(int size, int colour){
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColour(colour);
	}
	
	private void setColour(int colour){
		
		for(int i = 0; i < SIZE*SIZE; i++){
			pixels[i] = colour;
		}
	}
	
	private void load(){
		for(int y = 0; y< SIZE; y++){
			for(int x = 0; x < SIZE; x++){
				//this part of the code access specific sprite and it encapsulate the sprite
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
	

}
