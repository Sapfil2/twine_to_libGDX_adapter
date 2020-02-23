package com.sapfil.ironsoul.db.story;

import com.sapfil.ironsoul.db.core.DAO;

import org.htmlcleaner.TagNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwineCardValue extends DAO {

    private final List<String> tags = new LinkedList<>();
    private String backTag;
    private String textTag;
    private final Map<String, TwineCardKey> linkMap = new HashMap<>();
    private String textBlock;

    protected TwineCardValue(TagNode node) {
        super(node.getAttributes().get("name"));
        parseTagsBlock(node);
        parseTextBlock(node.getText().toString());
    }

    private void parseTagsBlock(TagNode node) {
        String tagsString = node.getAttributes().get("tags");
        if (tagsString == null) {
            return;
        }
        sortTags(tagsString);
    }

    /**
     * This method needs to be refactored because on O(n^2) complexity
     *
     * @param tagsString read string value from "tags"-attribute of html-node
     */
    private void sortTags(String tagsString) {
        if (tagsString.contains(" ")) {
            tags.addAll(Arrays.asList(tagsString.split(" ")));
        } else {
            tags.add(tagsString);
        }
        for (String tag : tags){
            if (tag.startsWith("b")){
                backTag = tag;
            } else if (tag.startsWith("tb")){
                textTag = tag;
            }
        }
    }

    /**
     * Text block usually content some text an at least one link to other twine card.
     * Optional information, like variables, must be parsed in this method too.
     *
     * @param textBlock text content of html-element named tw-passagedata
     */
    private void parseTextBlock(String textBlock){
        Pattern linkPattern = Pattern.compile("((\\[\\[.*->.*\\]\\])|(\\[\\[.*-&gt;.*\\]\\]))");
        Matcher matcher = linkPattern.matcher(textBlock);
        ExtractMainText(matcher);
        matcher.reset();
        ExtractLinks(matcher);
    }

    private void ExtractMainText(Matcher matcher) {
        this.textBlock = matcher.replaceAll("");
    }

    private void ExtractLinks(Matcher matcher) {
        while (matcher.find()){
            String linkDraftString = matcher.group();
            linkDraftString = linkDraftString.replace("&gt;",">");
            String linkText = linkDraftString.substring(2, linkDraftString.indexOf("->"));
            String linkTarget = linkDraftString.substring(linkDraftString.indexOf("->")+2, linkDraftString.length()-2 );
            linkMap.put(linkText, new TwineCardKey(linkTarget));
        }
    }

    public List<String> getTags() {
        return tags;
    }

    public Map<String, TwineCardKey> getLinkMap() {
        return linkMap;
    }

    public String getTextBlock() {
        return textBlock;
    }

    public String getBackTag() {
        return backTag;
    }

    public String getTextTag() {
        return textTag;
    }
}
