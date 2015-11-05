package gamesrc.Bullets;

import gamesrc.Bullet;
import jgame.ImageCache;

public class BulletTwo extends Bullet {
	
	private int damage;
	
	public BulletTwo()
	{
		super(ImageCache.getImage("bullets/b2.png"), 10);
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
