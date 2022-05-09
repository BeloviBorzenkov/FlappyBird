package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;

public class Bird {
    Texture img;
    Vector2 pos;
    float vy;
    float falling;

    public Bird(){
        img = new Texture("bluebird-midflap.png");
        pos = new Vector2(100,380);
        vy = 0;
        falling = -0.5f;
    }

    public void render(SpriteBatch batch){
        batch.draw(img,pos.x,pos.y);
    }

    public void update(){

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            vy = 4;
        }
        vy += falling;
        pos.y += vy;

    }
    public void recreate(){
        pos = new Vector2(100,380);
        vy = 0;
    }


}
