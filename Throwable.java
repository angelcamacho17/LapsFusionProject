package com.github.squidat;

import com.badlogic.gdx.graphics.g2d.Batch;

/**
 * Created by Angel Camacho on 27/08/17.
 */

public class Throwable implements Behavior{

    private static float angulo;

    public void draw(Batch batch, float parentAlpha, Token token)  {

        if (angulo >= (2.0f * Math.PI)) {
            angulo = 0.0f;
            double x = 175f + (170f * Math.cos(2 * angulo));
            double y = 250f + (170f * Math.sin(2 * angulo));
            batch.draw(token.getGraphic(), (float) x, (float) y, token.getWidth(), token.getHeight());
            token.setX((float) x);
            token.setY((float) y);
        } else {
            angulo -= 0.0174533f;
            double x = 175f + (170f * Math.cos(2 * angulo));
            double y = 250f + (170f * Math.sin(2 * angulo));
            batch.draw(token.getGraphic(), (float) x, (float) y, token.getWidth(), token.getHeight());
            token.setX((float) x);
            token.setY((float) y);
        }

    }
}
