package gamesrc;

import java.util.ArrayList;

import gamesrc.Turrets.TurretFive;
import gamesrc.Turrets.TurretFour;
import gamesrc.Turrets.TurretOne;
import gamesrc.Turrets.TurretThree;
import gamesrc.Turrets.TurretTwo;
import jgame.Context;
import jgame.GContainer;
import jgame.GObject;
import jgame.ImageCache;
import jgame.controller.MouseLocationController;
import jgame.listener.FrameListener;
import jgame.listener.LocalClickListener;

public class TGLevelOneView extends GContainer {
	
	private l1PlayArea pal1 = new l1PlayArea();
	private MenuArea ma = new MenuArea();
	private InfoArea ia = new InfoArea();
	public boolean enemyPresent = false;
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	private ArrayList<Turret> turretList = new ArrayList<Turret>();
	public ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	
	private boolean settingTurret = false;
	public TGLevelOneView() {
		setSize(900,700); 
		
		// sets up play area
		pal1.setAnchorTopLeft();
		pal1.setLocation(100,0);
		add(pal1);
		
		// sets up menu
		ma.setAnchorTopLeft();
		ma.setLocation(0,0);
		add(ma);
		
		// sets up info
		ia.setAnchorTopLeft();
		ia.setLocation(0,570);
		add(ia);
		
	}
	
	public void initializeTurret(int tn) {
		if (settingTurret) {
			return;
		}
		settingTurret = true;
		
		Turret t = chooseTurret(tn);
		this.pal1.addAtCenter(t);
		turretList.add(t);
		
		final MouseLocationController mlc = new MouseLocationController();
		t.addController(mlc);
		
		final LocalClickListener dropListener = new LocalClickListener() {

			@Override
			public void invoke(GObject target, Context context) {
				target.removeController(mlc);
				target.removeListener(this);
				settingTurret = false;
			}
			
		};
		t.addListener(dropListener);
		
		//allows turrets to track enemies
		this.addListener(new FrameListener() {
			
			@Override
			public void invoke(GObject target, Context context) {
				for (int i = 0; i < turretList.size(); i++) {
					if (enemyList.size() == 0) enemyPresent = false;
					if (enemyPresent) turretList.get(i).face(enemyList.get(0).getX(),enemyList.get(0).getY());
					else turretList.get(i).face(getWidth()/2,getHeight()/2);
					//turretList.get(i).setRotation(turretList.get(i).getRotation());
					if (enemyList.size() > 0) {
						if (enemyList.get(i).isDead()) enemyList.remove(i);
					} else {
						break;
					}
				}

			}
		});
		
	}
	
	public void initializeEnemy() {
		final Enemy first = new Enemy(ImageCache.getImage("enemies/e1.png"));
		this.pal1.add(first);
		enemyList.add(first);
		enemyPresent = true;
		
		
		this.addListener(new FrameListener() {

			@Override
			public void invoke(GObject target, Context context) {
				for (int i = 0; i < enemyList.size(); i++) {
					for (int j = 0; j < bulletList.size(); j++) {
						if (bulletList.get(j).preciseHitTest(enemyList.get(i))) {
							first.hit(bulletList.get(j));
//							bulletList.get(j).remove(bulletList.get(j));
//							bulletList.remove(j);
						}
						if (first.isDead()) {
							
						
						}
					}
				}
			}
		});
	}
	
	public Turret chooseTurret(int turretNumber) {
		switch(turretNumber) {
		case 0:
			return new TurretOne(ImageCache.getImage("towers/t1.png"));
		case 1:
			return new TurretTwo(ImageCache.getImage("towers/t2.png"));
		case 2:
			return new TurretThree(ImageCache.getImage("towers/t3.png"));
		case 3:
			return new TurretFour(ImageCache.getImage("towers/t4.png"));
		case 4:
			return new TurretFive(ImageCache.getImage("towers/t5.png"));
		default: return null;
		}
	}
	

}
