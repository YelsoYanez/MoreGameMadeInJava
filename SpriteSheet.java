package com.thecherno.rain.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	//creating string with the path of our spriteshee
	private String path;
	public final int SIZE;
	
	public int[] pixels;// this line will containg the size of the sprite sheet
	
	public SpriteSheet(String path, int size){
		this.path = path;
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		//loading individual sprites
		load();
	}
	
	//loading sprite
	private void load(){
		try{
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			//dealing with individual pixels
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0,w , h, pixels, 0, w);
			
		} catch(IOException e){
			e.printStackTrace();
		}
	}

}
