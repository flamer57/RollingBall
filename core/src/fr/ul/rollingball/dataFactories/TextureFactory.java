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
    protected static Texture intro = new Texture(Gdx.files.internal("images/Intro.jpg"));
    protected static Texture decor = new Texture(Gdx.files.internal("images/Deco.jpg"));
    protected static Texture boule = new Texture(Gdx.files.internal("images/boule.bmp"));
    protected static Texture badlogic = new Texture(Gdx.files.internal("images/badlogic.jpg"));
    protected static Texture bravo = new Texture(Gdx.files.internal("images/Bravo.jpg"));
    protected static Texture pastNrml = new Texture(Gdx.files.internal("images/pastilleNormale.bmp"));
    protected static Texture pastTaille = new Texture(Gdx.files.internal("images/pastilleTaille.bmp"));
    protected static Texture pastTempsAnim = new Texture(Gdx.files.internal("images/pastilleTemps.png"));
    protected static Texture pastTemps = new Texture(Gdx.files.internal("images/pastilleTemps.bmp"));
    protected static Texture perte = new Texture(Gdx.files.internal("images/Perte.bmp"));
    protected static FileHandle listeLaby = new FileHandle("Liste");

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
