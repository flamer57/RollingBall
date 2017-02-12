package fr.ul.rollingball.models;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import fr.ul.rollingball.dataFactories.TextureFactory;

/**
 * Created by molina9u on 03/02/17.
 */

public abstract class Pill extends GameElement {
    protected static int rayon=100;


    public Pill(World mnd, Vector2 vct) {
        super(mnd, vct);
    }

    public int getRayon(){
        return rayon;
    }

    public abstract void effect();
    public abstract void draw(SpriteBatch listeAff);
}
