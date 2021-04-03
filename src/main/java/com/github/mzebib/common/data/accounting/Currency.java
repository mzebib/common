package com.github.mzebib.common.data.accounting;

/**
 * @author mzebib
 */
public enum Currency {
    USD("$", "United States dollar"),

    ;

    private final String value;
    private final String description;

    Currency(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return value;
    }
}