package com.sapfil.ironsoul.gfx;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextBlock {

    private static final String defaultTextureFilename = "defaultTextBlockBack.png";
    private static final String defaultTextureCornerFilename = "defaultTextBlockCorner.png";

    private final int x, y, width, height;
    private final GfxObject mainField;
    private final GfxObject corner;

    public TextBlock(String id) {

        mainField = new GfxObject(defaultTextureFilename);
        corner = new GfxObject(defaultTextureCornerFilename);

        if (id == null){
            x = 10; y = 470; width = 780; height = -100;
            return;
        }
        switch (id) {
            default:
            case "tb1" : {x = 10; y = 470; width = 780; height = -100; break;}
            case "tb2" : {x = 410; y = 470; width = 380; height = -240; break;}
        }
    }

    public void draw(SpriteBatch sb) {
        int borderWidth = mainField.texture.getWidth();
        int borderHeight = mainField.texture.getHeight();

        mainField.draw(sb, x, y, width, height);
        mainField.draw(sb, x, y, width, borderHeight);
        mainField.draw(sb, x, y + height, width, -borderHeight);
        mainField.draw(sb, x, y, -borderWidth, height);
        mainField.draw(sb, x + width, y, borderWidth, height);

        corner.draw(sb, x, y, 90);
        corner.draw(sb, x, y + height, 180);
        corner.draw(sb, x + width, y + height, 270);
        corner.draw(sb, x + width, y, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
