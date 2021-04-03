package com.github.mzebib.common.util;

/**
 * @author mzebib
 */
public class QueryMatch<V>
    implements SetNameValue<V> {

    private String name;
    private V value;
    private Constants.RelationalOperator operator;

    public QueryMatch() {
    }

    public QueryMatch(String name, V value, Constants.RelationalOperator operator) {
        setName(name);
        setValue(value);
        setOperator(operator);
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
    public V getValue()
    {
        return value;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }

    public Constants.RelationalOperator getOperator() {
        return operator;
    }

    public void setOperator(Constants.RelationalOperator operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return getName() + getOperator().getSymbol() + getValue();
    }

}