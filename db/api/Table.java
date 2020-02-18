package com.sapfil.ironsoul.db.api;

import com.sapfil.ironsoul.db.core.DAO;

import java.util.Collection;

/**
 * Отображение одной таблицы в БД.
 *
 * Описание - см второй пункт в JavaDoc {@link DataBase}
 */
public interface Table<K extends Key, E extends DAO> extends Entity {

    /**
     * Все записи в таблице
     * @return все записи таблицы
     */
    Collection<E> getAllEntries();

    /**
     * Получить запись по значениям аттрибутов. Не предполгается такого функционала, при котором
     * по списку аттрибутов может быть получено более одного объекта.
     *
     * @param key набор аттрибутов.
     * @return записи с совпадающими аттрибутами
     * @throws IllegalArgumentException если передан неверный набор аргументов
     * @throws MoreThanOneEntryFoundException если найдено более одного элемента
     */
    E getEntry(K key) throws IllegalArgumentException, MoreThanOneEntryFoundException;

    /**
     * Удалить запись из таблицы
     * @param entry запись на удаление
     */
    void deleteEntry(E entry);

    /**
     * добавить запись в таблицу
     * @param entry запись на добавление
     */
    void addEntry(E entry);

}
