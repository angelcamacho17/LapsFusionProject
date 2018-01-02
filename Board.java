package com.github.squidat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.sun.javafx.geom.AreaOp;

import java.util.ArrayList;
import java.util.Random;

import static com.github.squidat.Constants.WORLD_HEIGHT;
import static com.github.squidat.Constants.WORLD_WIDTH;

/**
 * Created by Angel Camacho on 27/08/17.
 */

public abstract class Board extends Actor {

    private ArrayList<Token> tokens;
    private ArrayList<Box> boxes;
    private Token lastTarget;
    private float dimension;
    private Random random;
    private float padding;
    private float tokenSize;

    public abstract void createTokens() ;

    public abstract void addToStage(Stage stage) ;

    public abstract double distanceBetweenTokens (float x, float y);

    public abstract boolean isTheCloserEmpty(GameStage stage);

    public abstract boolean makeAjust(Token checkBox);

    public abstract Token  ajustFusion(Token checkBox);

    public abstract Token mostCenterClose(GameStage stage);

    public abstract ArrayList<Token> tertiaryNeighbors(Token tertiary, GameStage stage);

    public abstract ArrayList<Token> secundaryNeighbors(Token secundary, GameStage stage);

    public abstract ArrayList<Token> neighborsTokens(GameStage stage,Token target);

    public abstract int mostHighNumberInTheBoard();

    public abstract boolean stillFusion(GameStage stage);

    public abstract Token currentToken(GameStage stage);

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public void setTokens(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }

    public float getTokenSize(){
        return tokenSize;
    }

    public Token getLastTarget() {
        return lastTarget;
    }

    public void setLastTarget(Token lastTarget) {
        this.lastTarget = lastTarget;
    }

    public float getDimension() {
        return dimension;
    }

    public void setDimension(float dimension) {
        this.dimension = dimension;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public float getPadding() {
        return padding;
    }

    public void setPadding(float padding) {
        this.padding = padding;
    }

    public void setTokenSize(float tokenSize) {
        this.tokenSize = tokenSize;
    }
}
