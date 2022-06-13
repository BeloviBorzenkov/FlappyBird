package com.mygdx.game;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {

	public final static int width = 800;
	public final static int height = 600;
	int score;
	int maxScore;
	BitmapFont font;
	SpriteBatch batch;
	Background bg;
	block footer;
	Barriers pipes;
	Bird bird;
	boolean gameOver;
	Texture restart;
	Music music;
	Sound flapSound;
	Sound failSound;
	Sound pointSound;
	Sound failMusic;




	//метод создания тут создаем все объекты на экране
	@Override
	public void create () {
		batch = new SpriteBatch();

		bg = new Background();
		bird = new Bird();
		pipes = new Barriers();
		footer = new block();
		maxScore = 0;

		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true); //бесконечное воспроизведенеие
		music.setVolume(0.09f); //громкость
		music.play(); // запустить музыку

		failSound = Gdx.audio.newSound(Gdx.files.internal("audio_hit.wav"));
		flapSound = Gdx.audio.newSound(Gdx.files.internal("audio_wing.wav"));
		pointSound = Gdx.audio.newSound(Gdx.files.internal("audio_point.wav"));
		failMusic = Gdx.audio.newSound(Gdx.files.internal("music_fail.mp3"));



		font = new BitmapFont();
		font.setColor(Color.BLACK);

		font.getData().setScale(2f, 2f);

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

		if(Gdx.input.isKeyPressed(Input.Keys.ENTER) && gameOver){
			recreate();
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
					failSound.play(0.1f);
					failMusic.play(0.1f);
					music.dispose();
				}
			}

			if(bird.pos.y < 0 || bird.pos.y > 600){
				gameOver = true;
				failSound.play(0.1f);
				failMusic.play(0.1f);
				music.dispose();
			}


			if(Barriers.bar[i].pointLine.contains(bird.pos) && !gameOver){
				score++;
				pointSound.play(0.09f);
				if (score > maxScore){
					maxScore = score;

				}
			}
		}


	}

	//отрисовывает объекты
	public void draw(){
		batch.begin();

		bg.render(batch);
		pipes.render(batch);
		bird.render(batch);

		if(gameOver){
			batch.draw(restart,300,300);
		}

		footer.render(batch);

		font.draw(batch, score/2 + "", 400, 550);
		font.draw(batch, "record: " + maxScore/2, 0,550);

		batch.end();
	}

	//кидает объекты на стартовые позиции
	public void recreate(){
		bird.recreate();
		pipes.recreate();
		gameOver = false;
		score = 0;
		music.play();

	}

}
