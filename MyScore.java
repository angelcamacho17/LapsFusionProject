package com.github.squidat;

/**
 * Created by turismodeplaya on 02/01/18.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;

import static com.github.squidat.Constants.WORLD_HEIGHT;
import static com.github.squidat.Constants.WORLD_WIDTH;

public class MyScore extends Actor {

    private BitmapFont font;
    private int myScore;
    private float size;

    public MyScore(int m, float s){
        font = new BitmapFont();
        myScore = m;
        size = s;
       // font = new BitmapFont(Gdx.files.internal("data/nameOfFont.fnt"), Gdx.files.internal("data/nameOfFont.png"), false);
        font.getData().setScale(5,5);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font.setUseIntegerPositions(true);
        font.setColor(Color.WHITE);
    }

    int viewportHeight;
    BitmapFont titleFont;
    BitmapFont textFont;

    @Override
    public void draw(Batch batch, float parentAlpha) {
        font.draw(batch, ""+myScore, WORLD_WIDTH/2, WORLD_HEIGHT / 2 +size*5);
        //Also remember that an actor uses local coordinates for drawing within
        //itself!
    }

    public Actor hit(float x, float y) {
        // TODO Auto-generated method stub
        return null;
    }

}