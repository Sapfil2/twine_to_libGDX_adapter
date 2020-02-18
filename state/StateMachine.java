package com.sapfil.ironsoul.state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sapfil.ironsoul.db.story.TwineCardKey;
import com.sapfil.ironsoul.db.story.TwineStoryTable;
import com.sapfil.ironsoul.event.Event;

public class StateMachine  {

    private State currentState;
    private TwineStoryTable table;

    public StateMachine(TwineStoryTable table) {
        this.table = table;
        currentState = new State(table.getEntry(new TwineCardKey("1-1")));
    }

    public void render(SpriteBatch spriteBatch){
        currentState.render(spriteBatch);
    }

    public void update(float dt){
        Event event = currentState.inputCheck();
        if (event == null){
            return;
        }
        currentState = new State(table.getEntry(event.getNextTwineCardKey()));
    }
}
