package com.sapfil.ironsoul.db.core.xml;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.sapfil.ironsoul.db.api.DataBase;
import com.sapfil.ironsoul.db.api.Table;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public abstract class XmlDataBase implements DataBase {

    protected Document rDoc;
    protected final HashMap<String, com.sapfil.ironsoul.db.api.Table> tables = new HashMap<>();
    protected final String xmlFileName;

    public XmlDataBase(String xmlFileName) {
        this.xmlFileName = xmlFileName;

        // подготовка JAVA-отображения
        DocumentBuilder db = null;
        try {
            db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        // подготовка файла
        FileHandle inputFileHandler = Gdx.files.internal(xmlFileName);

        // чтение файла
        InputStream mInputStream = inputFileHandler.read();

        // парсинг файла в JAVA_ отображение
        try {
            rDoc = db.parse(mInputStream);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<String> getTableNames() {
        return tables.keySet();
    }

    @Override
    public Table getDataBaseTable(String tableName) {
        return tables.get(tableName);
    }

    @Override
    public String getName() {
        return xmlFileName;
    }

    @Override
    public void saveDataBase(){
        //not yet implemented
    }

}
