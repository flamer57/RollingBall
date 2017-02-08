package fr.ul.rollingball.models;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import fr.ul.rollingball.dataFactories.TextureFactory;

/**
 * Created by molina9u on 08/02/17.
 */

public class PillNormal extends Pill {
    protected int spriteNum;

    public PillNormal(World mnd, Vector2 vct) {
        super(mnd, vct);
        spriteNum = 0;
    }

    @Override
    public void effect() {

    }

    @Override
    public void draw(SpriteBatch listeAff) {
        listeAff.draw(TextureFactory.getInstance().getPastNrml(),this.getX(),this.getY(),this.getRayon(),this.getRayon());
    }
}
