package fr.ul.rollingball.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

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


    public World(GameScreen gs){
        ecranJeu=gs;
        boule = new Boule(this,new Vector2(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2));
        numLaby=0;
        imLaby= TextureFactory.getInstance().getLaby(numLaby);
        textLaby = new Texture(imLaby);
    }

    public Boule getBoule() {
        return boule;
    }

    public void draw(SpriteBatch sb) {

        sb.draw(TextureFactory.getInstance().getDecor(),0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        sb.draw(textLaby,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        boule.draw(sb);

    }
}
