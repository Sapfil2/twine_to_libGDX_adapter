package com.sapfil.ironsoul.gfx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sapfil.ironsoul.state.GameObject;

import java.util.HashMap;
import java.util.Map;

public class GfxObject {

    private static final Map<String, Texture> textureMap = new HashMap<>();

    protected final TextureRegion textureRegion;
    private final int textureRegionWidth, textureRegionHeight;

    private GfxObject(String textureFileName) {
        Texture texture = getTexture(textureFileName);
        textureRegionWidth = texture.getWidth();
        textureRegionHeight = texture.getHeight();
        textureRegion = new TextureRegion(texture, textureRegionWidth, textureRegionHeight);
    }

    private GfxObject(String textureFileName, int regionX, int regionY, int regionWidth, int regionHeight) {
        Texture texture = getTexture(textureFileName);
        textureRegionWidth = regionWidth;
        textureRegionHeight = regionHeight;
        textureRegion = new TextureRegion(texture, regionX, regionY, textureRegionWidth, textureRegionHeight);
    }

    private Texture getTexture(String textureFileName) {
        if (textureMap.get(textureFileName) == null) {
            textureMap.put(textureFileName, new Texture(textureFileName));
        }
        return textureMap.get(textureFileName);
    }

    public void draw(SpriteBatch sb, float x, float y, float width, float height) {
        sb.draw(textureRegion, x, y, width, height);
    }

    public void draw(SpriteBatch sb, float x, float y, float rotation) {
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

    public static GfxObject getGfxObject(String textureFileName,
                                         int regionX, int regionY, int regionWidth, int regionHeight) {
        if (textureFileName == null) {
            return new NullObject();
        } else return new GfxObject(textureFileName, regionX, regionY, regionWidth, regionHeight);

    }

    public static GfxObject getGfxObject(String textureFileName) {
        if (textureFileName == null || textureFileName.equals("null.png")) {
            return new NullObject();
        } else return new GfxObject(textureFileName);
    }


    private static class NullObject extends GfxObject {

        public NullObject() {
            super("emptyTexture.png");
        }

        @Override
        public void draw(SpriteBatch sb, float x, float y, float width, float height) {
            // do nothing;
        }

        @Override
        public void draw(SpriteBatch sb, float x, float y, float rotation) {
            // do nothing;
        }
    }
}
