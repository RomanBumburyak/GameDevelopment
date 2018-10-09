package com.mythird.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyBirdGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;

	Texture[] birds;
	int flapState = 0;
	float birdY = Gdx.graphics.getHeight() / 2 - birds[0].getHeight() / 2;
	float velocity = 0;

	int gameState = 0;




	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("blueBack.jpg");
		birds = new Texture[2];
		birds[0] = new Texture("birdUpFlap.png");
		birds[1] = new Texture("birdDownFlap.png");


	}


	@Override
	public void render () {

		if (Gdx.input.justTouched()){
			Gdx.app.log("Touched", "yep");
			gameState = 1;

		}

		if (gameState != 0) {

			velocity++;
			birdY -= velocity;


		} else { //only doing this check if the game state is zero.

			  if (Gdx.input.justTouched()) {
				  gameState = 1;
			  }
		}

		if (flapState == 0) {
			flapState = 1;
		} else {
			flapState = 0;
		}

		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(birds[flapState], Gdx.graphics.getWidth() / 2 - birds[flapState].getWidth() / 2, birdY);
		batch.end();

	}

}


