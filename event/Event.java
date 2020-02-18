package com.sapfil.ironsoul.event;

import com.sapfil.ironsoul.db.story.TwineCardKey;
import com.sapfil.ironsoul.db.story.varaible.Action;
import com.sapfil.ironsoul.db.story.varaible.Variable;

import java.util.HashMap;

/**
 * Signal to go to the next state
 */
public class Event {

    private final TwineCardKey nextTwineCardKey;

    private HashMap<Variable, Action> specianPropertyMap;

    /**
     * Simple forward pass
     * @param nextTwineCardKey analogue of twine card name
     */
    public Event(TwineCardKey nextTwineCardKey) {
        this.nextTwineCardKey = nextTwineCardKey;
    }

    /**
     * Forward pass with special property. For example, carma changes, or inventory change.
     *
     * @param nextTwineCardKey analogue of twine card name
     * @param specianPropertyMap variable and some action description with this variable
     */
    public Event(TwineCardKey nextTwineCardKey, HashMap<Variable, Action> specianPropertyMap) {
        this.nextTwineCardKey = nextTwineCardKey;
        this.specianPropertyMap = specianPropertyMap;
    }

    public TwineCardKey getNextTwineCardKey() {
        return nextTwineCardKey;
    }

    public HashMap<Variable, Action> getSpecianPropertyMap() {
        return specianPropertyMap;
    }
}
