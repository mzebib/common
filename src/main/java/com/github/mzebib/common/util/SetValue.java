package com.github.mzebib.common.util;

/**
 * @author mzebib
 */
public interface SetValue<V>
    extends GetValue<V> {

    void setValue(V value);

}