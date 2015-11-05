package gamesrc.Turrets;

import java.awt.Image;

import gamesrc.Bullet;
import gamesrc.Turret;
import gamesrc.Bullets.BulletFive;

public class TurretFive extends Turret {
	public TurretFive(Image image) {
		super(image);
		range = 250;
	
	}

	@Override
	public Bullet createBullet() {
		return new BulletFive();
	}

	@Override
	public double getBulletSpeed() {
		return 30;
	}
}
