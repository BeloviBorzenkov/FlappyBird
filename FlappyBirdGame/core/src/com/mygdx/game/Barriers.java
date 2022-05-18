package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;
import java.util.Random;

public class Barriers {
    class Pair{
        Vector2 pos;
        float speed;
        int offset;
        Rectangle space;

        public Pair(Vector2 position){
            pos = position;
            speed = 3.3f;
            offset = MathUtils.random(-100, 100);;
            space = new com.badlogic.gdx.math.Rectangle(pos.x,pos.y - offset + 320,52,BetwenDistance);
        }
        public void Update(){
            pos.x -= speed;
            if(pos.x < -50){
                pos.x = 800;
                offset = MathUtils.random(-100, 100);
            }
            space.x = pos.x;
            space.y= pos.y - offset + 320;
        }
    }
    static Pair[] bar;
    Texture down;
    Texture up;
    int BetwenDistance;

    public Barriers(){
        down = new Texture("pipe-down.png");
        up = new Texture("pipe-up.png");
        bar = new Pair[4];
        BetwenDistance = 110;
        int StartPos = 400;
        for (int i = 0; i < bar.length; i++) {
            bar[i] = new Pair(new Vector2(StartPos,-50));
            StartPos += 220;
        }
    }

    public void render(SpriteBatch batch){
        for (int i = 0; i < bar.length; i++) {
            batch.draw(up,bar[i].pos.x,bar[i].pos.y - bar[i].offset);
            batch.draw(down,bar[i].pos.x,bar[i].pos.y + BetwenDistance + down.getHeight() - bar[i].offset);
        }

    }
    public void update(){
        for (int i = 0; i < bar.length; i++) {
            bar[i].Update();
            
        }
    }

    public void recreate(){
        int StartPos = 600;
        for (int i = 0; i < bar.length; i++) {
            bar[i] = new Pair(new Vector2(StartPos,-50));
            StartPos += 220;

        }
    }

}
