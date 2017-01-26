package fr.ul.rollingball.dataFactories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by molina9u on 24/01/17.
 */
public class TextureFactory {
    protected static Texture intro=new Texture(Gdx.files.internal("images/Intro.jpg"));
    protected static Texture decor=new Texture(Gdx.files.internal("images/Deco.jpg"));
    private static TextureFactory ourInstance = new TextureFactory();

    public static TextureFactory getInstance() {
        return ourInstance;
    }

    private TextureFactory() {
    }

    public static Texture getIntro() {
        return intro;
    }

    public static Texture getDecor() {
        return decor;
    }
}
