package com.thecherno.rain.level.tile;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;

public class Tile {
	// each tile should have position and sprite
	public int x, y;
	public Sprite sprite;
	
	//created a static grass tile that will not change
	
	public static Tile grass = new GrassTile(Sprite.grass);
	
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen){
		
	}
	
	public boolean solid(){
		return false;
	}

}
