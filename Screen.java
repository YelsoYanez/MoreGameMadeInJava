package com.thecherno.rain.graphics;

import java.util.Random;

import com.thecherno.rain.level.tile.Tile;

public class Screen {

	private int width, height;
	//private int height;	
	public int[] pixels;
	
	//setting speciffic values for our pixels
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	
	//creating tile map for the background
	public int[] tiles = new int[MAP_SIZE*MAP_SIZE];
	
	private Random random = new Random();
	
	public Screen(int widht, int height){
		this.width = widht;
		this.height = height;
		pixels = new int[width*height];
		
		//creating random colors for the map
		for(int i = 0; i < MAP_SIZE*MAP_SIZE; i++){
			tiles[i] = random.nextInt(0xffffff);
			//tiles[0] = 0;
		}
		
	}
	
	//clearing the screen
	public void clear(){
		for(int i = 0; i < pixels.length; i++){
			//set the pixel to zero
			pixels[i] = 0;
		}
	}
	
	//this loop translate to our screen this way
	//each loop render a pixel to the screen

	// for testing only
	//int xtime = 100, ytime = 50;
	//int counter = 0;
	
	/////////////////////////
	public void render( int xOffset, int yOffset){
		//for testing only
		//counter++;
		//another error that happens when the x and y time go to a negative index in the increment part
		//if(counter % 100 == 0) xtime--;
		//if(counter % 100 == 0) ytime--;
		
		//reason the program crashes is because when there is no value in the
		//boundary of our screen the render is trying to render and since there
		//is not any boundary the program crash. To fix this code just write a
		//simple if statement in the nested loop
		
		for(int y = 0; y < height; y++){
			
			//fixing screen error
			int YP = y + yOffset;
			//working in map scrolling
			//int yy = y + yOffset;
			
			if(YP < 0 || YP >= height) continue;
			
			//so checking the ytime greater then height fix the issue with the render
			// the or in the loop check for positive and negative values for y axis and next loop for x axis
			//ytime was use for testing only, change to y only
			//if(yy < 0 || yy >= height) break;
				for(int x = 0; x < width; x++){
					int XP = x + xOffset;
					if(XP < 0 || XP >= width) continue;
				//	int xx = x + xOffset;
					//if(xx < 0 || xx >= width) break;
					

					//by changing the x and y we can change pixel location
					//pixels[30 + 40*width] = 0xFF00FF;//hexadecimal notation
					//0x means hexadecimal
					//0b means binary
					
					//creating tile index so we can find the location of specific tile we want to remove
					//reason we do x * 32  is because we check 32 pixels of x
					//with bitwise operation we can run our program faster
					// x >> 4 is == x / 16 do it for y as wel
					
					//make sure remove comments from below
					//int tilesIndex = ((xx >> 4 ) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE;
					pixels[XP + YP * width] = Sprite.grass.pixels[(x & 15) + (y & 15) * Sprite.grass.SIZE]; //tiles[tilesIndex];
					//the offset helps to have the map in perfect location
				}
				
		}
		
	}
	
	
	//rendering tiles for game
	public void renderTile(int xp, int yp, Tile tile){
		//tile size. we are using tiles of 16 by 16 by default but we can change
		//dealing with realtibe position vs absolute position
		//absolute position help of a map
		//relative position of an object
		for(int y = 0; y< tile.sprite.SIZE; y++){
			//absolute position
			int ya = y + yp;
			
			//reason this code was copy is that the game being created,
			//is a 2d game
			for(int x = 0; x< tile.sprite.SIZE; x++){
				//absolute position
				int xa = x + xp;
				//review this lines of code
				//the width that is used here it refer to the screen width
				//the effect we are trying to get is the effect of a screen that keeps scrolling
				if(xa < 0 || xa >= width || ya < 0 || ya >= width) break;
				//pixels[] deals with what pixels get render
				//sprite pixels deals with what prite pixels get render
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
				
				
				//////////////////////////////////////////////////
			}
		
		
		}
		
	
	}

}