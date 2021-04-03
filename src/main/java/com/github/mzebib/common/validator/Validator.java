package com.github.mzebib.common.validator;

import java.io.Serializable;

/**
 * @author mzebib
 */
public interface Validator<I,O>
        extends Serializable {

    /**
     * Validates given value.
     * @param value
     * @return value if valid
     * @throws NullPointerException
     * @throws IllegalArgumentException
     */
    O validate(I value) throws NullPointerException, IllegalArgumentException;

    /**
     * Checks if given value is valid.
     * @param value
     * @return true if valid, otherwise false
     */
    boolean isValid(I value);

}