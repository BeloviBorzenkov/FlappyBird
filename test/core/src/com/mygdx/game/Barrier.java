package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Barrier {
    private int x;
    private int y;
    private float speed;
    private static Texture BarrierTexture;

    public static void setBarrierTexture(Texture barrierTexture) {
        BarrierTexture = barrierTexture;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Barrier(int x, int y, float speed ){
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void render(SpriteBatch batch){
        batch.draw(BarrierTexture, x, y);
    }

    public void update(){
        x -= speed;
        if(x < -52 ){x = 852;}


    }


}