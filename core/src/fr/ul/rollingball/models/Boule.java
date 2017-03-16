package fr.ul.rollingball.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;

import fr.ul.rollingball.dataFactories.TextureFactory;

/**
 * Created by molina9u on 26/01/17.
 */

public class Boule extends MovableElement {
    protected static float RAYONDEFAUT=20;
    protected float rayon;
    protected float tempsEcoule;
    protected int spriteNum;

    public Boule(World mnd, Vector2 vct) {
        super(mnd, vct);
        rayon=RAYONDEFAUT;
        position.x=vct.x;
        position.y=vct.y;
        tempsEcoule = 0;
    }


    public void setRayon(float rayon) {
        this.rayon = rayon;
    }

    public float getRayon(){
        return rayon;
    }

    public boolean isOut(){
        boolean posXin = this.getX()<0 || this.getX()>monde.getWidth();
        boolean posYin = this.getY()<0 || this.getY()>monde.getHeight();
        return posXin || posYin;
    }

    public boolean collisionTest(Pixmap laby, Vector2 contact){
        return laby.getPixel((int)contact.x,(int)contact.y) != 0;

    }

    public void draw(SpriteBatch sb) {
        if (tempsEcoule>0.2) {
            spriteNum = (spriteNum + 1) % TextureFactory.getInstance().getBouleSize();
            tempsEcoule=0;
        }else{
            tempsEcoule += Gdx.graphics.getDeltaTime();
        }
        sb.draw(TextureFactory.getInstance().getBoule(spriteNum),this.getX()-rayon,this.getY()-rayon,rayon*2,rayon*2);
    }
}
