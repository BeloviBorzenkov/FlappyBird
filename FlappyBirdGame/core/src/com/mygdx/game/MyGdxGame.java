package com.mygdx.game;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
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
	Barrier pipe;
	Bird bird;
	Random rand = new Random();

	//метод создания тут создаем все объекты на экране
	@Override
	public void create () {
		batch = new SpriteBatch();

		bg = new Background();
		bird = new Bird();
		pipe = new Barrier();
		pipe.create();
		footer = new block();

		Barrier.setBarrierTexture2(new Texture("pipe-down.png"));
		Barrier.setBarrierTexture1(new Texture("pipe-up.png"));

	}

	//метод отрисовки тут стартуем метод обновления отрисованных объектов и их отрисовку
	@Override
	public void render () {
		update();
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();

		bg.render(batch);
		bird.render(batch);
		pipe.render(batch);
		footer.render(batch);

		batch.end();
	}

	//обновление отрисованных объектов
	public void update(){
		bg.update();
		bird.update();
		pipe.update();

	}

	//сбросить
	@Override
	public void dispose () {
		batch.dispose();


	}
}