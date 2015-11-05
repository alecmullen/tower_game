package gamesrc.Turrets;

import java.awt.Image;

import gamesrc.Bullet;
import gamesrc.Turret;
import gamesrc.Bullets.BulletTwo;

public class TurretTwo extends Turret {
	public TurretTwo(Image image) {
		super(image);
		range = 50;
	
	}

	@Override
	public Bullet createBullet() {
		return new BulletTwo();
	}

	@Override
	public double getBulletSpeed() {
		return 30;
	}
}
