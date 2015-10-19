package gamesrc.turrets;

import java.awt.Image;

import gamesrc.Bullet;
import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.controller.ConstantMovementController;
import jgame.listener.FrameListener;
import jgame.listener.TimerListener;

public abstract class Turret extends GSprite {
	
	//default shootTime = 20
	public Turret(Image image)
	{
		super(image);
		this.addListener(new TimerListener(20) 
		{
			@Override
			public void invoke(GObject target, Context context)
			{
				fireBullet();
			}
		});
		this.addListener(new FrameListener() {
			@Override
			public void invoke(GObject target, Context context)
			{
				target.face(getParent().getWidth()/2, getParent().getHeight()/2);
				target.setRotation(target.getRotation());
			}
		});
	}

	public Turret(Image image, int shootTime)
	{
		super(image);
		
		this.addListener(new TimerListener(shootTime) 
		{
				@Override
				public void invoke(GObject target, Context context)
				{
					fireBullet();
				}
			});
			this.addListener(new FrameListener() {
				@Override
				public void invoke(GObject target, Context context)
				{
					target.face(getParent().getWidth()/2, getParent().getHeight()/2);
					target.setRotation(target.getRotation());
				}
			});
	}
	
	public abstract Bullet createBullet();
	public abstract double getBulletSpeed();
	
	public void fireBullet()
	{
		final Bullet b = createBullet();
		b.setRotation(this.getRotation());
		final ConstantMovementController c = ConstantMovementController.createPolar(getBulletSpeed(), getRotation());
		b.addController(c);
		snapAnchor(b);
		b.moveAtAngle(getWidth() / 2 + 20, getRotation());
		this.addSibling(b);
	}
}
