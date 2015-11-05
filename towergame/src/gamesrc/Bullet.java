package gamesrc;

import java.awt.Image;

import jgame.GSprite;
import jgame.listener.BoundaryRemovalListener;

public class Bullet extends GSprite {
	private int damage = 10;
	public Bullet(Image image) {
		super(image);
		addListener(new BoundaryRemovalListener());
	}
	public int getDamage() {
		// TODO Auto-generated method stub
		return damage;
	}
}
