package com.github.squidat;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

/**
 * Created by Angel Camacho on 26/12/17.
 */

public class Rotate  extends MoveToAction {
    private final String TAG = getClass().getSimpleName();
    private float speed;
    //BUENA
    public Rotate(Vector2 targetPos) {
        super();
        this.setPosition(targetPos.x,targetPos.y);
    }

    public float calculateTime(float speed) {
        Actor actor = getActor();
        if (actor != null) {
            float targetX = this.getX();
            float targetY = this.getY();
            //System.out.println("TargetX: "+getX()+"---"+" TargetY "+getY());
            float currentX = actor.getX();
            float currentY = actor.getY();
            //System.out.println("currentX: "+currentX+"---"+"currentY: "+currentY);
            //Armamos el vector distancia con los puntos current y target
            Vector2 distancia = new Vector2(currentX - targetX, currentY - targetY);
            //Modulo del vector distancia
            float distancia_mod = distancia.len();
            //Calculamos el tiempo necesario para mantener la velocidad constante usando
            //la formula V = d/t

            return distancia_mod/speed ;
        }
        return 0f;
    }

    @Override
    public void setActor(Actor actor) {
        super.setActor(actor);
        float dur = calculateTime(speed);
        this.setDuration(dur);
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

}
