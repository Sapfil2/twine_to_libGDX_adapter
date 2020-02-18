package com.sapfil.ironsoul.db.story;

import com.sapfil.ironsoul.db.core.html.HtmlTable;

import org.htmlcleaner.TagNode;

public class TwineStoryTable extends HtmlTable<TwineCardKey, TwineCardValue> {

    protected TwineStoryTable(TagNode xmlNode) {
        super(xmlNode);
    }

    @Override
    protected void parseNodeContent(TagNode tagNode) {

        if (!tagNode.getName().equals("tw-passagedata")) {
            return;
        }

        String name = tagNode.getAttributes().get("name");

        TwineCardKey key = new TwineCardKey(name);
        TwineCardValue value = new TwineCardValue(tagNode);

        index.put(key, value);

    }
}
