package gamesrc;

import java.awt.Image;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.listener.FrameListener;

public class Fish extends GSprite {
	public Fish(Image image)
	{
		super(image);
		this.addListener(new FrameListener()
		{
			@Override
			public void invoke(GObject target, Context context)
			{
				int step = 1; 
				target.face(other);
			}
		});
	}
}
