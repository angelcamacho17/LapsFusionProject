package com.github.squidat;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;
/**
 * Created by Angel Camacho on 27/08/17.
 */
public class LapsFusion extends ApplicationAdapter {
    public GameStage stage;
    private Random random;
    private Token target;
    private int neighbors;
    private Behavior s= new Static();
    private Behavior t= new Throwable();
    //public static TextureAtlas textureAtlas;
    @Override
    public void create () {

        random = new Random();
        //textureAtlas = new TextureAtlas(Gdx.files.internal("casillas.atlas"));
        OrthographicCamera camera = new OrthographicCamera();
        Viewport viewport = new FitViewport(Constants.WORLD_WIDTH,Constants.WORLD_HEIGHT,camera);
        stage = new GameStage(viewport,Constants.DIMENSION);

        stage.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                final Token beingThrown = stage.getToThrow();
                Behavior m= new Static();
                beingThrown.setBehavior(m);

                if (stage.changeToken()==true){

                    stage.moveToken(beingThrown,s,t);

                    //int num=stage.board.mostHighNumberInTheBoard();

                    int randomValue=random.nextInt(6);

                    stage.setHold(randomValue);

                }
                else{

                    int aux= stage.getHold().getValue();
                    stage.getHold().changeValue(beingThrown.getValue(),s);
                    beingThrown.changeValue(aux,s);
                    Behavior t= new Throwable();
                    beingThrown.setBehavior(t);
                    stage.addActor(beingThrown);

                }
                //Perdemos el focus intencionalmente para no permitir cambio de direcciones
            }
        });
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render () {
        cls();
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width,height,true);
    }

    @Override
    public void dispose () {
        stage.dispose();
        //textureAtlas.dispose();
    }

    public static void cls() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
