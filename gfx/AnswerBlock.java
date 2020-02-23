package com.sapfil.ironsoul.gfx;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sapfil.ironsoul.db.story.TwineCardKey;

import java.util.HashMap;
import java.util.Map;

public class AnswerBlock extends TextBlock {

    private static final String defaultTextureFilename = "defaultAnswerBlock.png";

    private AnswerBlock(String textContent,
                        BitmapFont font, int x, int y, int width, int height) {
        super(textContent, font, defaultTextureFilename);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    private static class HiddenAnswerBlock extends AnswerBlock {
        private HiddenAnswerBlock() {
           super("", null, 0, 0, 0, 0);
        }

        @Override
        public void draw(SpriteBatch sb){
            // do nothing;
        }

        @Override
        public boolean isPointOnBlock(int x, int y) {
            return true;
        }
    }

    public static Map<TextBlock, TwineCardKey> createAnswerBlocks(
            String id, Map<String, TwineCardKey> answerMap, BitmapFont font) {

        Map<TextBlock, TwineCardKey> returnValue = new HashMap<>();

        if (answerMap.isEmpty()) {
            return returnValue;
        }
        if (answerMap.size() == 1) {
            if (answerMap.containsKey("null") || answerMap.containsKey("")) {
                returnValue.put(
                        new HiddenAnswerBlock(),
                        (TwineCardKey) answerMap.values().toArray()[0]
                );
                return returnValue;
            }
        }

        int x, y, width, height;

        if (id == null) {
            x = 10;
            y = 412;
            width = 780;
            height = -15;
        } else {
            switch (id) {
                default:
                case "tb1": {
                    x = 10;
                    y = 350;
                    width = 780;
                    height = -15;
                    break;
                }
                case "tb2": {
                    x = 410;
                    y = 210;
                    width = 380;
                    height = -38; // 15 + 8 + 15 pixels. 15 - string height, 8 between strings
                    break;
                }
            }
        }

        for (Map.Entry<String, TwineCardKey> entry : answerMap.entrySet()) {
            returnValue.put(
                    new AnswerBlock(entry.getKey(), font, x, y, width, height),
                    entry.getValue());
            y += height;
            y -= 20;
        }

        return returnValue;
    }
}
