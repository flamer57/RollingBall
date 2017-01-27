package fr.ul.rollingball.models;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

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

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public float getX(){ return position.x;
    }

    public float getY(){
        return position.y;
    }

    public void setX(float x) { this.position.x = x; }

    public void setY(float y) { this.position.y = y; }

    public abstract void draw(SpriteBatch sb);
}
