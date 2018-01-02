package com.github.squidat;

import com.badlogic.gdx.graphics.g2d.Batch;

/**
 * Created by Angel Camacho on 27/08/17.
 */

public class Static implements Behavior {
    public void draw(Batch batch, float parentAlpha, Token token)  {

        batch.draw(token.getGraphic(), token.getX(), token.getY(), token.getWidth(), token.getHeight());
    }
}
