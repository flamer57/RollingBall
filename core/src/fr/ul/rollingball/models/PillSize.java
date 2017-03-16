package fr.ul.rollingball.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import fr.ul.rollingball.dataFactories.SoundFactory;
import fr.ul.rollingball.dataFactories.TextureFactory;

/**
 * Created by molina9u on 08/02/17.
 */

public class PillSize extends Pill {
    protected int spriteNum;
    protected float tempsEcoule;

    public PillSize(World mnd, Vector2 vct) {
        super(mnd, vct);
        spriteNum = 0;
        tempsEcoule = 0;
    }

    @Override
    public void effect() {
        SoundFactory.getInstance().playPtaille(0.5f);
        if (monde.getBoule().getRayon()==monde.getBoule().RAYONDEFAUT){
            monde.getBoule().setRayon(monde.getBoule().getRayon()/2);
        }else{
            monde.getBoule().setRayon(monde.getBoule().getRayon()*2);
        }
    }

    @Override
    public void draw(SpriteBatch listeAff) {
        if (tempsEcoule>0.3) {
            spriteNum = (spriteNum + 1) % TextureFactory.getInstance().getSizeNrml();
            tempsEcoule=0;
        }else{
            tempsEcoule += Gdx.graphics.getDeltaTime();
        }
        listeAff.draw(TextureFactory.getInstance().getPastTailleAnim(spriteNum),this.getX()-rayon,this.getY()-rayon,this.getRayon()*2,this.getRayon()*2);
    }
}
