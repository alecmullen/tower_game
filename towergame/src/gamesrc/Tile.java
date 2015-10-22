package gamesrc;

import java.awt.Image;

import jgame.ButtonState;
import jgame.Context;
import jgame.GButton;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.ButtonListener;

public class Tile extends GButton {
	
	public Tile(Image img, final int turretNumber)
	{
		
		setSize(90, 90);
		
		GSprite sNone = ImageCache.getSprite("buttons/tbn.png");
		GSprite sHover = ImageCache.getSprite("buttons/tbh.png");
		GSprite sPressed = ImageCache.getSprite("buttons/tbp.png");

		setStateSprite(ButtonState.NONE, sNone);
		setStateSprite(ButtonState.HOVERED, sHover);
		setStateSprite(ButtonState.PRESSED, sPressed);
		
		GSprite tIcon = new GSprite(img);
		tIcon.setScale(0.8);
		addAtCenter(tIcon);
		
		addListener(new ButtonListener()
		{
			@Override
			public void mouseClicked(Context context)
			{
				getFirstAncestorOf(TGLevelOneView.class).initializeTurret(turretNumber);
			}
		});
	}

}
