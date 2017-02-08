package fr.ul.rollingball.dataFactories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;

/**
 * Created by molina9u on 03/02/17.
 */
public class SoundFactory {
    private static Sound victoire= Gdx.audio.newSound(Gdx.files.internal("sounds/victoire.mp3"));
    private static Sound alerte= Gdx.audio.newSound(Gdx.files.internal("sounds/alerte.mp3"));
    private static Sound collision= Gdx.audio.newSound(Gdx.files.internal("sounds/collision.wav"));
    private static Sound pastille= Gdx.audio.newSound(Gdx.files.internal("sounds/pastille.wav"));
    private static Sound perte= Gdx.audio.newSound(Gdx.files.internal("sounds/perte.mp3"));
    private static Sound ptaille= Gdx.audio.newSound(Gdx.files.internal("sounds/ptaille.wav"));
    private static Sound ptemps= Gdx.audio.newSound(Gdx.files.internal("sounds/ptemps.wav"));

    private static SoundFactory ourInstance = new SoundFactory();


    public static SoundFactory getInstance() {
        return ourInstance;
    }

    private SoundFactory() {
    }

    public static void playVictoire(float volume) {
        victoire.play(volume);
    }
    public static void playCollision(float volume) {
        collision.play(volume);
    }
    public static void playPastille(float volume) {
        pastille.play(volume);
    }
    public static void playPerte(float volume) {
        perte.play(volume);
    }
    public static void playPtaille(float volume) {
        ptaille.play(volume);
    }
    public static void playPTemps(float volume) {
        ptemps.play(volume);
    }
    public static void playAlerte(float volume) {
        alerte.play(volume);
    }
}
