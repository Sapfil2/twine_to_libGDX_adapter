package com.sapfil.ironsoul.gfx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;
import java.util.Map;

public class GfxObject {

    private static final Map<String, Texture> textureMap = new HashMap<>();

    protected final TextureRegion textureRegion;
    private final int textureRegionWidth, textureRegionHeight;

    public GfxObject(String textureFileName) {
        Texture texture = getTexture(textureFileName);
        textureRegionWidth = texture.getWidth();
        textureRegionHeight = texture.getHeight();
        textureRegion = new TextureRegion(texture, textureRegionWidth, textureRegionHeight);
    }

    public GfxObject(String textureFileName, int regionX, int regionY, int regionWidth, int regionHeight) {
        Texture texture = getTexture(textureFileName);
        textureRegionWidth = regionWidth;
        textureRegionHeight = regionHeight;
        textureRegion = new TextureRegion(texture, regionX, regionY, textureRegionWidth, textureRegionHeight);
    }

    private Texture getTexture (String textureFileName) {
        System.out.println("Trying to load texture: " + textureFileName);
        if (textureMap.get(textureFileName) == null){
            textureMap.put(textureFileName, new Texture(textureFileName));
        }
        return textureMap.get(textureFileName);
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
        sb.draw(textureRegion, x, y, 0, 0,
                textureRegion.getRegionWidth(), textureRegion.getRegionHeight(),
                1, 1, rotation, true);
    }

    public int getTextureRegionWidth() {
        return textureRegionWidth;
    }

    public int getTextureRegionHeight() {
        return textureRegionHeight;
    }
}
