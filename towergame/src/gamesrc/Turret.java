package gamesrc;

import java.awt.Image;
import java.util.ArrayList;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.controller.ConstantMovementController;
import jgame.listener.FrameListener;
import jgame.listener.LocalClickListener;
import jgame.listener.TimerListener;

public abstract class Turret extends GSprite {
	private boolean isPlaced = false;
	public int range;
	private ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	public Turret(Image image) {
		super(image);
		this.addListener(new TimerListener(20) {
			@Override
			public void invoke(GObject target, Context context) {
				if (isPlaced && getFirstAncestorOf(TGLevelOneView.class).enemyPresent) 
					fireBullet();
			}
		});
		this.addListener(new FrameListener() {

			@Override
			public void invoke(GObject target, Context context) {
					//target.face(getParent().getWidth()/2,getParent().getHeight()/2);
					target.setRotation(target.getRotation());
			}
		});
		
		//checks for when the turret is placed
		final LocalClickListener dropListener = new LocalClickListener() {

			@Override
			public void invoke(GObject target, Context context) {
				target.removeListener(this);
				isPlaced = true;
			}
			
		};
		addListener(dropListener);
		
		FrameListener rangeListener = new FrameListener() {
			@Override
			public void invoke(GObject target, Context context)
			{
				for(int i = 0; i < bulletList.size(); i++)
				{
					if(bulletList.get(i).distanceTo(target) >= range)
					{
						getFirstAncestorOf(TGLevelOneView.class).remove(bulletList.get(i));
						bulletList.remove(i);
					}
				}
			}
		};
		addListener(rangeListener);
	}
	
	public abstract Bullet createBullet();
	public abstract double getBulletSpeed();
	
	public void fireBullet() {
		final Bullet b = createBullet();
		b.setRotation(this.getRotation());
		final ConstantMovementController c = ConstantMovementController
				.createPolar(getBulletSpeed(),getRotation());
		b.addController(c);
		snapAnchor(b);
		b.moveAtAngle(getWidth()/2+20, getRotation());
		this.addSibling(b);
		
		getFirstAncestorOf(TGLevelOneView.class).bulletList.add(b);
		this.bulletList.add(b);
		
	}
}
