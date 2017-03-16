package fr.ul.rollingball.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;

import javax.management.relation.RoleInfo;

import fr.ul.rollingball.RollingBall;
import fr.ul.rollingball.dataFactories.SoundFactory;
import fr.ul.rollingball.dataFactories.TextureFactory;
import fr.ul.rollingball.models.GameState;
import fr.ul.rollingball.models.World;

/**
 * Created by molina9u on 24/01/17.
 */

public class GameScreen extends ScreenAdapter {
    protected RollingBall rollBall;
    protected SpriteBatch listeAff;
    protected World monde;
    protected OrthographicCamera camera;
    protected GameState state;

    protected FreeTypeFontGenerator fontGen;
    protected FreeTypeFontGenerator.FreeTypeFontParameter fontCarac;
    protected BitmapFont police;

    protected float tempsEcoule,tempsTotal, tempsDebut;

    public GameScreen(RollingBall rb){
        rollBall=rb;

        listeAff=new SpriteBatch();

        monde=new World(this);

        camera = new OrthographicCamera(monde.getWidth(),monde.getHeight());
        camera.position.set(camera.viewportWidth/2f,camera.viewportHeight/2f,15f);
        camera.update();
        listeAff.setProjectionMatrix(camera.combined);

        fontGen = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Comic_Sans_MS_Bold.ttf"));
        fontCarac = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontCarac.size = 40;
        fontCarac.color = new Color(1,1,0,0.75f);
        fontCarac.borderColor = Color.BLACK;
        fontCarac.borderWidth = 3;

        police = new BitmapFont();
        police = fontGen.generateFont(fontCarac);
        fontGen.dispose();

        tempsEcoule = 0;
        tempsTotal = 0;
        tempsDebut = 0;

        state = new GameState();
    }

    public void render(float delta){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        update();
        listeAff.begin();
        monde.draw(listeAff);

        police.draw(listeAff,"Score : "+this.getScoreString(),monde.getWidth()/1.3f-20,monde.getHeight()-50);
        police.draw(listeAff,"Temps : "+this.getTempsString(),monde.getWidth()/3,monde.getHeight()-50);


        tempsEcoule+=delta;
        if (tempsEcoule>1 ) {
            if ( state.getTimeLeft()>=0) {
                state.runningTime(1);
            }
            tempsTotal += 1;
            tempsEcoule = 0;
        }

        if (state.isWon()){
           changeLaby();
        }else{
            if (state.isLost()){

            }
        }


        listeAff.end();
    }

    public void update(){
        float accelX = Gdx.input.getAccelerometerX();
        float accelY = Gdx.input.getAccelerometerY();

        monde.getBoule().addVitesse(new Vector2(accelY/20,-accelX/20));
        monde.getBoule().updateObject();
    }

    public void upScore(){
        state.upScore(10);
    }

    public int getScore(){
        return state.getScore();
    }

    public String getTempsString(){
        return Integer.toString(state.getTimeLeft());
    }

    public String getScoreString(){
        return Integer.toString(state.getScore());
    }

    public void upTimeLeft(){
        state.upTimeLeft(10);
    }

    public void setBallOut(){
        state.setCurrentState(GameState.etats.Victory);
    }

    public void changeLaby(){
        if (tempsDebut == 0) {
            SoundFactory.getInstance().playVictoire(0.5f);
            tempsDebut = tempsTotal ;
        }
        if (tempsDebut +2 >= tempsTotal ) {
            int largeur = TextureFactory.getInstance().getBravo().getWidth()/2;
            int hauteur = TextureFactory.getInstance().getBravo().getHeight()/2;
            listeAff.draw(TextureFactory.getInstance().getBravo(), monde.getWidth() / 2 - largeur, monde.getHeight() / 2 - hauteur);
        }else{
            monde.resetBall();
            monde.changeLaby((monde.getNumLaby()+1)%TextureFactory.getInstance().getNbLaby());
            state.setPillsEaten(0);
            state.setCurrentState(GameState.etats.Running);
            state.resetTime();
            tempsDebut = 0;
        }

    }

    public void dispose(){
        listeAff.dispose();

    }
}
