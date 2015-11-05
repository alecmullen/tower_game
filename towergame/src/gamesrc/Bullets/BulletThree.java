package gamesrc.Bullets;

import gamesrc.Bullet;
import jgame.ImageCache;

public class BulletThree extends Bullet {
	
	private int damage;
	
	public BulletThree()
	{
		super(ImageCache.getImage("bullets/b3.png"), 10);
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
