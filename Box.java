package com.github.squidat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Angel Camacho on 26/12/17.
 */

public class Box extends Actor {
    private TextureRegion graphic;
    private static TextureAtlas textureAtlas;
    private boolean empty;

    public Box(float x, float y, float lado, boolean e) {

        textureAtlas = new TextureAtlas(Gdx.files.internal("LapsObjects-2.atlas"));
        this.empty = e;
        graphic = textureAtlas.findRegion(String.valueOf(11));
        this.setBounds(x, y, lado, lado);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(graphic,getX(),getY(), getWidth(), getHeight());
        return;
    }
}


