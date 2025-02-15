package main.java.com.maman14.q1;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class AssociationTable<K extends Comparable<K>, V> {

    private TreeMap<K, V> table;

    // default constructor
    public AssociationTable() {
        this.table = new TreeMap<>();
    }

    // constructor with arrays of keys and values
    public AssociationTable(K[] keys, V[] values) throws IllegalArgumentException {
        if(keys.length != values.length) {
            throw new IllegalArgumentException("Keys array and values array are not equal in size");
        }
        table = new TreeMap<>();
        for (int i = 0; i < keys.length; i++) {
            table.put(keys[i], values[i]);
        }
    }

    // add a key-value pair to the table
    public void add(K key, V value) {
        table.put(key, value);
    }

    // retrieve the value associated with a key
    public V get(K key) {
        return table.get(key);
    }

    // check if the table contains a specific key
    public boolean contains(K key) {
        return table.containsKey(key);
    }

    // remove a key-value pair from the table
    public boolean remove(K key) {
        if(this.contains(key)) {
            table.remove(key);
            return true;
        }
        return false;
    }

    // get the size of the table
    public int size() {
        return table.size();
    }

    // get an iterator for the keys in the table
    public Iterator<K> keyIterator() {
        return table.keySet().iterator();
    }
}
