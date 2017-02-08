package fr.ul.rollingball;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import fr.ul.rollingball.dataFactories.SoundFactory;
import fr.ul.rollingball.dataFactories.TextureFactory;
import fr.ul.rollingball.models.World;
import fr.ul.rollingball.views.GameScreen;
import fr.ul.rollingball.views.SplashScreen;

public class RollingBall extends Game {
	SpriteBatch batch;
	Texture img;
	protected GameScreen gameScreen;
	protected SplashScreen splashScreen;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gameScreen=new GameScreen(this);
		splashScreen= new SplashScreen(this);

		this.setScreen(splashScreen);
	}

	public void toGameScreen(){
		this.setScreen(gameScreen);
	}

	@Override
	public void dispose () {
		batch.dispose();
		gameScreen.dispose();
		splashScreen.dispose();
	}
}
