package fr.ul.rollingball.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by molina9u on 26/01/17.
 */

public class Boule extends MovableElement {
    protected static float RAYONDEFAUT=200;
    protected float rayon;


    public Boule(World mnd, Vector2 vct) {
        super(mnd, vct);
        rayon=RAYONDEFAUT;
    }

    public void setRayon(float rayon) {
        this.rayon = rayon;
    }

    public void draw(SpriteBatch sb) {
        sb.draw(new Texture(Gdx.files.internal("images/badlogic.jpg")),this.getX(),this.getY(),rayon,rayon);
    }
}
