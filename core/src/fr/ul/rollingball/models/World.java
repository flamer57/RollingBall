package fr.ul.rollingball.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import fr.ul.rollingball.dataFactories.TextureFactory;
import fr.ul.rollingball.views.GameScreen;

/**
 * Created by molina9u on 27/01/17.
 */

public class World {
    protected GameScreen ecranJeu;
    protected Boule boule;
    protected int numLaby;
    protected Pixmap imLaby;
    protected Texture textLaby;
    protected Array<Pill> listePills;


    public World(GameScreen gs){
        ecranJeu=gs;

        numLaby=0;
        imLaby= TextureFactory.getInstance().getLaby(numLaby);
        imLaby.setColor(Color.WHITE);
        boule = new Boule(this,new Vector2(getWidth()/2,getHeight()/2));
        listePills = new Array<Pill>();
        extractPills();
        textLaby = new Texture(imLaby);

    }

    public Boule getBoule() {
        return boule;
    }

    public int getHeight(){
        return imLaby.getHeight();
    }

    public int getWidth(){
        return imLaby.getWidth();
    }

    public GameScreen getEcranJeu(){
        return ecranJeu;
    }

    public void ballOut(){
        if (boule.isOut()) {
            this.getEcranJeu().setBallOut();
        }
    }

    public void resetBall(){
        boule.setX(getWidth()/2);
        boule.setY(getHeight()/2);
        boule.setVitesseX(0);
        boule.setVitesseY(0);
    }

    public void extractPills(){
        boolean trouve=false;
        int j,i;
        for (j=0;j<getHeight();j++){
            for (i=0;i<getWidth();i++){
               if ((0x000000FF & imLaby.getPixel(i,j))== 128){
                   listePills.add(new PillNormal(this,new Vector2(i+1,getHeight() - j- 5)));
                   trouve=true;
               }else {
                   if ((0x000000FF & imLaby.getPixel(i,j)) == 200) {
                       listePills.add(new PillSize(this, new Vector2(i+1,getHeight() - j- 5)));
                       trouve=true;
                   }else {
                       if ((0x000000FF & imLaby.getPixel(i,j)) == 225) {
                           listePills.add(new PillTime(this, new Vector2(i+1,getHeight() -j-5)));
                           trouve=true;
                       }
                   }
               }
                if (trouve){
                    imLaby.fillRectangle(i-4,j,11,11);
                    trouve=false;
                }
            }

        }


    }

    public void eatPill(Vector2 posBoule){
        for (Pill p:listePills){
            double dist=Math.pow(posBoule.x-p.getX(),2)+Math.pow(posBoule.y-p.getY(),2);
            if (dist<=Math.pow(boule.getRayon()+p.getRayon(),2)){
                p.effect();
                listePills.removeValue(p,true);
            }
        }
    }

    public int getNumLaby() {
        return numLaby;
    }

    public void changeLaby(int i){
        numLaby=i;
        imLaby= TextureFactory.getInstance().getLaby(numLaby);
        imLaby.setColor(Color.WHITE);
        listePills.clear();
        extractPills();
        textLaby = new Texture(imLaby);
    }

    public void draw(SpriteBatch sb) {

        sb.draw(TextureFactory.getInstance().getDecor(),0,0);

        sb.draw(textLaby,0,0);
        boule.draw(sb);
        for (int i=0;i<listePills.size;i++){
            listePills.get(i).draw(sb);
        }
        ballOut();
        eatPill(boule.getPosition());
    }
}
