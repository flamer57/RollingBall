package fr.ul.rollingball.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import javax.management.relation.RoleInfo;

import fr.ul.rollingball.RollingBall;
import fr.ul.rollingball.dataFactories.TextureFactory;
import fr.ul.rollingball.models.World;

/**
 * Created by molina9u on 24/01/17.
 */

public class GameScreen extends ScreenAdapter {
    protected RollingBall rollBall;
    protected SpriteBatch listeAff;
    protected World monde;

    public GameScreen(RollingBall rb){
        rollBall=rb;
        listeAff=new SpriteBatch();
        monde=new World(this);
    }

    public void render(float delta){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        update();
        listeAff.begin();
        listeAff.draw(TextureFactory.getInstance().getDecor(),0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        monde.getBoule().draw(listeAff);
        listeAff.end();
    }

    public void update(){
        float accelX = Gdx.input.getAccelerometerX();
        float accelY = Gdx.input.getAccelerometerY();

        monde.getBoule().addVitesse(new Vector2(accelY/10,-accelX/10));
        monde.getBoule().updateObject();
    }

    public void dispose(){
        listeAff.dispose();

    }
}
