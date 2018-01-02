package com.github.squidat;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import java.util.ArrayList;
import java.util.Random;
import static com.github.squidat.Constants.WORLD_HEIGHT;
import static com.github.squidat.Constants.WORLD_WIDTH;

/**
 * Created by Angel Camacho on 12/12/17.
 */

public class HexagonalBoard extends Board {

    public HexagonalBoard(float dimension) {

        this.setPadding ( WORLD_WIDTH - 2 * Constants.WORLD_PADDING);
        this.setBounds(Constants.WORLD_PADDING, (WORLD_HEIGHT - getPadding()) / 2, getPadding(), getPadding());
        this.setDimension(dimension);
        this.setTokenSize( getPadding() / dimension);
        this.setRandom(new Random());
        createTokens();
        this.setTouchable(Touchable.disabled);
    }

    public void createTokens() {

        int casilla_value = 11;
        Behavior b= new Static();
        setTokens(new ArrayList<Token>());
        setBoxes( new ArrayList<Box>());

        float width = WORLD_WIDTH / 2- getTokenSize()/2;
        float height = WORLD_HEIGHT / 2- getTokenSize()*2;
        float correction = getTokenSize()/15;
        float xMove = width;
        float yMove =height;

        // Build the center box
        Box box = new Box(xMove, yMove, getTokenSize(),false);
        getBoxes().add(box); //ADD 0


        // Build the box above the center
        yMove += getTokenSize()+correction;
         box = new Box(xMove, yMove, getTokenSize(),false);
        getBoxes().add(box);//ADD 1

        // Build the box in the right-Top corner of the center
        yMove = height+ getTokenSize()/2+correction;
        xMove+= getTokenSize()+correction;
         box = new Box(xMove, yMove, getTokenSize(),false);
        getBoxes().add(box);//ADD 2

        // Build the box in the right-Bottom corner of the center
        yMove = height - getTokenSize()/2-correction;
        //Same X
        box = new Box(xMove, yMove, getTokenSize(),false);
        getBoxes().add(box);//ADD 3

        // Build the one bellow the center
        yMove = height- getTokenSize()-correction;
        xMove = width;// MIDDLE
        box = new Box(xMove, yMove, getTokenSize(),false);
        getBoxes().add(box);//ADD 4

        // Build the box in the left-Bottom corner of the center
        yMove = height- getTokenSize()/2-correction;
        xMove = width-getTokenSize()-correction;
        box = new Box(xMove, yMove, getTokenSize(),false);
        getBoxes().add(box);//ADD 5

        // Build the box in the left-Top corner of the center
        yMove = height+ getTokenSize()/2+correction;
        box = new Box(xMove, yMove, getTokenSize(),false);
        getBoxes().add(box);//ADD 6

        //Build the highest box
        yMove = height  +   (2*getTokenSize())  +  getTokenSize()/4;
        xMove = width;// MIDDLE
        box = new Box(xMove, yMove, getTokenSize(),true);
        getBoxes().add(box);//ADD 7

        //Build the one in right-top-corner parallel to the center
        yMove = height+(getTokenSize()*2)-getTokenSize()/6;
        xMove =  width+ getTokenSize() + getTokenSize()/4;
        box = new Box(xMove, yMove, getTokenSize(),true);
        getBoxes().add(box);//ADD 8

        //Build the box above the one in the right-boder parallel to the center
        yMove = height+getTokenSize();
        xMove =  width+getTokenSize()*2;
        box = new Box(xMove, yMove, getTokenSize(),true);
        getBoxes().add(box);//ADD 9

        // Build the box in the right-border parallel to the center
        yMove = height;
        xMove = width+getTokenSize()*2+getTokenSize()/4;
        box = new Box(xMove, yMove, getTokenSize(),true);
        getBoxes().add(box);//ADD 10

        //Build the box bellow the right-boder parallel to the center

        yMove= height-getTokenSize();
        xMove=  width+getTokenSize()*2;
        box = new Box(xMove, yMove, getTokenSize(),true);
        getBoxes().add(box);//ADD 11

        //Build the one in right-bottom-corner parallel to the center

        yMove= height-getTokenSize()*2+getTokenSize()/6;
        xMove=  width+getTokenSize()+getTokenSize()/4;
        box = new Box(xMove, yMove, getTokenSize(),true);
        getBoxes().add(box);//ADD 12

        // Build the bellowest box
        xMove= width;
        yMove = height-2*getTokenSize()-getTokenSize()/4;
        box = new Box(xMove, yMove, getTokenSize(),true);
        getBoxes().add(box);//ADD 13

        //Build the one in left-bottom-corner parallel to the center

        xMove=  width-getTokenSize()-getTokenSize()/4;
        yMove= height-getTokenSize()*2+getTokenSize()/6;
        box = new Box(xMove, yMove, getTokenSize(),true);
        getBoxes().add(box);//ADD 14

        //Build the box bellow the left-boder parallel to the center

        xMove=  width-getTokenSize()*2;
        yMove= height-getTokenSize();
        box = new Box(xMove, yMove, getTokenSize(),true);
        getBoxes().add(box);//ADD 15

        //Build the box in the left-boder parallel to the center
        yMove= height;
        xMove=  width-getTokenSize()*2-getTokenSize()/4;
        box = new Box(xMove, yMove, getTokenSize(),true);
        getBoxes().add(box);//ADD 16

        //Build the box above the one in left-boder parallel to the center

        xMove=  width-getTokenSize()*2;
        yMove= height+getTokenSize();
        box = new Box(xMove, yMove, getTokenSize(),true);
        getBoxes().add(box);//ADD 17

        //Build the one in left-top-corner parallel to the center

        xMove=  width-getTokenSize()-getTokenSize()/4;
        yMove= height+getTokenSize()*2-getTokenSize()/6;
        box = new Box(xMove, yMove, getTokenSize(),true);
        getBoxes().add(box);//ADD 18

        yMove=height;
        xMove=width;

        // Build the center box
        Token token = new CircleToken(xMove, yMove, getRandom().nextInt(4), getTokenSize(),false,b);
        getTokens().add(0,token); //ADD 0


        // Build the box above the center
        yMove += getTokenSize()+correction;
        token = new CircleToken(xMove, yMove, getRandom().nextInt(4), getTokenSize(),false,b);
        getTokens().add(1,token);//ADD 1

        // Build the box in the right-Top corner of the center
        yMove = height+ getTokenSize()/2+correction;
        xMove+= getTokenSize()+correction;
        token = new CircleToken(xMove, yMove, getRandom().nextInt(4), getTokenSize(),false,b);
        getTokens().add(2,token);//ADD 2

        // Build the box in the right-Bottom corner of the center
        yMove = height - getTokenSize()/2-correction;
        //Same X
        token = new CircleToken(xMove, yMove, getRandom().nextInt(4), getTokenSize(), false,b);
        getTokens().add(3,token);//ADD 3

        // Build the one bellow the center
        yMove = height- getTokenSize()-correction;
        xMove = width;// MIDDLE
        token = new CircleToken(xMove, yMove, getRandom().nextInt(3), getTokenSize(),false,b);
        getTokens().add(4,token);//ADD 4

        // Build the box in the left-Bottom corner of the center
        yMove = height- getTokenSize()/2-correction;
        xMove = width-getTokenSize()-correction;
        token = new CircleToken(xMove, yMove, getRandom().nextInt(4), getTokenSize(),false,b);
        getTokens().add(5,token);//ADD 5

        // Build the box in the left-Top corner of the center
        yMove = height+ getTokenSize()/2+correction;
        token = new CircleToken(xMove, yMove, getRandom().nextInt(4), getTokenSize(),false,b);
        getTokens().add(6,token);//ADD 6

        //Build the highest box
        yMove = height  +   (2*getTokenSize())  +  getTokenSize()/4;
        xMove = width;// MIDDLE
        token = new CircleToken(xMove, yMove, casilla_value, getTokenSize(), true,b);
        getTokens().add(7,token);//ADD 7

        //Build the one in right-top-corner parallel to the center
        yMove = height+(getTokenSize()*2)-getTokenSize()/6;
        xMove =  width+ getTokenSize() + getTokenSize()/4;
        token = new CircleToken(xMove, yMove, casilla_value, getTokenSize(),true,b);
        getTokens().add(8,token);//ADD 8

        //Build the box above the one in the right-boder parallel to the center
        yMove = height+getTokenSize();
        xMove =  width+getTokenSize()*2;
        token = new CircleToken(xMove, yMove, casilla_value, getTokenSize(), true,b);
        getTokens().add(9,token);//ADD 9

        // Build the box in the right-border parallel to the center
        yMove = height;
        xMove = width+getTokenSize()*2+getTokenSize()/4;
        token = new CircleToken(xMove, yMove, casilla_value, getTokenSize(),true,b);
        getTokens().add(10,token);//ADD 10

        //Build the box bellow the right-boder parallel to the center

        yMove= height-getTokenSize();
        xMove=  width+getTokenSize()*2;
        token = new CircleToken(xMove, yMove, casilla_value, getTokenSize(), true,b);
        getTokens().add(11,token);//ADD 11

        //Build the one in right-bottom-corner parallel to the center

        yMove= height-getTokenSize()*2+getTokenSize()/6;
        xMove=  width+getTokenSize()+getTokenSize()/4;
        token = new CircleToken(xMove, yMove, casilla_value, getTokenSize(),true,b);
        getTokens().add(12,token);//ADD 12

        // Build the bellowest box
        xMove= width;
        yMove = height-2*getTokenSize()-getTokenSize()/4;
        token = new CircleToken(xMove, yMove, casilla_value, getTokenSize(),true,b);
        getTokens().add(13,token);//ADD 13

        //Build the one in left-bottom-corner parallel to the center

        xMove=  width-getTokenSize()-getTokenSize()/4;
        yMove= height-getTokenSize()*2+getTokenSize()/6;
        token = new CircleToken(xMove, yMove, casilla_value, getTokenSize(),true,b);
        getTokens().add(14,token);//ADD 14

        //Build the box bellow the left-boder parallel to the center

        xMove=  width-getTokenSize()*2;
        yMove= height-getTokenSize();
        token = new CircleToken(xMove, yMove, casilla_value, getTokenSize(),true,b);
        getTokens().add(15,token);//ADD 15

        //Build the box in the left-boder parallel to the center
        yMove= height;
        xMove=  width-getTokenSize()*2-getTokenSize()/4;
        token = new CircleToken(xMove, yMove, casilla_value, getTokenSize(),true,b);
        getTokens().add(16,token);//ADD 16

        //Build the box above the one in left-boder parallel to the center

        xMove=  width-getTokenSize()*2;
        yMove= height+getTokenSize();
        token = new CircleToken(xMove, yMove, casilla_value, getTokenSize(), true,b);
        getTokens().add(17,token);//ADD 17

        //Build the one in left-top-corner parallel to the center

        xMove=  width-getTokenSize()-getTokenSize()/4;
        yMove= height+getTokenSize()*2-getTokenSize()/6;
        token = new CircleToken(xMove, yMove, casilla_value, getTokenSize(), true,b);
        getTokens().add(18,token);//ADD 18

    }

    public void addToStage(Stage stage) {
        stage.addActor(this);

        for (Box b: getBoxes()){
            stage.addActor(b);
        }

        for (Token t:  getTokens()) {
            stage.addActor(t);
        }
    }

    public double distanceBetweenTokens (float x, float y){

        double vectorXY=0f;

        vectorXY=Math.sqrt((x*x)+(y*y));

        return vectorXY;
    }

    public boolean isTheCloserEmpty(GameStage stage){ // Find the closer box, and ask if is it empty

        float g=100f; float closer=0f;
        Token thrown= stage.getToThrow();
        Token target=stage.getToThrow();
        float distanceX=0f;float distanceY=0f;
        for (Token c:  getTokens()) {

            distanceX= Math.abs(c.getX()-thrown.getX());
            distanceY= Math.abs(c.getY()-thrown.getY());
            closer=(float) Math.abs(distanceBetweenTokens(distanceX,distanceY));

            if (closer<=g){
                g=closer;
                target=c;
            }
        }

        return target.getEmpty();
    }

    public boolean makeAjust(Token checkBox){

        if( getTokens().get(0).getEmpty()==true)
            return true;

        for (int i=1; i<7; i++){
            if (( getTokens().get(i).getX()== checkBox.getX())&&( getTokens().get(i).getY()== checkBox.getY()))
                return false;
        }

        return true;
    }

    public Token  ajustFusion(Token checkBox){

        Token target=checkBox;
        float g=75;
        float distanceBetweenTokens=0; float distanceX=0f;float distanceY=0f;


        if ( getTokens().get(0).getEmpty()==true) {
            return  getTokens().get(0);
        }

        for (int i=1; i<7; i++)
        {

            distanceX= Math.abs( getTokens().get(i).getX()-checkBox.getX());

            distanceY= Math.abs( getTokens().get(i).getY()-checkBox.getY());

            distanceBetweenTokens=(float) Math.abs(distanceBetweenTokens(distanceX,distanceY));

            if ((distanceBetweenTokens<=g)&&( getTokens().get(i).getEmpty()==true)){

                g= distanceBetweenTokens;

                target= getTokens().get(i);
            }

        }


        return target;
    }

    public Token mostCenterClose(GameStage stage){

        Token thrown=  stage.getToThrow();

        Token target= stage.getToThrow();

        float y=180f;

        float g=140f;

        float w=140f;

        float x=180f;

        float distanceX=0f;

        float distanceY=0f;

        for (int i=0; i<7; i++){

            if ( getTokens().get(0).getEmpty()==true){

                return  getTokens().get(0);
            }

            else {

                distanceX= Math.abs( getTokens().get(i).getX()-thrown.getX());

                distanceY= Math.abs( getTokens().get(i).getY()-thrown.getY());

                x=(float) Math.abs(distanceBetweenTokens(distanceX,distanceY));

                if ((x<=g)&&( getTokens().get(i).getEmpty()==true)){
                    g= x;
                    target= getTokens().get(i);
                }
            }
        }
        if (target== stage.getToThrow()){

            for (int i=7; i<=18; i++){


                distanceX= Math.abs( getTokens().get(i).getX()-thrown.getX());
                distanceY= Math.abs( getTokens().get(i).getY()-thrown.getY());
                y=(float) Math.abs(distanceBetweenTokens(distanceX,distanceY));

                if ((y<=w)&&( getTokens().get(i).getEmpty()==true)){
                    w= y;
                    target= getTokens().get(i);
                }
            }
        }

        //lastTarget = target;

        return target;
    }


    public ArrayList<Token> tertiaryNeighbors(Token tertiary, GameStage stage){// Similar tertiary Neighbors boxes to the toThrow ball

        float g=75f; float closer=0f;

        ArrayList<Token> neighbors = new ArrayList<Token>();

        float distanceX=0f;float distanceY=0f;

        for (int i=0; i<=18; i++) {

            distanceX= Math.abs( getTokens().get(i).getX()-tertiary.getX());
            distanceY= Math.abs( getTokens().get(i).getY()-tertiary.getY());

            closer=(float) Math.abs(distanceBetweenTokens(distanceX,distanceY));

            if ((closer<=g)&&( getTokens().get(i).getValue()==stage.getToThrow().getValue())){
                //System.out.println("Terceros vecinos: "+ closer );
                neighbors.add( getTokens().get(i));

            }
        }

        return neighbors;
    }

    public ArrayList<Token> secundaryNeighbors(Token secundary, GameStage stage){// Similar secundary Neighbors boxes to the toThrow ball


        float g=75f; float closer=0f;

        ArrayList<Token> neighbors = new ArrayList<Token>();

        ArrayList<Token> terNeighbors = new ArrayList<Token>();

        float distanceX=0f;float distanceY=0f;

        for (int i=0; i<=18; i++) {

            distanceX= Math.abs( getTokens().get(i).getX()-secundary.getX());

            distanceY= Math.abs( getTokens().get(i).getY()-secundary.getY());

            closer=(float) Math.abs(distanceBetweenTokens(distanceX,distanceY));

            if ((closer<=g)&&( getTokens().get(i).getValue()==stage.getToThrow().getValue())){
                //System.out.println("Segundos vecinos: "+ closer );
                neighbors.add( getTokens().get(i));

                terNeighbors= tertiaryNeighbors( getTokens().get(i), stage);

                if (terNeighbors!=null) {
                    neighbors.addAll(terNeighbors);
                }
            }
        }

        return neighbors;
    }

    public ArrayList<Token> neighborsTokens(GameStage stage, Token target){// Similar Neighbors boxes to the toThrow ball

        float g=75f; float closer=0f;

        ArrayList<Token> neighbors = new ArrayList<Token>();

        ArrayList<Token> secNeighbors = new ArrayList<Token>();

        float distanceX=0f;float distanceY=0f;

        for (int i=0; i<=18; i++) {

            distanceX= Math.abs( getTokens().get(i).getX()-target.getX());

            distanceY= Math.abs( getTokens().get(i).getY()-target.getY());

            closer=(float) Math.abs(distanceBetweenTokens(distanceX,distanceY));

            if ((closer<=g)&&( getTokens().get(i).getValue()==stage.getToThrow().getValue())){

                neighbors.add( getTokens().get(i));

                secNeighbors= secundaryNeighbors( getTokens().get(i), stage);

                if (secNeighbors!=null){

                    neighbors.addAll(secNeighbors);
                }
            }
        }

        return neighbors;
    }

    public boolean stillFusion(GameStage stage){

        for (Token t:  getTokens()){
            if (neighborsTokens(stage,t).size()>3){
                return true;
            }
        }
        return false ;
    }

    public Token currentToken(GameStage stage){

        for (Token t:  getTokens()){
            if (neighborsTokens(stage,t).size()>3){
                return t;
            }
        }
        return  getTokens().get(0);

    }

   public int  mostHighNumberInTheBoard(){

       int i=0;

       for (Token t:  getTokens()){
           if (t.getValue()>i)
               i=t.getValue();
       }
       return i;
   }

}
