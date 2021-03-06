package com.arne5.invaderyb.screen;

import com.arne5.invaderyb.Assets;

import com.arne5.invaderyb.Entity.EntityManager;
import com.arne5.invaderyb.Entity.Player;
import com.arne5.invaderyb.InvaderYB;
import com.arne5.invaderyb.camera.OrthoCamera;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;


/**
 * Created by urvaius on 11/12/14.
 */
public class GameScreen extends Screen

	{
		private OrthoCamera camera;

		private EntityManager entityManager;
		private BitmapFont scoreFont;
		private BitmapFont lifeFont;
		private BitmapFont levelFont;
		private GlyphLayout layout;
		private BitmapFont highScoreFont;


		@Override
		public void create()

			{
				//maybe do not need here.
				//Assets.Load();
				camera = new OrthoCamera();
				camera.resize();
				//entityManager = new EntityManager(10,camera);
				entityManager = new EntityManager(10,camera);
				Assets.gameMusic.isLooping();
				Assets.gameMusic.play();
				//TODO: fix
				scoreFont = new BitmapFont();
				scoreFont.setColor(Color.WHITE);

				lifeFont = new BitmapFont();
				lifeFont.setColor(Color.WHITE);
				levelFont = new BitmapFont();
				levelFont.setColor(Color.WHITE);
				highScoreFont = new BitmapFont();
				highScoreFont.setColor(Color.WHITE);
				layout = new GlyphLayout();







			}

		@Override
		public void update()
			{
				camera.update();
				entityManager.update();




				/*if(Gdx.input.isKeyPressed(Input.Keys.P))
					{

						//set pause screen.
						pause();

					}
				if(Gdx.input.isKeyPressed(Input.Keys.O))
					{
						resume();
					}*/

			}

		@Override
		public void render(SpriteBatch sb)
			{
				//start spritebatching
				sb.setProjectionMatrix(camera.combined);
				sb.begin();


				sb.draw(Assets.gameBack, 0, 0);
				sb.draw(Assets.shootButton, 0, 0);



				layout.setText(scoreFont, "Score " + entityManager.playerScore);
				scoreFont.draw(sb, layout, InvaderYB.WIDTH / 2 - 20, InvaderYB.HEIGHT - layout.height);
				layout.setText(lifeFont, "Lives Left " + entityManager.playerLives);

				lifeFont.draw(sb, layout,  10 , InvaderYB.HEIGHT - layout.height);
				layout.setText(levelFont, "Level " + entityManager.level);
				levelFont.draw(sb,layout, 10 , InvaderYB.HEIGHT - lifeFont.getXHeight() -layout.height*2 );

				layout.setText(highScoreFont, "HighScore " + Gdx.app.getPreferences("GamePref").getInteger("HighScore") );

				highScoreFont.draw(sb,layout, 10 , InvaderYB.HEIGHT - lifeFont.getXHeight() -layout.height*2 - scoreFont.getXHeight()*2 );


				// thtis is the old way.
				//scoreFont.draw(sb,"SCORE " + entityManager.playerScore, InvaderY.WIDTH /2 -20 ,InvaderY.HEIGHT -20);
				//scoreFont.draw(sb,"Score",20,20);



				entityManager.render(sb);


				sb.end();
			}

		@Override
		public void resize(int width, int height)
			{
				camera.resize();
			}

		@Override
		public void dispose()
			{
				Assets.gameMusic.dispose();

				//todo: fix
				//scoreFont.dispose();

			}

		@Override
		public void pause()
			{
				Assets.gameMusic.pause();
			}

		@Override
		public void resume()
			{
				Assets.gameMusic.play();
			}
	}
