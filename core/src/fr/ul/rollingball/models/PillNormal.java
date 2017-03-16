package fr.ul.rollingball.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import fr.ul.rollingball.dataFactories.SoundFactory;
import fr.ul.rollingball.dataFactories.TextureFactory;

/**
 * Created by molina9u on 08/02/17.
 */

public class PillNormal extends Pill {
    protected int spriteNum;
    protected float tempsEcoule;

    public PillNormal(World mnd, Vector2 vct) {
        super(mnd, vct);
        spriteNum = 0;
        tempsEcoule= 0;
    }

    @Override
    public void effect() {

        SoundFactory.getInstance().playPastille(0.5f);
        this.monde.getEcranJeu().upScore();
    }

    @Override
    public void draw(SpriteBatch listeAff) {

        if (tempsEcoule>0.2) {
            spriteNum = (spriteNum + 1) % TextureFactory.getInstance().getSizeNrml();
            tempsEcoule=0;
        }else{
            tempsEcoule += Gdx.graphics.getDeltaTime();
        }
        listeAff.draw(TextureFactory.getInstance().getPastNrmlAnim(spriteNum),this.getX()-rayon,this.getY()-rayon,this.getRayon()*2,this.getRayon()*2);
    }
}
