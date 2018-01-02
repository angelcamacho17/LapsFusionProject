package com.github.squidat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import static com.github.squidat.Constants.WORLD_HEIGHT;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Angel Camacho on 27/08/17.
 */

public class GameStage extends Stage {
    private Board board;
    private Token toThrow;
    private Token hold;
    private Texture bg;
    private Random random;
    private Texture ring;
    private MyScore score;

    public GameStage(Viewport viewport, float board_dimension) {

        super(viewport);
        random = new Random();

        bg = new Texture("modoBg.png");
        Image bck= new Image(bg);
        addActor(bck);

        ring = new Texture("border-2.png");

        Image ringImage = new Image(ring);

        ringImage.setPosition(27,99);
        ringImage.setWidth(350);
        ringImage.setHeight(350);

        addActor(ringImage);

        board = new HexagonalBoard(board_dimension);

        board.addToStage(this);

        float size = board.getTokenSize();

        Behavior s= new Static();

        hold = new CircleToken(size/2, WORLD_HEIGHT / 2 +size*3-(size/3),random.nextInt(3), size,false,s);
        this.addActor(hold);

        score = new MyScore(0,size);
        this.addActor(score);

        Behavior b= new Throwable();

        toThrow = new CircleToken(board.getX(),board.getY() - 2*size,random.nextInt(3),size, false,b);
        setToThrow(toThrow);
        this.addActor(toThrow);

    }

    public Token getToThrow() {
        return toThrow;
    }

    public void setHold(int x){
        this.hold.remove();

        float size = board.getTokenSize();

        Behavior s= new Static();
        hold = new CircleToken(size/2, WORLD_HEIGHT / 2 +size*3-(size/3),x, size,false,s);
        this.addActor(hold);
        return;
    }

    public boolean changeToken(){
        return board.isTheCloserEmpty(this);
    }

   public void inspection(  ){

       /* do {

            board.currentToken(this).muevete( board.ajustFusion(board.currentToken(this)),this);

        }while(board.stillFusion(this));*/

    }

    public void moveToken(Token beingThrown, Behavior s, Behavior t){

        Token target = board.mostCenterClose(this);

       beingThrown.shooting(target,target,this,this.getHoldValue(),s,t);

    }

    public ArrayList<Token> isThereAnyNeighbors(Token targetCas){
        return board.neighborsTokens(this,targetCas);
    }

    public ArrayList<Token> getMyBoardTokens(){
        return board.getTokens();
    }

    public Token getHoldValue (){
        return hold;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setToThrow(Token toThrow) {
        this.toThrow = toThrow;
    }

    public Token getHold() {
        return hold;
    }

    public void setHold(Token hold) {
        this.hold = hold;
    }

    public Texture getBg() {
        return bg;
    }

    public void setBg(Texture bg) {
        this.bg = bg;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Texture getRing() {
        return ring;
    }

    public void setRing(Texture ring) {
        this.ring = ring;
    }
}
