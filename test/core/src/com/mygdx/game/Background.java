package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {

    class Picture{
        private Texture bg;
        private Vector2 pos;

        public Picture(Vector2 pos) {
            bg = new Texture("bg.jpg");
            this.pos = pos;
        }
    }

    private  int speed;
    private Picture[] stack;

    public Background(){
        stack = new Picture[2];
        stack[0] = new Picture(new Vector2(0,0) );
        stack[1] = new Picture(new Vector2(800,0) );
         speed = 2;
    }




    public void render(SpriteBatch batch){
        for(int i = 0; i < stack.length; i++){
            batch.draw(stack[i].bg, stack[i].pos.x, stack[i].pos.y  );
        }

    }

    public void update(){

        for (int i = 0; i < stack.length ; i++) {
            stack[i].pos.x -= speed;
        }

        if(stack[0].pos.x < -800 ){
            stack[0].pos.x = 0;
            stack[1].pos.x = 800;
        }
    }

}
