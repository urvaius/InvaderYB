package com.arne5.invaderyb.Entity;

import com.arne5.invaderyb.Assets;
import com.arne5.invaderyb.InvaderYB;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by urvaius on 11/12/14.
 */
public class Missile extends Entity
	{
		public Missile( Vector2 pos)
			{
				super(Assets.MISSILE, pos, new Vector2(0,5),Assets.MISSILE.getWidth(),Assets.MISSILE.getHeight());
			}

		@Override
		public void update()
			{
				pos.add(direction);


			}

		public boolean checkEnd()
			{
				return pos.y >= InvaderYB.HEIGHT;

			}
}
