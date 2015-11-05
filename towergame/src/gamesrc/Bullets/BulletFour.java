package gamesrc.Bullets;

import gamesrc.Bullet;
import jgame.ImageCache;

public class BulletFour extends Bullet {
	
	private int damage;
	
	public BulletFour()
	{
		super(ImageCache.getImage("bullets/b4.png"), 10);
	}
	
	public int getDamage()
	{
		return damage;
	}
	
	public void setDamage(int damage)
	{
		this.damage = damage;
	}
}
