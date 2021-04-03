package com.github.mzebib.common.util;

/**
 * @author mzebib
 */
public class NVPair<V>
        implements SetNameValue<V> {

    private String name;
    private V value;

    public NVPair() {
    }

    public NVPair(String name, V value) {
        setName(name);
        setValue(value);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}