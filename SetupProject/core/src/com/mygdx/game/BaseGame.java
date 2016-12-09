package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MemoryCard.Game.PaquetCarte;

public class BaseGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	PaquetCarte paquet;

	float deltaTime;
	float elapsedTime = 0;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("tapis_vert.jpeg");
		paquet = new PaquetCarte(24);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		update();

		batch.begin();
		batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		paquet.draw(batch);
		batch.end();
	}

	public void update(){
		deltaTime = Gdx.graphics.getDeltaTime();
		elapsedTime += deltaTime;

		paquet.update(deltaTime);
	}
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
