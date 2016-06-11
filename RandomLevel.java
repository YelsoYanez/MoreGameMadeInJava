package com.thecherno.rain.level;

import java.util.Random;

public class RandomLevel extends Level {
	
	//creating a random generator for boolean
	private final Random random = new Random();

	public RandomLevel(int width, int height) {
		super(width, height);

	}
	
	//any code written here will be executed in the leve class
	//file
	protected void generateLevel(){
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x + y * width] =  random.nextInt(4);
				
			}
		}
		
		
	}
	
	

}
