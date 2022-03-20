package com.mygdx.game;

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

	//public int width = 800;
	//public int height = 600;
	//public final int count = 4;
	//Barrier[] pipe = new Barrier[count];
	Random rand = new Random();

	Barrier pipe1 = new Barrier(800, rand.nextInt(100), 2f);
	Barrier pipe2 = new Barrier(800+300,rand.nextInt(100),2f);
	Barrier pipe3 = new Barrier(800+600,rand.nextInt(100),2f);




	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new Background();
		footer = new block();
		Barrier.setBarrierTexture(new Texture("barrier.png"));

	}

	@Override
	public void render () {
		update();
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();


		bg.render(batch);

		pipe1.render(batch);
		pipe2.render(batch);
		pipe3.render(batch);

		footer.render(batch);
		batch.end();
	}


	public void update(){
		bg.update();
	    pipe1.update();
		pipe2.update();
		pipe3.update();

	}
	
	@Override
	public void dispose () {
		batch.dispose();


	}
}
