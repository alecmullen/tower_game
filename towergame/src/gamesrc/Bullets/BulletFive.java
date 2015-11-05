package gamesrc.Bullets;

import gamesrc.Bullet;
import jgame.ImageCache;

public class BulletFive extends Bullet {
	
	private int damage;
	
	public BulletFive()
	{
		super(ImageCache.getImage("bullets/b5.png"), 10);
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
