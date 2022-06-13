package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


//просто для теста
public class block {

    class Grass{
        private Texture img;
        private Vector2 pos;

        public Grass(Vector2 pos) {
            img = new Texture("base1.png");
            this.pos = pos;
        }
    }

    private Grass[] grass;

    public block(){
        grass = new Grass[3];
        grass[0] = new Grass(new Vector2(0,0));
        grass[1] = new Grass(new Vector2(336,0));
        grass[2] = new Grass(new Vector2(336*2,0));
    }

    public void render(SpriteBatch batch){
        for(int i = 0; i < grass.length; i++){
            batch.draw(grass[i].img, grass[i].pos.x, grass[i].pos.y);
        }
    }
}
