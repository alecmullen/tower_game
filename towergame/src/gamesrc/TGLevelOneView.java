package gamesrc;

import gamesrc.areas.InfoArea;
import gamesrc.areas.MenuArea;
import gamesrc.areas.l1PlayArea;
import gamesrc.turrets.Turret;
import gamesrc.turrets.TurretFive;
import gamesrc.turrets.TurretFour;
import gamesrc.turrets.TurretOne;
import gamesrc.turrets.TurretThree;
import gamesrc.turrets.TurretTwo;
import jgame.Context;
import jgame.GContainer;
import jgame.GObject;
import jgame.ImageCache;
import jgame.controller.MouseLocationController;
import jgame.listener.LocalClickListener;
import jgame.listener.TimerListener;


public class TGLevelOneView extends GContainer {

	private l1PlayArea pal1 = new l1PlayArea();
	private MenuArea ma = new MenuArea();
	private InfoArea ia = new InfoArea();
	
	private boolean settingTurret = false;
	
	public TGLevelOneView()
	{
		setSize(900, 700);
		pal1.setAnchorTopLeft();
		pal1.setLocation(100, 0);
		add(pal1);
		
		ma.setAnchorTopLeft();
		ma.setLocation(0, 0);
		add(ma);
		
		ia.setAnchorTopLeft();
		ia.setLocation(0, 600);
		add(ia);
		
		final TimerListener enemyReleaseListener = new TimerListener(100) {
			public void invoke(GObject target, Context context)
			{
				pal1.initializeEnemies();
			}
		};
		
		this.addListener(enemyReleaseListener);
		
		Home home = new Home(ImageCache.getImage("home.png"));
		home.setLocation(500, 500);
		home.setScale(0.1);
		add(home);
	}

	public void initializeTurret(int tn) 
	{
		if(settingTurret) return;
		settingTurret = true;
		//TurretOne t1 = new TurretOne(ImageCache.getImage("turrets/d1.png"));
		Turret t = chooseTurret(tn);
		this.pal1.addAtCenter(t);
		
		final MouseLocationController mlc = new MouseLocationController();
		t.addController(mlc);
		
		final LocalClickListener dropListener = new LocalClickListener()
			{
				@Override
				public void invoke(GObject target, Context context)
				{
					target.removeController(mlc);
					target.removeListener(this);
					settingTurret = false;
				}
			};
		t.addListener(dropListener);
	}
	
	public Turret chooseTurret(int turretNumber)
	{
		switch(turretNumber)
		{
		case 0:
			return new TurretOne(ImageCache.getImage("turrets/d1.png"));
		case 1:
			return new TurretTwo(ImageCache.getImage("turrets/d2.png"));
		case 2:
			return new TurretThree(ImageCache.getImage("turrets/d3.png"));
		case 3:
			return new TurretFour(ImageCache.getImage("turrets/d4.png"));
		case 4:
			return new TurretFive(ImageCache.getImage("turrets/d5.png"));
		default:
			return null;
		}
	}	

}
