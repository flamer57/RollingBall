package fr.ul.rollingball.dataFactories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by molina9u on 24/01/17.
 */
public class TextureFactory {
    protected final static Texture intro = new Texture(Gdx.files.internal("images/Intro.jpg"));
    protected final static Texture decor = new Texture(Gdx.files.internal("images/Deco.jpg"));
    protected final static Texture boule = new Texture(Gdx.files.internal("images/boule.bmp"));
    protected final static Texture badlogic = new Texture(Gdx.files.internal("images/badlogic.jpg"));
    protected final static Texture bravo = new Texture(Gdx.files.internal("images/Bravo.jpg"));
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


    private static TextureFactory ourInstance = new TextureFactory();

    public static TextureFactory getInstance() {
        return ourInstance;
    }

    private TextureFactory() { }

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
