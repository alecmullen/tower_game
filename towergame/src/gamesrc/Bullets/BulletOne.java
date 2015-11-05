package gamesrc.Bullets;

import gamesrc.Bullet;
import jgame.ImageCache;

public class BulletOne extends Bullet {
	
	private int damage;
	
	public BulletOne()
	{
		super(ImageCache.getImage("bullets/b1.png"), 10);
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
