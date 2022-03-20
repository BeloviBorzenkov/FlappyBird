package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class block {

    private Texture img;
    private Vector2 pos;

    public block(){
        img = new Texture("block.png");
        pos = new Vector2(0,-100);
    }
    public void render(SpriteBatch batch){
        batch.draw(img,pos.x,pos.y);

    }
}
