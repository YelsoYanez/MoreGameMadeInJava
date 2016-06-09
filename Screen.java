package com.thecherno.rain.graphics;

public class Screen {

	private int width, height;
	//private int height;
	
	public int[] pixels;
	
	public Screen(int widht, int height){
		this.width = widht;
		this.height = height;
		pixels = new int[width*height];
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
	int xtime = 100, ytime = 50;
	int counter = 0;
	/////////////////////////
	public void render(){
		//for testing only
		counter++;
		//another error that happens when the x and y time go to a negative index in the increment part
		if(counter % 100 == 0) xtime--;
		if(counter % 100 == 0) ytime--;
		
		//reason the program crashes is because when there is no value in the
		//boundary of our screen the render is trying to render and since there
		//is not any boundary the program crash. To fix this code just write a
		//simple if statement in the nested loop
		
		for(int y = 0; y < height; y++){
			//so checking the ytime greater then height fix the issue with the render
			// the or in the loop check for positive and negative values for y axis and next loop for x axis
			if(ytime < 0 || ytime >= height) break;
				for(int x = 0; x < width; x++){
					if(xtime < 0 || xtime >= width) break;
					//by changing the x and y we can change pixel location
					//pixels[30 + 40*width] = 0xFF00FF;//hexadecimal notation
					//0x means hexadecimal
					//0b means binary
					pixels[xtime + ytime * width] = 0xFF00FF;
				}
		}
	}
	
	
}
