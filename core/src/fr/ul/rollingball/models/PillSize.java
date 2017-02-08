package fr.ul.rollingball.models;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import fr.ul.rollingball.dataFactories.TextureFactory;

/**
 * Created by molina9u on 08/02/17.
 */

public class PillSize extends Pill {
    protected int pastilleNum;
    public PillSize(World mnd, Vector2 vct) {
        super(mnd, vct);
        pastilleNum = 0;
    }

    @Override
    public void effect() {

    }

    @Override
    public void draw(SpriteBatch listeAff) {
        listeAff.draw(TextureFactory.getInstance().getPastTaille(),this.getX(),this.getY(),this.getRayon(),this.getRayon());
    }
}
