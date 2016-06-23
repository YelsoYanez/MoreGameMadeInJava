package com.thecherno.rain.level;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.level.tile.Tile;

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
		//fixing screen off set error
		screen.setOffset(xScroll, yScroll);
		//generatering random tiles
		//corner pin which means coordinate points in the screen
		//this code helps to collect which tiles need to be render
		int x0 = xScroll >> 4;// shift >> 4 means dive by 16
		int x1 = (xScroll + screen.width + 16) >> 4; //the 16 increaces the drawing of the tile by 16 pixels so it prevent the black screen on the side
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		
		//this for loop helps to render specific tiles we need
		for(int y = y0 ; y < y1; y++){
			for(int x = x0; x < x1; x++){
				getTile(x, y).render(x, y, screen);//this line gets the write tile to be render
			}
		}
	}
	
	public Tile getTile(int x, int y){
		//fixing out off bounce there is an issue when a negative value 
		//show up when scrolling in negative direction
		//also to fix the problem when we exced the amount of tiles, we only
		//need to add to our if statement for our return tile
		if(x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		
		//this line of code help to render specific tile in our map
		if(tiles[x + y * width] == 0){
			return Tile.grass;
		//return Tile.voidTile;
		} else {
			return Tile.voidTile;
		}
	}

}
