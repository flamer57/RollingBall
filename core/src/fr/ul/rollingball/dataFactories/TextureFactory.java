package fr.ul.rollingball.dataFactories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
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
    protected final static Texture boule = new Texture(Gdx.files.internal("images/boule.bmp"));
    protected final static Texture badlogic = new Texture(Gdx.files.internal("images/badlogic.jpg"));
    protected final static Texture bravo = new Texture(Gdx.files.internal("images/Bravo.bmp"));
    protected final static Texture pastNrml = new Texture(Gdx.files.internal("images/pastilleNormale.bmp"));
    protected final static Texture pastTaille = new Texture(Gdx.files.internal("images/pastilleTaille.bmp"));
    protected final static Texture pastTempsAnim = new Texture(Gdx.files.internal("images/pastilleTemps.png"));
    protected final static Texture pastTemps = new Texture(Gdx.files.internal("images/pastilleTemps.bmp"));
    protected final static Texture perte = new Texture(Gdx.files.internal("images/Perte.bmp"));
    protected static FileHandle[] listeLaby=Gdx.files.internal("images/").list(new FileFilter() {
        @Override
        public boolean accept(File file) {
            if(file.getPath().matches("images/Laby.*[.]png")){
                return true;
            }else{
                return false;
            }
        }
    });
    protected static Array<Sprite> pastNrmlAnim = new TextureAtlas(new FileHandle("images/pastilleNormale.pack")).createSprites();
    protected static Array<Sprite> pastTailleAnim = new TextureAtlas(new FileHandle("images/pastilleTaille.pack")).createSprites();
    protected static Animation<TextureRegion> ;

    private static TextureFactory ourInstance = new TextureFactory();

    public static TextureFactory getInstance() {
        return ourInstance;
    }

    private TextureFactory() {
        Array<String> arr=new Array<String>();
        for (FileHandle f:listeLaby){
            arr.add(f.toString());
        }
        arr.sort();
        int i=0;
        for (String s:arr){
            listeLaby[i]=new FileHandle(s);
            i++;
        }
    }

    public static Pixmap getLaby(int n){
        Pixmap pixmap=new Pixmap(listeLaby[n]);

        return pixmap;

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

    public static Texture getPastTempsAnim() {
        return pastTempsAnim;
    }
}
