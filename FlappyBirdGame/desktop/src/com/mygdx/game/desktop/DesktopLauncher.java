package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

import static com.mygdx.game.MyGdxGame.height;
import static com.mygdx.game.MyGdxGame.width;


/*
Класс стартер для платформы, в нашем случае - десктоп

 */
public class DesktopLauncher {
	//единственный метод нужен для инициализации класса игры
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = width;
		config.height = height;
		config.title="Flappy Bird";

		new LwjglApplication(new MyGdxGame(), config); //класс игры и конфиг
	}
}
