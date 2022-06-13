package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;

/*
Классы описывает птицу
 */
public class Bird {
    Texture img;
    Vector2 pos;
    float vy;
    float falling;

    //конструктор - устанавливаем текстуру, начальную позицию, сокрость
    public Bird(){
        img = new Texture("bluebird-midflap.png");
        pos = new Vector2(100,380);
        vy = 0;
        falling = -0.5f;
    }

    //метод для отрисовки - отрисовываем картинку в заданной позиции
    public void render(SpriteBatch batch){
        batch.draw(img,pos.x,pos.y);
    }

    //метод обновления логики - при нажатии на пробел увелчиваем значение объекта по игрику
    //вычитаем из той же позиции значение falling(с какой скоростью птица падает)
    //записываем новое значение п позицию птицы
    public void update(){

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            vy = 4;
            //flapSound.play(0.1f);
        }
        vy += falling;
        pos.y += vy;

    }
    //метод для "пересоздания" птицы - возвращаем объект на стартовую позицию
    public void recreate(){
        pos = new Vector2(100,380);
        vy = 0;
    }


}
