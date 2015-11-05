package gamesrc.Turrets;

import java.awt.Image;

import gamesrc.Bullet;
import gamesrc.Turret;
import gamesrc.Bullets.BulletOne;

public class TurretOne extends Turret {

	public TurretOne(Image image) {
		super(image);
		range = 50;
	}

	@Override
	public Bullet createBullet() {
		return new BulletOne();
	}

	@Override
	public double getBulletSpeed() {
		return 30;
	}
}
