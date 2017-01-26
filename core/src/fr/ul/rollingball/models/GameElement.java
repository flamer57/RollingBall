package fr.ul.rollingball.models;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by molina9u on 26/01/17.
 */

public abstract class GameElement {
    protected World monde;
    protected Vector2 position;

    public GameElement(World mnd, Vector2 vct){
        monde=mnd;
        position=vct;
    }

    public World getMonde() {
        return monde;
    }

    public float getX(){
        return position.x;
    }

    public float getY(){
        return position.y;
    }

    public abstract void draw(SpriteBatch sb);
}
