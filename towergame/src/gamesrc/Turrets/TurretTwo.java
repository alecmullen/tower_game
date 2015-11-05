package gamesrc.Turrets;

import java.awt.Image;

import gamesrc.Bullet;
import gamesrc.Turret;
import jgame.ImageCache;

public class TurretTwo extends Turret {
	public TurretTwo(Image image) {
		super(image);
		
		range = 250;
	
	}

	@Override
	public Bullet createBullet() {
		return new Bullet(ImageCache.getImage("bullets/b2.png"));
	}

	@Override
	public double getBulletSpeed() {
		return 30;
	}
}
