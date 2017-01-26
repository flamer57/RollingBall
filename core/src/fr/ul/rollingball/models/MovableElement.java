package fr.ul.rollingball.models;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by molina9u on 26/01/17.
 */

public abstract class MovableElement extends GameElement {
    protected Vector2 vitesse;

    public MovableElement(World mnd, Vector2 vct) {
        super(mnd, vct);
        vitesse=new Vector2(0,0);
    }

    public float getVitesseX() {
        return vitesse.x;
    }

    public float getVitesseY() {
        return vitesse.y;
    }

    public void addVitesse(Vector2 accel){
        vitesse.x+=accel.x;
        vitesse.y+=accel.y;
    }

    public void updateObject(){
        position.x+=vitesse.x;
        position.y+=vitesse.y;
    }
}
