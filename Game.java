package com.thecherno.rain;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.input.Keyboard;
import com.thecherno.rain.level.Level;
import com.thecherno.rain.level.RandomLevel;

//getting runnable
public class Game extends Canvas implements Runnable{
	
	//for convensional perpess adding serialversionuid
	private static final long serialVersionUID = 1L;

	///////////////////////////////////////////////////////////
	//first thread to handle the window
	//creating window size
	public static int width = 300;
	
	//creating height of the window
	public static int height = width / 16*9;
	
	//creating the scale
	public static int scale = 3;
	
	//setting the game title
	public static String title = "Rain";
	
	////////////////////////////////////////////////////////////
	//creating game thread;
	private Thread thread;
	
	//making a window using jframe
	private JFrame frame;
	
	private Keyboard key;
	
	private Level level;
	//making game loop
	private boolean running = false;
	
	private Screen screen; 
	////////////////////////////////////////////////////////////////////
	//bufferedImage is a build in java class
	private BufferedImage image = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB);
	
	//making an array to add data to our pixels
	//raster is a data structures that represent a rectangular array
	//of pixels. what is happening, pixels is callecting all the info from
	//image, basically converting image values in pixel data
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData(); 
	
	
	//creating a constructor for the game
	public Game(){
		//values for the window size
		Dimension size = new Dimension(width*scale, height*scale);
		setPreferredSize(size);
		
		screen = new Screen(width, height);
		frame = new JFrame();//the constructor is going to set our set and dim
		//to jframe
		key = new Keyboard();
		
		//calling random to render the tile
		level = new RandomLevel(64,64);
		addKeyListener(key);
		
	}
	
	//synchronized threads instructions
	public synchronized void start(){
		//starting our game 
		running = true;
		thread = new Thread(this, "Display");//this code help to start the tread
		//starting the thread
		thread.start();
	}
	
	//shouting down game
	public synchronized void stop(){
		running = false;
		try{
			thread.join();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	///////////////////////////////////////////////////////////////
	//adding unimplemented method
	//game loop
	
	//game loop
	//creating a time counter
	public void run(){
		long lastTime = System.nanoTime();
		//creating a timer to keep time of frame
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		//adding frames, we can find how fast our computer can run a game
		int frames = 0;
		int updates = 0;
		
		//this line of code helps to focus the screen of the game without the
		//necesity of clicking on it to play
		requestFocus();
		
		while(running){
		//testing perpes System.out.println("running....");
		//buffer strategy to move movement at right speed with any pc
			//creating speed to 60fps
			
			long now = System.nanoTime();
			delta +=( now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				update();
				updates++;
				delta--;
			}
			//update();
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer +=1000;
				//System.out.println(updates + " ups, " + frames + " fps");
				//to be able to see the fps counter on the window
				frame.setTitle(title + " | " + updates + " ups, " + frames + " fps");
				updates  = 0;
				frames =0;
			}
		}
		
		stop();
	}
	
	int x , y = 0;
	public void update(){
		key.update();
		//this lines of code are made to be able to controll the map
		if(key.up) y--;
		if(key.down) y++;
		if(key.left) x--;
		if(key.right) x++;
		
		//x++;
		//y++;
	}
	
	public void render(){
		//it checks if bs is equal to getBufferStrategy
		// if bs is equal to nothing 
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		
		//rendering the level 
		level.render(x, y, screen);
		
		//screen.render(x,y);// excecute the render method
		
		//this loop set the pixel arrya from screen to the pixel
		//array in our game class
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = screen.pixels[i];
		}
		//making the buffer to ascept data, calling graphics
		Graphics g = bs.getDrawGraphics();
		///////////////////////////////////////////////////
		//writing graphics her
		//setting screen size
		//g.setColor(Color.BLACK);//change color of background
		//g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(),null);
		g.dispose();
		bs.show();//this make the next buffer to show up
		
	}
	
	/////////////////////////////////////////////////////////////////
	
	public static void main(String[] args){
		//creating an object for our game
		Game game = new Game();
		
		//the reason to setresizable to false is because it cause graphics error
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);//add a component to our frame, adding object
		game.frame.pack();//pack make the size of the window to specific value, using demension values as reference
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//setting the x button to close the program completely
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		//starting game
		game.start();
	}
}