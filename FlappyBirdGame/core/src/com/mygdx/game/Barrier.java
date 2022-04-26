package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.awt.*;
import java.util.Iterator;

public class Barrier {
    private int x;
    private int y;
    private float speed;
    private static Texture BarrierTexture1;
    private static Texture BarrierTexture2;
    private Array<Rectangle> barriersDown;
    private Array<Rectangle> barriersUp;
    private long LastBarTime;
    public static void setBarrierTexture1(Texture barrierTexture1) {
        BarrierTexture1 = barrierTexture1;
    }
    public static void setBarrierTexture2(Texture barrierTexture2) {
        BarrierTexture2 = barrierTexture2;
    }
    private int space;

    //метод создания барьера
    //объект класса Rectangle хранит в себе 4 эллемента - позицию x,y и размеры w,h
    public void CreateBarrier(){
        space = 130;
        Rectangle barrierd = new Rectangle();
        barrierd.x = 800;
        barrierd.y = MathUtils.random(-100, 100);;
        barrierd.width = 52;
        barrierd.height = 320;
        barriersDown.add(barrierd);

        Rectangle barrieru = new Rectangle();
        barrieru.x = 800;
        barrieru.y = barrierd.y + space + 320;
        barrieru.width = 52;
        barrieru.height = 320;
        barriersUp.add(barrieru);

        LastBarTime = TimeUtils.nanoTime();
    }

    //метод создания барьеров
    //создаем массив из ректанглов и вызываем метод создания барьера - создаем первый барьер
    public void create(){
        barriersDown = new Array<Rectangle>();
        barriersUp = new Array<Rectangle>();
        CreateBarrier();
    }
    //метод отрисовки
    //создает барьер спустя определённое время(лучше сделать отдельную переменную) после появления пролого барьера
    public void render(SpriteBatch batch){
        speed = 3.5f;
        if(TimeUtils.nanoTime() - LastBarTime > 1300000000l) CreateBarrier();
        //отрисовываем barrier - наш барьер
        for(Rectangle barrier: barriersDown) {
            batch.draw(BarrierTexture1, barrier.x, barrier.y);
        }
        for(Rectangle barrier: barriersUp) {
            batch.draw(BarrierTexture2, barrier.x, barrier.y);
        }
        //hasnext булевый выдает труе или фалс если есть следующий элемент
        //next выдает следующий элемент
        //remove убирает элемент находящийся сейчас под итератором



    }
    //тут задаем скорость барьеров
    public void update(){
        for (Iterator<Rectangle> iter = barriersDown.iterator(); iter.hasNext(); ) {
            Rectangle move = iter.next();
            move.x -= speed;
            if(move.x + 104 < 0) iter.remove();
        }
        for (Iterator<Rectangle> iter = barriersUp.iterator(); iter.hasNext(); ) {
            Rectangle move = iter.next();
            move.x -= speed;
            if(move.x + 104 < 0) iter.remove();
        }
    }


}