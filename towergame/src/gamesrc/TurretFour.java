package gamesrc;

import java.awt.Image;

import jgame.ImageCache;

public class TurretFour extends Turret {
	public TurretFour(Image image)
	{
		super(image);
	}
	
	@Override
	public Bullet createBullet() {
		return new Bullet(ImageCache.getImage("bullets/b4.png"));
	}

	@Override
	public double getBulletSpeed() {
		return 30;
	}
}
