package gamesrc.areas;

import java.awt.Color;
import java.awt.image.BufferedImage;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;

public class InfoArea extends GContainer {
	public InfoArea() {
		setSize(800, 100);
		this.setBackgroundColor(Color.black);
		BufferedImage bg = ImageCache.getImage("areas/leveloneinfoarea.png");
		GSprite gs = new GSprite(bg);
		setBackgroundSprite(gs);
	}
}
