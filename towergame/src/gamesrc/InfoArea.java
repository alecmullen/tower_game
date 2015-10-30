package gamesrc;

import java.awt.image.BufferedImage;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;

public class InfoArea extends GContainer {
	public InfoArea() {
		setSize(100, 700);
		BufferedImage bg = ImageCache.getImage("areas/infoarea.png");
		GSprite gs = new GSprite(bg);
		setBackgroundSprite(gs);
		setTile();
	}
	
	private void setTile() {
		Tile tile = new Tile(ImageCache.getImage("enemies/e1.png"));
		tile.setAnchorTopLeft();
		tile.setScale(0.9);
		tile.setX(50);
		tile.setY(10);
		add(tile);
	}
}
