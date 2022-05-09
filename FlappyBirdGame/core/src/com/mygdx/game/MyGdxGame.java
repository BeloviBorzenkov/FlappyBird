package com.mygdx.game;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background bg;
	block footer;
	Barriers pipes;
	Bird bird;
	Random rand = new Random();
	boolean gameOver;
	Texture restart;

	//метод создания тут создаем все объекты на экране
	@Override
	public void create () {
		batch = new SpriteBatch();

		bg = new Background();
		bird = new Bird();
		pipes = new Barriers();
		footer = new block();

		gameOver = false;
		restart = new Texture("gameover.png");

	}



	//вообще это метод для отрисовки, но в нем обычно доп логику делают, а отрисовка в draw(а где доп логика?)
	@Override
	public void render () {
		draw();

		if(!gameOver){
			update();
		}else{}

		if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && gameOver){
			recreate();
		}

		if(Gdx.input.isKeyPressed(Input.Keys.ALT_LEFT) | gameOver){
			//вот бы придумать как сделать паузу, нужно остановить метод update, тогда,
			//напрмер при нажатии на другую кнопку, запускать update заного
		}
	}

	//обновление отрисованных объектов, если метод не вызывать картинка застынет
	public void update(){

			bg.update();
			bird.update();
			pipes.update();

			for (int i = 0; i < Barriers.bar.length; i++) {
				if(bird.pos.x > Barriers.bar[i].pos.x && bird.pos.x < Barriers.bar[i].pos.x+52){
					if(!Barriers.bar[i].space.contains(bird.pos)){
						gameOver = true;
					}
				}
				if(bird.pos.y < 0 || bird.pos.y > 600){
					gameOver = true;
				}
			}





	}
		//отрисовывает объекты
		public void draw(){
			ScreenUtils.clear(1, 1, 1, 1);
			batch.begin();

			bg.render(batch);
			pipes.render(batch);
			bird.render(batch);
			if(gameOver){
				batch.draw(restart,300,300);

			}


			footer.render(batch);

			batch.end();
		}

		//кидает объекты на стартовые позиции
		public void recreate(){
			bird.recreate();
			pipes.recreate();
			gameOver = false;
		}

}