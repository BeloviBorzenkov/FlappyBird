package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {

    //подкласс для создания бг картинки
    class Picture{
        private Texture bg; //тут храним картинку
        private Vector2 pos; //тут храним позицию

        public Picture(Vector2 pos) {
            bg = new Texture("bg.jpg");
            this.pos = pos;
        }
    }


    private  int speed;
    private Picture[] stack;
    //чтобы бг плавно двигался нужно создать 2 картнки которые будут идти друг за другом
    //для этого создадаем массив в который кладём картинки с заданными позициями и задаем скорость
    public Background(){
        stack = new Picture[2];
        stack[0] = new Picture(new Vector2(0,0) );
        stack[1] = new Picture(new Vector2(800,0) );
        speed = 2;
    }



    //метод отрисовки - отрисовываем 2 наши картинки
    public void render(SpriteBatch batch){
        for(int i = 0; i < stack.length; i++){
            batch.draw(stack[i].bg, stack[i].pos.x, stack[i].pos.y);
        }


    }
    //метод обновления бг - тут просто задаем скорость картинкам
    // и условие при котором они возвращаются на начальную позицию когда заходят за границы экрана
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
