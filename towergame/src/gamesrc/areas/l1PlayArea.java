package gamesrc.areas;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.image.BufferedImage;

import gamesrc.Enemy;
import jgame.Context;
import jgame.GContainer;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.PolygonController;
import jgame.listener.FrameListener;


public class l1PlayArea extends GContainer
{
	//List<Fish> fishes = new ArrayList<Fish>(1);
	
	public l1PlayArea() 
	{
		setSize(800, 600);
		this.setBackgroundColor(Color.black);
		BufferedImage bg = ImageCache.getImage("areas/playarea.png");
		GSprite gs = new GSprite(bg);
		setBackgroundSprite(gs);
	}
	
	
	public void initializeEnemies() {
			Enemy e1 = new Enemy(ImageCache.getImage("enemies/e1.png"));
			this.add(e1);
						
			int[] x = new int[] { 111, 111, 127, 149, 172, 197, 223, 251, 278, 304, 329, 355, 379, 404, 429, 454, 481, 507, 533, 559, 584, 610, 633, 650, 660, 669, 677, 678, 667, 648, 623, 598, 573, 547, 522, 496, 470, 442, 416, 390, 363, 338, 313, 288, 262, 238, 212, 187, 163, 137, 112, 95, 82, 69, 63, 52, 49, 49, 49, 53, 63, 74, 87, 108, 131, 156, 182, 208, 226, 239, 251, 262, 272, 284, 300, 320, 346, 374, 398, 423, 444, 464, 481, 502, 524, 547, 571, 598, 625, 652, 678, 703, 728, 752, 775 };
			int[] y = new int[] { 7, 33, 53, 69, 80, 88, 95, 95, 95, 94, 91, 84, 76, 68, 65, 62, 62, 62, 62, 62, 63, 72, 86, 105, 128, 152, 176, 203, 226, 243, 248, 252, 255, 259, 262, 262, 263, 263, 263, 263, 263, 261, 258, 255, 248, 240, 232, 225, 215, 215, 225, 244, 266, 289, 314, 337, 363, 391, 417, 442, 465, 488, 510, 526, 539, 546, 551, 550, 532, 508, 486, 462, 439, 417, 396, 380, 373, 374, 382, 393, 407, 425, 444, 460, 476, 488, 500, 508, 511, 512, 512, 510, 504, 496, 485 };
			Polygon p = new Polygon(x, y, 95);
			final PolygonController pc = new PolygonController(p, true, 270);
			pc.goToStart(e1);
			pc.setMaxSpeed(10);
			FrameListener fl = new FrameListener() {
				@Override
				public void invoke(GObject target, Context context) {
					pc.controlObject(target, context);
				}
			};
			e1.addListener(fl);
			
	}
	
}
