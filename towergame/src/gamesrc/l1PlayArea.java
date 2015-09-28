package gamesrc;

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;


public class l1PlayArea extends GContainer 
{
	List<Fish> fishes = new ArrayList<Fish>(1);
	
	public l1PlayArea() 
	{
		setSize(800, 600);
		this.setBackgroundColor(Color.black);
		BufferedImage bg = ImageCache.getImage("areas/leveloneplayarea.png");
		GSprite gs = new GSprite(bg);
		setBackgroundSprite(gs);
	}
	
	
	public void createFish() {
		Fish fish = new Fish(ImageCache.getImage("fish/f1.png"));
		fish.setLocation(100, 100);
		fishes.add(fish);
	}
	
	public int getFishNum()
	{
		return fishes.size();
	}
}
