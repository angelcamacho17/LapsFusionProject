package com.github.squidat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Angel Camacho on 13/12/17.
 */

public class CircleToken extends Token{

    public CircleToken(float x, float y, int value, float lado, boolean empty, Behavior b) {

        this.setRandom(new Random());
        this.setTextureAtlas(new TextureAtlas(Gdx.files.internal("LapsObjects-2.atlas")));
        this.setBehavior(b);
        this.setEmpty(empty);
        this.setValue(value);
        this.setGraphic(getTextureAtlas().findRegion(String.valueOf(value)));
        this.setBounds(x,y,lado,lado);
    }

    public Vector2 getPosition() {
        return new Vector2(getX(),getY());
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        getBehavior().draw(batch, parentAlpha, this);
        return;
    }

    public void changeValue(int newValue, Behavior b) {
        this.setValue(newValue);
        this.setEmpty(false);
        this.setBehavior(b);
        this.setGraphic(getTextureAtlas().findRegion(String.valueOf(newValue)));
    }

    public void fusion(final Token targetCas, final GameStage stage, final Behavior b) {

        //BUENA
        final Vector2 startingPos = new Vector2(this.getX(),this.getY());
        Vector2 targetPos = targetCas.getPosition();
        ThrowAction throwAction = new ThrowAction(targetPos);
        throwAction.setSpeed(600);

        //Lanzamos la casilla y creamos una nueva accion que cambie el valor de la casilla en el board
        SequenceAction sequenceAction = new SequenceAction();

        sequenceAction.addAction(throwAction);

       sequenceAction.addAction(new Action() {
            @Override
            public boolean act(float delta) {
                targetCas.changeValue(CircleToken.this.getValue()+1, b);
                stage.addActor(targetCas);
                return true;
            }
        });

        sequenceAction.addAction(new Action() {
            @Override
            public boolean act(float delta) {
                //Generar nuevo valor
                int index = 11;

                CircleToken.this.changeValue(index,b);

                CircleToken.this.setEmpty(true);
                //Mover pieza a su posicion original
                CircleToken.this.setPosition(startingPos.x,startingPos.y);
                CircleToken.this.setBehavior(b);
                return true;
            }
        });

        this.addAction(sequenceAction);

    }

    public void swipe(final Token targetCas, final GameStage stage ,final Behavior b) {

        final Vector2 startingPos = new Vector2(this.getX(),this.getY());
        Vector2 targetPos = targetCas.getPosition();
        ThrowAction throwAction = new ThrowAction(targetPos);
        throwAction.setSpeed(70);

        SequenceAction sequenceAction = new SequenceAction();

        sequenceAction.addAction(throwAction);

        sequenceAction.addAction(new Action() {
            @Override
            public boolean act(float delta) {
                targetCas.changeValue(CircleToken.this.getValue(),b);
                stage.addActor(targetCas);
                return true;
            }
        });

        sequenceAction.addAction(new Action() {
            @Override
            public boolean act(float delta) {
                //Generar nuevo valor
                int index = 11;

                CircleToken.this.changeValue(index,b);

                CircleToken.this.setEmpty(true);
                //Mover pieza a su posicion original
                CircleToken.this.setPosition(startingPos.x,startingPos.y);
                Behavior s= new Static();
                CircleToken.this.setBehavior(s);
                return true;
            }
        });
        this.addAction(sequenceAction);

    }

    public void shooting(final Token targetCas, final Token targetCas2, final GameStage stage, final Token nextOne, final Behavior s, final Behavior t) {

        setNeighbors(0); GameStage aux = stage;

        final Vector2 startingPos = new Vector2(this.getX(),this.getY());
        Vector2 targetPos = targetCas.getPosition();
        ThrowAction throwAction = new ThrowAction(targetPos);

        throwAction.setSpeed(Constants.THROW_SPEED);

        //Lanzamos la casilla y creamos una nueva accion que cambie el valor de la casilla en el board

        SequenceAction sequenceAction = new SequenceAction();

        sequenceAction.addAction(throwAction);

        sequenceAction.addAction(new Action() {
            @Override
            public boolean act(float delta) {

                if (stage.isThereAnyNeighbors(targetCas) != null) {

                    if( stage.isThereAnyNeighbors(targetCas).size()>3) {

                             setNeighbors( stage.isThereAnyNeighbors(targetCas).size());

                            for (Token c : stage.isThereAnyNeighbors(targetCas)) {

                                c.fusion(targetCas, stage,targetCas.getBehavior());

                            }

                                for (Token t: stage.getMyBoardTokens()){

                                for (Token c : stage.isThereAnyNeighbors( targetCas)) {

                                    if ((t.getX()==c.getX())&&(t.getY()==c.getY())){

                                        t.setEmpty(true);
                                    }
                                  }
                                }
                    }

                }
                return true;
            }
        });

        sequenceAction.addAction(new Action() {
            @Override
            public boolean act(float delta) {

                targetCas.changeValue(CircleToken.this.getValue(),s);
                stage.addActor(targetCas);

                return true;

            }
        });


         sequenceAction.addAction(new Action() {
            @Override
            public boolean act(float delta) {

                if (stage.getBoard().makeAjust(targetCas)) {

                    if (getNeighbors() > 3) {

                        Token aux= stage.getBoard().ajustFusion(targetCas);

                        targetCas.swipe(aux,stage,targetCas.getBehavior());

                    }
                }

                return true;
            }

        });


        sequenceAction.addAction(new Action() {
            @Override
            public boolean act(float delta) {

                int index = nextOne.getValue();
                CircleToken.this.changeValue(index,t);
                //Mover pieza a su posicion original
                CircleToken.this.setPosition(startingPos.x,startingPos.y);
                CircleToken.this.setBehavior(t);
                return true;
            }
        });

        this.addAction(sequenceAction);

    }

    public void auxSwipe( Token aux,  GameStage stage , Behavior b){

        this.swipe(aux,stage,this.getBehavior());

    }

    public void reajustPosition( GameStage stage){

        if (stage.getBoard().makeAjust(this)){

            Token aux;

            aux= stage.getBoard().ajustFusion(this);

            fusion(aux, stage, aux.getBehavior());
        }

    }


}

