package com.sapfil.ironsoul.gfx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GfxObject {

    private final Texture texture;
    private final int width, height, originX, originY;

    public GfxObject(String textureFileName) {
        this.texture = new Texture(textureFileName);
        width = texture.getWidth();
        height = texture.getHeight();
        originX = width/2;
        originY = height/2;
    }

    public void draw(SpriteBatch sb){
        sb.draw(texture, 0, 0);
    }

    public void draw(SpriteBatch sb, float x, float y){
        sb.draw(texture, x, y);
    }

    public void draw(SpriteBatch sb, float x, float y,  float width, float height){
        sb.draw(texture, x, y, width, height);
    }

    public void dispose(){
        texture.dispose();
    }
}
