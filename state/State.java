package com.sapfil.ironsoul.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.sapfil.ironsoul.db.story.TwineCardKey;
import com.sapfil.ironsoul.db.story.TwineCardValue;
import com.sapfil.ironsoul.event.Event;
import com.sapfil.ironsoul.gfx.GfxObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Single "frame" of the scene - analogue of single twine card
 *
 * Must content single "back"-image. Can content several "front"-gfx-objects.
 *
 * Also, usually content text block.
 */
public class State {

    final GfxObject back;
    final List<GameObject> gameObjectList;
    final TwineCardValue dao;
    final BitmapFont font = new BitmapFont(Gdx.files.internal("font/arialblack.fnt"), false);

    // THis constructor must be changed. It must get String as name and then read DB
    public State(TwineCardValue dao) {
        this.dao = dao;
        back = new GfxObject(dao.getTags().get(0)+".png");
        gameObjectList = new LinkedList<>();
    }

    public void render(SpriteBatch spriteBatch){
        back.draw(spriteBatch,0,0,800,480);
        for (GameObject go : gameObjectList) {
            go.gfxObject.draw(spriteBatch,
                    go.position.x,
                    go.position.y
                    );
        }
        font.draw(spriteBatch, dao.getTextBlock(),
                10, 470, 800, Align.left, true);
    }

    public Event inputCheck(){
        if (Gdx.input.justTouched()){
            TwineCardKey stubKey = (TwineCardKey) dao.getLinkMap().values().toArray()[0];
            return new Event(stubKey);
        }
        return null;
    }
}
