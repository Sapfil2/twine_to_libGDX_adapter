package com.sapfil.ironsoul.db.story;

import com.sapfil.ironsoul.db.api.Key;

import java.util.Objects;

public class TwineCardKey implements Key {

    private final String cardName;

    public TwineCardKey(String cardName) {
        this.cardName = cardName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TwineCardKey)) return false;
        TwineCardKey that = (TwineCardKey) o;
        return cardName.equals(that.cardName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardName);
    }
}
