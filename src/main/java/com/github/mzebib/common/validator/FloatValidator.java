package com.github.mzebib.common.validator;

import com.github.mzebib.common.util.CommonUtil;

/**
 * @author mzebib
 */
public class FloatValidator
        extends BaseValidator<String,Float> {

    private static FloatValidator instance;

    private FloatValidator() {
    }

    public static FloatValidator getInstance() {
        if (instance == null) {
            instance = new FloatValidator();
        }

        return instance;
    }

    /**
     * Validates given value.
     * @param value
     * @return value if valid
     * @throws NullPointerException
     * @throws IllegalArgumentException
     */
    @Override
    public Float validate(String value)
            throws NullPointerException, IllegalArgumentException {
        CommonUtil.checkIfNulls("Input value is null", value);

        try {
            return Float.valueOf(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid Float type: " + value);
        }
    }
}