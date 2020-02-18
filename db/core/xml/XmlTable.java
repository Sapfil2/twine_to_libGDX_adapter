package com.sapfil.ironsoul.db.core.xml;

import com.sapfil.ironsoul.db.api.Key;
import com.sapfil.ironsoul.db.api.Table;
import com.sapfil.ironsoul.db.core.DAO;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Отображение таблицы из XML-представления
 * @param <K> ключ
 * @param <D> DAO-значение
 */
public abstract class XmlTable<K extends Key, D extends DAO> implements Table<K, D> {

    protected final HashMap<K, D> index = new HashMap<>();
    protected final Map<String, String> attributesMap = new HashMap<>();
    protected final String name;

    protected XmlTable(Node xmlNode) {

        // имя
        name = xmlNode.getNodeName();

        // аттрибуты
        NamedNodeMap XMLattributesMap = xmlNode.getAttributes();
        for (int i = 0; i < XMLattributesMap.getLength(); i++){
            attributesMap.put(XMLattributesMap.item(i).getNodeName(), XMLattributesMap.item(i).getNodeValue());
        }

        // вложенные элементы
        NodeList nodeList = xmlNode.getChildNodes();

        for (int nodeNumberInXML = 0; nodeNumberInXML < nodeList.getLength(); nodeNumberInXML++)
            if (nodeList.item(nodeNumberInXML).getNodeType() == Node.ELEMENT_NODE) {
                parseNodeContent(nodeList, nodeNumberInXML);
            }
    }

    protected abstract void parseNodeContent(NodeList nodesList, int nodeNumberInXml);

    @Override
    public Collection<D> getAllEntries() {

        return index.values();

    }

    @Override
    public D getEntry(K key){

        return index.get(key);

    }

    @Override
    public void deleteEntry(D entry) {
        //TODO
    }

    @Override
    public void addEntry(D entry) {
        //TODO
    }

    @Override
    public String getName() {
        return name;
    }


}
