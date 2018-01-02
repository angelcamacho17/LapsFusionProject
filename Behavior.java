package com.github.squidat;

import com.badlogic.gdx.graphics.g2d.Batch;

/**
 * Created by Angel Camacho on 27/08/17.
 */

public interface Behavior {
     void draw(Batch batch, float parentAlpha, Token token) ;
}
