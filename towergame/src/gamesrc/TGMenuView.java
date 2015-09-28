package gamesrc;

import jgame.ButtonState;
import jgame.GButton;
import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;

public class TGMenuView extends GContainer {
	public TGMenuView()
	{
		setSize(900, 700);
		
		MenuBackground mbg = new MenuBackground();
		addAtCenter(mbg);
		
		GSprite none_img = ImageCache.getSprite("buttons/playnone.png");
		GSprite hover_img = ImageCache.getSprite("buttons/playhover.png");
		GSprite pressed_img = ImageCache.getSprite("buttons/playpressed.png");
	
		GButton play_btn = new GButton();
		play_btn.setStateSprite(ButtonState.NONE, none_img);
		play_btn.setStateSprite(ButtonState.HOVERED, hover_img);
		play_btn.setStateSprite(ButtonState.PRESSED, pressed_img);
		
		play_btn.setLocation(100, 100);
		add(play_btn);
	}
}

