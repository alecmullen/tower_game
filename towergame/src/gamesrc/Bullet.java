package gamesrc;

import java.awt.Image;

import jgame.GSprite;
import jgame.listener.BoundaryRemovalListener;

public abstract class Bullet extends GSprite {
	public Bullet(Image image, int damage) {
		super(image);
		setDamage(damage);
		addListener(new BoundaryRemovalListener());
	}

	public abstract int getDamage();
	public abstract void setDamage(int damage);
}
