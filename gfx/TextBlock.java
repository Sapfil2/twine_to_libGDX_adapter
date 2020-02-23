package com.sapfil.ironsoul.gfx;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;

public abstract class TextBlock {

    protected int x, y, width, height;
    private int borderWidth, borderHeight;
    private final GfxObject mainField;
    private final GfxObject corner;
    private final BitmapFont font;
    private final String content;

    public TextBlock(String textBlockContent, BitmapFont font, String textureName) {

        this.font = font;
        this.content = textBlockContent;

        mainField = new GfxObject(textureName, 0, 0, 8, 8);
        corner = new GfxObject(textureName,8,0,8,8);
    }

    public void draw(SpriteBatch sb) {
        this.borderWidth = mainField.getTextureRegionWidth();
        this.borderHeight = mainField.getTextureRegionHeight();

        mainField.draw(sb, x, y, width, height);
        mainField.draw(sb, x, y, width, borderHeight);
        mainField.draw(sb, x, y + height, width, -borderHeight);
        mainField.draw(sb, x, y, -borderWidth, height);
        mainField.draw(sb, x + width, y, borderWidth, height);

        corner.draw(sb, x, y, 90);
        corner.draw(sb, x, y + height, 180);
        corner.draw(sb, x + width, y + height, 270);
        corner.draw(sb, x + width, y, 0);

        font.draw(sb, content,
                x, y, width, Align.left, true);
    }

    public boolean isPointOnBlock(int x, int y) {
        if (x < this.x - borderWidth){
            return false;
        } if (x > this.x + width + borderWidth){
            return false;
        } if (y > this.y + borderHeight){
            return false;
        } if (y < this.y + height - borderHeight){
            return false;
        }
        return true;
    }
}
