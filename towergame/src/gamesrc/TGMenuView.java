package gamesrc;

import jgame.ButtonState;
import jgame.Context;
import jgame.GButton;
import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.ButtonListener;

public class TGMenuView extends GContainer{
	
	public TGMenuView() {
		setSize(900,700);
		
		MenuBackground mbg = new MenuBackground();
		addAtCenter(mbg);
		
		GSprite none_img = new GSprite(ImageCache.getImage("buttons/ibn.png"));
		GSprite hover_img = new GSprite(ImageCache.getImage("buttons/ibh.png"));
		GSprite pressed_img = new GSprite(ImageCache.getImage("buttons/ibp.png"));
		
		GButton play_btn = new GButton();
		play_btn.setStateSprite(ButtonState.NONE, none_img);
		play_btn.setStateSprite(ButtonState.HOVERED, hover_img);
		play_btn.setStateSprite(ButtonState.PRESSED, pressed_img);
		
		GSprite tIcon = new GSprite(ImageCache.getImage("enemies/e1.png"));
		
		play_btn.setLocation(100, 100);
		tIcon.setAnchorTopLeft();
		//play_btn.setAnchorCenter();
		add(play_btn);
		play_btn.add(tIcon);
		
		addListener(new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				TowerGame.l1v();
				
				
			}
		});
		
	}

}
