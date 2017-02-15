package fr.ul.rollingball.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import fr.ul.rollingball.dataFactories.TextureFactory;

/**
 * Created by molina9u on 08/02/17.
 */

public class PillTime extends Pill {
    protected float time;

    public PillTime(World mnd, Vector2 vct) {
        super(mnd, vct);
        time=0;
    }

    public void effect() {

    }

    public void draw(SpriteBatch listeAff) {
        time += Gdx.graphics.getDeltaTime();
        TextureRegion im = TextureFactory.getInstance().getPastTempsAnim().getKeyFrame(time);
        listeAff.draw(im,this.getX(),this.getY(),this.getRayon(),this.getRayon());
    }
}
