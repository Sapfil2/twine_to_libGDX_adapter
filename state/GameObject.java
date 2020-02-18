package com.sapfil.ironsoul.state;

import com.sapfil.ironsoul.gfx.GfxObject;
import com.sapfil.ironsoul.position.Position;

public class GameObject {

    public final GfxObject gfxObject;

    public final Position position;

    public GameObject(GfxObject gfxObject, Position position) {
        this.gfxObject = gfxObject;
        this.position = position;
    }
}
