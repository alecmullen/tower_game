package gamesrc.Turrets;

import java.awt.Image;

import gamesrc.Bullet;
import gamesrc.Turret;
import jgame.ImageCache;

public class TurretOne extends Turret {

	public TurretOne(Image image) {
		super(image);
		range = 250;
	}

	@Override
	public Bullet createBullet() {
		return new Bullet(ImageCache.getImage("bullets/b1.png"));
	}

	@Override
	public double getBulletSpeed() {
		return 30;
	}
}
