package gamesrc;

import java.awt.Image;
import java.awt.Polygon;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.controller.PolygonController;
import jgame.listener.BoundaryRemovalListener;
import jgame.listener.FrameListener;

public  class Enemy extends GSprite {
	private int speed = 5;
	public int health = 100;
	public Enemy (Image image) {
		super(image);

		int[] x = new int[] { 51, 48, 48, 48, 48, 47, 45, 40, 43, 45, 48, 54, 57, 57, 50, 45, 53, 54, 53, 54, 54, 55, 62, 87, 113, 140, 165, 191, 216, 232, 232, 230, 228, 225, 227, 202, 177, 151, 151, 143, 135, 127, 138, 142, 149, 155, 180, 207, 232, 258, 283, 309, 334, 361, 386, 411, 436, 462, 487, 512, 510, 508, 512, 508, 508, 508, 507, 482, 457, 432, 407, 381, 355, 330, 330, 325, 325, 326, 330, 326, 326, 326, 325, 325, 325, 327, 327, 323, 317, 321, 318, 319, 344, 370, 396, 421, 446, 471, 497, 522, 547, 574, 600, 625, 651, 676, 702, 727 };
		int[] y = new int[] { 21, 46, 72, 98, 124, 149, 174, 199, 224, 249, 275, 300, 325, 352, 377, 402, 427, 452, 477, 502, 528, 553, 578, 575, 575, 577, 578, 577, 573, 553, 527, 502, 477, 452, 427, 428, 427, 425, 399, 375, 351, 326, 303, 278, 253, 228, 226, 226, 231, 231, 234, 238, 241, 241, 240, 244, 245, 245, 248, 249, 224, 199, 174, 149, 123, 97, 72, 68, 67, 63, 62, 62, 62, 67, 93, 118, 144, 171, 196, 221, 247, 273, 298, 324, 350, 375, 401, 426, 451, 476, 501, 526, 525, 525, 525, 520, 522, 518, 518, 515, 512, 512, 512, 509, 509, 511, 511, 513 };
		Polygon p = new Polygon(x, y, 108);
		PolygonController pc = new PolygonController(p);
		pc.setMaxSpeed(speed);
		this.addController(pc);
		addListener(new BoundaryRemovalListener());
		
		this.addListener(new FrameListener() {

			@Override
			public void invoke(GObject target, Context context) {
				System.out.println(health);
				if (health <= 0) removeEnemy();
			}
		});
	}
	
	public void hit(Bullet b1) {
		health = health - b1.getDamage();
		
	}
	
	public void removeEnemy() {
		remove(this);
	}

	public boolean isDead() {
		if (health <= 0) return true;
		return false;
	}

}
