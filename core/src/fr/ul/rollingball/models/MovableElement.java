package fr.ul.rollingball.models;

import com.badlogic.gdx.math.Vector2;

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

    public void setVitesseX(float x){ vitesse.x = x; }

    public float getVitesseY() {
        return vitesse.y;
    }

    public void setVitesseY(float y){ vitesse.y = y; }

    public void addVitesse(Vector2 accel){ vitesse.add(accel); }

    public void updateObject(){
        position.add(vitesse);
    }
}
