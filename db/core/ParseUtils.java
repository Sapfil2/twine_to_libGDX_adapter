package com.sapfil.ironsoul.db.core;

import org.w3c.dom.Node;

public class ParseUtils {

    public static float parseFloatWithDefault(String text, float defaultValue){
        try{
            return Float.parseFloat(text);
        } catch (Exception ex){
            //do nothing
        }
        return defaultValue;
    }

    public static int parseIntegerWithDefault(String text, int defaultValue){
        try{
            return Integer.parseInt(text);
        } catch (Exception ex){
            //do nothing
        }
        return defaultValue;
    }

    public static float parseFloatNodeWithDefault(Node textNode, float defaultValue){
        try{
            return Float.parseFloat(textNode.getNodeValue());
        } catch (Exception ex){
            //do nothing
        }
        return defaultValue;
    }

    public static int parseIntegerNodeWithDefault(Node texNode, int defaultValue){
        try{
            return Integer.parseInt(texNode.getNodeValue());
        } catch (Exception ex){
            //do nothing
        }
        return defaultValue;
    }
}
