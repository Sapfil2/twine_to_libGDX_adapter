package com.sapfil.ironsoul.db.story;

import com.sapfil.ironsoul.db.core.html.HtmlDataBase;

import org.htmlcleaner.TagNode;

public class TwineStoryDB extends HtmlDataBase {

    public TwineStoryDB(String xmlFileName) {
        super(xmlFileName);

        TagNode twStoryNode = root.getElementsByName("body", false)[0]
                .getElementsByName("tw-storydata", false)[0];

        tables.put("tw-story", new TwineStoryTable(twStoryNode));
    }
}
