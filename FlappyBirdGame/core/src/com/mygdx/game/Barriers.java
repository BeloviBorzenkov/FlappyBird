package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;
import java.util.Random;

import static com.mygdx.game.MyGdxGame.width;

/*
Класс препятствий состоит из следующих объектов: препятствия(верхняя и нижняя труба), пустое пространство между трубами,
линия для начисления очков.

 */
public class Barriers {

    //подкласс Pair - описывает пару труб (нижную и верхнуюю)

    class Pair{
        Vector2 pos; //позиция
        float speed; // скоростью
        int offset; //расстояние между трубами
        Rectangle space; //пустое расстояние между трубами
        Rectangle pointLine; //линия для счета очков

        //конструктор - задаем начальную позицию, скорость, расстояние между трубами
        public Pair(Vector2 position){
            pos = position;
            speed = 3.3f;
            offset = MathUtils.random(-100, 100);;
            space = new com.badlogic.gdx.math.Rectangle(pos.x,pos.y - offset + 320,52,betwenDistance);
            pointLine = new com.badlogic.gdx.math.Rectangle(pos.x,pos.y - offset + 320,3.25f ,betwenDistance);
        }


        public void Update(){
            pos.x -= speed;
            if(pos.x < -50){
                pos.x = width;
                offset = MathUtils.random(-100, 100);
            }
            space.x = pos.x;
            space.y= pos.y - offset + 320;

            pointLine.x = pos.x;
            pointLine.y= pos.y - offset + 320;
        }
    }
    static Pair[] bar; //массив из объектов типа Pair - на экране помещается 4 таких объекта
    Texture down;
    Texture up;
    int betwenDistance; //фиксированное расстояние между парами труб

    //констркутор класса - здесь создаем массив, задаем текстуры
    public Barriers(){
        down = new Texture("pipe-down.png");
        up = new Texture("pipe-up.png");
        bar = new Pair[4];
        betwenDistance = 110;
        int StartPos = 400;

        //в цикле создаем 4 объекта препятствий с заданной позицией
        for (int i = 0; i < bar.length; i++) {
            bar[i] = new Pair(new Vector2(StartPos,-50));
            StartPos += 220;
        }
    }

    //метод render отрисовывает верхнуюю трубу и нижнюю
    public void render(SpriteBatch batch){
        for (int i = 0; i < bar.length; i++) {
            batch.draw(up,bar[i].pos.x,bar[i].pos.y - bar[i].offset); //нижняя труба
            batch.draw(down,bar[i].pos.x,bar[i].pos.y + betwenDistance + down.getHeight() - bar[i].offset ); //верхняя труба
        }

    }
    //обновляем каждую пару
    public void update(){
        for (int i = 0; i < bar.length; i++) {
            bar[i].Update();
            
        }
    }

    //пересоздаем препятствия
    public void recreate(){
        int StartPos = 600;
        for (int i = 0; i < bar.length; i++) {
            bar[i] = new Pair(new Vector2(StartPos,-50));
            StartPos += 220;

        }
    }

}
