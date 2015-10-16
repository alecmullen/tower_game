package gamesrc.areas;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;

import gamesrc.Tile;
import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;

public class MenuArea extends GContainer {

	public MenuArea() {
		setSize(100, 600);
		this.setBackgroundColor(Color.black);
		BufferedImage bg = ImageCache.getImage("areas/levelonemenuarea.png");
		GSprite gs = new GSprite(bg);
		setBackgroundSprite(gs);
		
		for(int i = 0; i < 5; i++)
		{
			setTile(i);
		}
	}
	
	List <Image> tileImages = ImageCache.getSequentialImages("turrets/d", 1, 5, ".png");
	
	private void setTile(int i)
	{
		Tile tile = new Tile(tileImages.get(i), i);
		tile.setAnchorTopLeft();
		tile.setScale(0.9);
		tile.setX(4);
		tile.setY(110*i + 25);
		add(tile);
	}

}
