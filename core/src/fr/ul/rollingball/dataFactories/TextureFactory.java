package fr.ul.rollingball.dataFactories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

/**
 * Created by molina9u on 24/01/17.
 */
public class TextureFactory {
    protected final static Texture intro = new Texture(Gdx.files.internal("images/Intro.jpg"));
    protected final static Texture decor = new Texture(Gdx.files.internal("images/Deco.jpg"));
    protected final static Texture badlogic = new Texture(Gdx.files.internal("images/badlogic.jpg"));
    protected static FileHandle[] listeLaby=Gdx.files.internal("images/").list(new FileFilter() {
        @Override
        public boolean accept(File file) {
            return file.getPath().matches("images/Laby.*[.]png");

        }
    });
    private static TextureFactory ourInstance = new TextureFactory();
    protected final static Texture boule = new Texture(Gdx.files.internal("images/boule.bmp"));
    protected final static Texture bravo = new Texture(Gdx.files.internal("images/Bravo.bmp"));
    protected final static Texture pastNrml = new Texture(Gdx.files.internal("images/pastilleNormale.bmp"));
    protected final static Texture pastTaille = new Texture(Gdx.files.internal("images/pastilleTaille.bmp"));
    protected final static Texture pastTempsAn = new Texture(Gdx.files.internal("images/pastilleTemps.png"));
    protected final static Texture pastTemps = new Texture(Gdx.files.internal("images/pastilleTemps.bmp"));
    protected final static Texture perte = new Texture(Gdx.files.internal("images/Perte.bmp"));
    protected static Array<Sprite> pastNrmlAnim = new TextureAtlas(Gdx.files.internal("images/pastilleNormale.pack")).createSprites();
    protected static Array<Sprite> pastTailleAnim = new TextureAtlas(Gdx.files.internal("images/pastilleTaille.pack")).createSprites();
    protected static Animation<TextureRegion> pastTempsAnim;


    public static TextureFactory getInstance() {
        return ourInstance;
    }

    private TextureFactory() {
        //listeLaby trié par ordre alphabétique
        Array<String> arr=new Array<String>();
        for (FileHandle f:listeLaby){
            arr.add(f.toString());
        }
        arr.sort();
        int i=0;
        for (String s:arr){
            listeLaby[i]=Gdx.files.internal(s);
            i++;
        }


        //init animation pastille de temps
        Texture texture=new Texture(Gdx.files.internal("images/pastilleTemps.png"));
        int larg = texture.getWidth();
        int nbIms= texture.getHeight()/larg;
        TextureRegion[][] grille = TextureRegion.split(texture,larg,larg);
        Array<TextureRegion> tabEnLigne = new Array<TextureRegion>();
        for (i = 0; i < nbIms ; i++) {
            tabEnLigne.add(grille[i][0]);
        }
        pastTempsAnim = new Animation(0.166f,tabEnLigne, Animation.PlayMode.LOOP);


    }

    public static Pixmap getLaby(int n){
        Texture t= new Texture(listeLaby[n]);
        TextureData td= t.getTextureData();
        if (!td.isPrepared()){
            td.prepare();
        }
        return td.consumePixmap();
    }

    public static int getNbLaby(){
        return listeLaby.length;
    }

    public static Texture getIntro() {
        return intro;
    }

    public static Texture getDecor() {
        return decor;
    }

    public static Texture getBadlogic() {
        return badlogic;
    }

    public static Texture getBravo() {
        return bravo;
    }

    public static Texture getPastNrml() {
        return pastNrml;
    }

    public static Texture getPastTaille() {
        return pastTaille;
    }

    public static Texture getPastTemps() {
        return pastTemps;
    }

    public static Texture getPerte() {
        return perte;
    }

    public static Texture getBoule() {
        return boule;
    }

    public static Texture getPastTempsAn() {
        return pastTempsAn;
    }

    public static Animation<TextureRegion> getPastTempsAnim() {
        return pastTempsAnim;
    }

    public static Sprite getPastNrmlAnim(int i) {
        return pastNrmlAnim.get(i);
    }

    public static int getSizeNrml(){
        return pastNrmlAnim.size;
    }

    public static Sprite getPastTailleAnim(int i) {
        return pastTailleAnim.get(i);
    }
}
