package gamesrc;

import java.awt.Image;

import jgame.GSprite;

public class Home extends GSprite {
	
	private Bank life = new Bank(100);
	
	public Home(Image image)
	{
		super(image);
	}
	
	public int getLife()
	{
		return life.getValue();
	}
	
	public void hit(int minus)
	{
		life.decrement(minus);
	}
}
