package com.sapfil.ironsoul.db.story.varaible;

public abstract class Action<V extends Variable>  {

    abstract V apply(V input);
}
