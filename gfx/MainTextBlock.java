package com.sapfil.ironsoul.gfx;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;

public class MainTextBlock extends TextBlock {

    private static final String defaultTextureFilename = "defaultTextBlock.png";

    public MainTextBlock(String textBlockFormId, String textBlockContent, BitmapFont font) {
        super(textBlockContent, font, defaultTextureFilename);

        if (textBlockFormId == null){
            x = 10; y = 470; width = 780; height = -38;
            return;
        }
        switch (textBlockFormId) {
            default:
            case "tb1" : {x = 10; y = 470; width = 780; height = -100; break;}
            case "tb2" : {x = 410; y = 470; width = 380; height = -240; break;}
        }
    }
}
