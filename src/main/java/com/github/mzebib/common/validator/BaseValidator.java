package com.github.mzebib.common.validator;

/**
 * @author mzebib
 */
public abstract class BaseValidator<I,O> implements Validator<I,O> {

    /**
     * Checks if given value is valid.
     * @param value
     * @return true if valid, otherwise false
     */
    @Override
    public boolean isValid(I value) {
        try {
            validate(value);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

}
