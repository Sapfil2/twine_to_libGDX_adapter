package com.sapfil.ironsoul.gfx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GfxObject {

    protected final TextureRegion textureRegion;
    protected final Texture texture;

    public GfxObject(String textureFileName) {
        texture = new Texture(textureFileName);
        textureRegion = new TextureRegion(texture, texture.getWidth(), texture.getHeight());
    }

    public void draw(SpriteBatch sb){
        sb.draw(textureRegion, 0, 0);
    }

    public void draw(SpriteBatch sb, float x, float y){
        sb.draw(textureRegion, x, y);
    }

    public void draw(SpriteBatch sb, float x, float y,  float width, float height){
        sb.draw(textureRegion, x, y, width, height);
    }

    public void draw(SpriteBatch sb, float x, float y,  float rotation){
        sb.draw(textureRegion, x, y, 0, 0, texture.getWidth(), texture.getHeight(),
                1, 1, rotation, true);
    }

    public void dispose(){
        texture.dispose();
    }
}
