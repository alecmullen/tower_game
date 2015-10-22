package gamesrc;

import java.awt.Color;

import jgame.GRootContainer;
import jgame.Game;
import jgame.ImageCache;
import jgame.SoundManager;

public class TowerGame extends Game {

	public static void main(String[] args) {
		ImageCache.create(TowerGame.class, "/rsc/");
		SoundManager.create(TowerGame.class, "/rsc/");
		TowerGame tg = new TowerGame();
		tg.startGame();
	}

	public TowerGame() {
		GRootContainer root = new GRootContainer(Color.BLACK);
		setRootContainer(root);

//		TGMenuView tgmv = new TGMenuView();
//		root.addView(Views.MENU, tgmv);
		
		TGLevelOneView tgl1v = new TGLevelOneView();
		root.addView(Views.LEVEL_ONE, tgl1v);
	}

	public enum Views {
		MENU, LEVEL_ONE, GAME_OVER;
	}
}
