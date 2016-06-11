package com.thecherno.rain.level;

import com.thecherno.rain.graphics.Screen;

public class Level {
	//this class will do different things 
	//creating instance of the level
	
	protected int width, height;
	
	protected int[] tiles;
	
	public Level(int width, int height){
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}
	
	public Level(String path){
		//creating the directery of the level
		loadLevel(path);
	}
	
	protected void generateLevel(){
		
	}
	
	private void loadLevel(String path){
		
	}
	
	public void update(){
		
	}
	
	private void time(){
		
	} 
	
	public void render(int xScroll, int yScroll, Screen screen){
		
	}

}
