package com.sapfil.ironsoul;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.sapfil.ironsoul.db.story.TwineStoryDB;
import com.sapfil.ironsoul.db.story.TwineStoryTable;
import com.sapfil.ironsoul.gfx.GfxObject;
import com.sapfil.ironsoul.state.State;
import com.sapfil.ironsoul.state.StateMachine;

public class IronSoul extends ApplicationAdapter {

	private SpriteBatch batch;
	private StateMachine stateMachine;
	private TwineStoryDB twineStoryDB;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		twineStoryDB  = new TwineStoryDB("libgdxTest5.html");
		stateMachine = new StateMachine(
				(TwineStoryTable) twineStoryDB.getDataBaseTable("tw-story"));
	}

	@Override
	public void render () {

		stateMachine.update(Gdx.graphics.getDeltaTime());

		Gdx.gl.glClearColor(0, 0, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		stateMachine.render(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
