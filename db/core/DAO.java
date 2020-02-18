package com.sapfil.ironsoul.db.core;

import com.sapfil.ironsoul.db.api.Entity;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.Map;

/**
 * Отображение одной записи в БД. Вынесен функционал по сохранению карты аттрибутов,
 * получения коллекции вложенных элементов.
 *
 * Этот абстрактынй класс довольно сильно завязан на XML-реализацию. При переходе на другую
 * БД будет требоваться рефакторинг.
 */
public abstract class DAO implements Entity {

    protected static final String DEFAULT_NAME = "";

    protected final String name;
    protected final Map<String, String> attributesMap = new HashMap<>();

    protected DAO(String name){
        this.name = name;
        initNodeContentHolder();
    }

    protected DAO(Node node) {

        // имя

        this.name = node.getNodeName();


        // карта аттрибутов

        NamedNodeMap XMLattributesMap = node.getAttributes();
        for (int i = 0; i < XMLattributesMap.getLength(); i++) {
            attributesMap.put(XMLattributesMap.item(i).getNodeName(), XMLattributesMap.item(i).getNodeValue());
        }


        // вложенные элементы

        NodeList nodeList = node.getChildNodes();

        initNodeContentHolder();

        for (int j = 0; j < nodeList.getLength(); j++)
            if (nodeList.item(j).getNodeType() == Node.ELEMENT_NODE) {

                parseNodeContent(nodeList.item(j));

            }
    }

    /**
     * Парсинг вложенных элементов
     * @param innerNode один вложенный элемент
     */
    protected void parseNodeContent(Node innerNode){
        //do nothing by default
    }

    /**
     * Инициализация коллекций и других хранилищ, которые будут заполняться при парсинге
     * вложегнных элементов. Важно инициализировать их отдельно, а не через new, прописанных
     * сразу при объявлении поля. Объявление через new не сработвет, потому что сначала отработвает
     * супер-конструктор класса DAO, который уже полезет парсить вложенные элементы. И раскладывать
     * эти элементы по хранилищам класса наследника. А конструктор класса наследника еще
     * не отработал - будет падать с NPE.
     */
    protected void initNodeContentHolder(){
        //do nothing by default
    }

    @Override
    public String getName(){
        return name;
    }
}
