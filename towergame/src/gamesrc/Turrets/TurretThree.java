package gamesrc.Turrets;

import java.awt.Image;

import gamesrc.Bullet;
import gamesrc.Turret;
import gamesrc.Bullets.BulletThree;

public class TurretThree extends Turret {
	public TurretThree(Image image) {
		super(image);
		range = 250;
	
	}

	@Override
	public Bullet createBullet() {
		return new BulletThree();
	}

	@Override
	public double getBulletSpeed() {
		return 30;
	}
}
