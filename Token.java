package com.github.squidat;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.BinaryHeap;
import com.github.squidat.GameStage;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Angel Camacho on 27/08/17.
 */

public abstract class Token extends Actor {

    private TextureRegion graphic;
    private static TextureAtlas textureAtlas;
    private int value;
    private boolean empty;
    private  Behavior behavior;
    private int neighbors=0;
    private Random random;
    private boolean band=false;

    public boolean getBand() {
        return band;
    }

    public void setBand(boolean band) {
        this.band = band;
    }

    public abstract Vector2 getPosition();

    public abstract void draw(Batch batch, float parentAlpha);

    public abstract void changeValue(int newValue, Behavior b) ;

    public abstract void fusion(final Token targetCas, final GameStage stage,final Behavior b) ;

    public abstract void shooting(final Token targetCas, final Token targetCas2, final GameStage stage, final Token nextOne,  final Behavior s,  final Behavior t);

    public abstract void swipe(Token aux, GameStage stage, final Behavior b);

    public TextureRegion getGraphic() {
        return graphic;
    }

    public abstract void auxSwipe( Token aux,  GameStage stage , Behavior b);

    public void setGraphic(TextureRegion graphic) {
        this.graphic = graphic;
    }

    public static TextureAtlas getTextureAtlas() {
        return textureAtlas;
    }

    public static void setTextureAtlas(TextureAtlas textureAtlas) {
        Token.textureAtlas = textureAtlas;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean getEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public Behavior getBehavior() {
        return behavior;
    }

    public int getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(int neighbors) {
        this.neighbors = neighbors;
    }

    public Random getRandom() {
        return random;
    }

    public void setBehavior(Behavior b){

        this.behavior=b;
        return;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
