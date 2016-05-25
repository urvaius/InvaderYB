package com.arne5.invaderyb.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.arne5.invaderyb.InvaderYB;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class DesktopLauncher {
	public static void main (String[] arg) {


		TexturePacker.Settings settings = new TexturePacker.Settings();
		TexturePacker.process(settings, "C:/Development/github/invaderyb/spaceimages","C:/Development/github/invaderyb/android/assets","pack");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title="Invader YB";
		config.width=InvaderYB.WIDTH;
		config.height=InvaderYB.HEIGHT;
		new LwjglApplication(new InvaderYB(), config);
	}
}
