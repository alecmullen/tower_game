package gamesrc.turrets;

import java.awt.Image;

import gamesrc.Bullet;
import jgame.ImageCache;

public class TurretFive extends Turret {
	public TurretFive(Image image)
	{
		super(image);
	}
	
	@Override
	public Bullet createBullet() {
		return new Bullet(ImageCache.getImage("bullets/b5.png"));
	}

	@Override
	public double getBulletSpeed() {
		return 30;
	}
}
