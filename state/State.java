package com.sapfil.ironsoul.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sapfil.ironsoul.db.story.TwineCardKey;
import com.sapfil.ironsoul.db.story.TwineCardValue;
import com.sapfil.ironsoul.event.Event;
import com.sapfil.ironsoul.gfx.AnswerBlock;
import com.sapfil.ironsoul.gfx.GfxObject;
import com.sapfil.ironsoul.gfx.MainTextBlock;
import com.sapfil.ironsoul.gfx.TextBlock;

import java.util.Map;

/**
 * Single "frame" of the scene - analogue of single twine card
 *
 * Must content single "back"-image. Can content several "front"-gfx-objects.
 *
 * Also, usually content text block.
 */
public class State {

    final GfxObject back;
    final TextBlock textBlock;
    final Map<TextBlock, TwineCardKey> answerBlockMap;
    final TwineCardValue dao;
    final BitmapFont mainFont = new BitmapFont(Gdx.files.internal("font/arialblack2.fnt"), false);
    final BitmapFont answerFont = new BitmapFont(Gdx.files.internal("font/arialblack2.fnt"), false);

    // THis constructor must be changed. It must get String as name and then read DB
    public State(TwineCardValue dao) {
        this.dao = dao;
        back = new GfxObject(dao.getBackTag()+".png");
        textBlock = new MainTextBlock(dao.getTextTag(), dao.getTextBlock(), mainFont);

        answerBlockMap = AnswerBlock.createAnswerBlocks(dao.getTextTag(), dao.getLinkMap(), answerFont);

        mainFont.setColor(new Color(0xffff50ff));
        answerFont.setColor(new Color(0x5000afff));
    }

    public void render(SpriteBatch spriteBatch) {
        back.draw(spriteBatch,0,0,800,480);

        textBlock.draw(spriteBatch);

        for (TextBlock answerBlock : answerBlockMap.keySet()){
            answerBlock.draw(spriteBatch);
        }
    }

    public Event inputCheck(){
        if (Gdx.input.justTouched()) {
            for (Map.Entry<TextBlock, TwineCardKey> answerBlock : answerBlockMap.entrySet()) {
                if (answerBlock.getKey().isPointOnBlock(Gdx.input.getX(), 480 - Gdx.input.getY())) {
                    return new Event(answerBlock.getValue());
                }
            }
        }
        return null;
    }
}
