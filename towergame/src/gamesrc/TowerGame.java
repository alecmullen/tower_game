package gamesrc;

import java.awt.Color;

import jgame.GRootContainer;
import jgame.Game;
import jgame.ImageCache;
import jgame.SoundManager;

//did it work
public class TowerGame extends Game {

	private static GRootContainer root = new GRootContainer(Color.BLACK);
	public static boolean l1Started = false;
	public static void main(String[] args) {
		ImageCache.create(TowerGame.class, "/rsc/");
		SoundManager.create(TowerGame.class, "/rsc/");
		TowerGame tg = new TowerGame();
		tg.startGame();
	}
	
	public TowerGame() {
		setRootContainer(root);
		menu();
		
	}
	
	public enum Views {
		MAIN_MENU, LEVEL_ONE, INSTRUCTIONS, GAME_OVER, MENU;
	}
	

	public static void menu() {
		TGMenuView tgmv = new TGMenuView();
		root.addView(Views.MAIN_MENU, tgmv);
		
	}
	
	public static void l1v() {
		TGLevelOneView tgl1v = new TGLevelOneView();
		root.addViewAndSetCurrent(Views.LEVEL_ONE, tgl1v);
	}
}
