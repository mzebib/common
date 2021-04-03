package com.github.mzebib.common.validator;

import com.github.mzebib.common.util.CommonUtil;

/**
 * @author mzebib
 */
public class IntegerValidator
        extends BaseValidator<String,Integer> {

    private static IntegerValidator instance;

    private IntegerValidator() {
    }

    public static IntegerValidator getInstance() {
        if (instance == null) {
            instance = new IntegerValidator();
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
    public Integer validate(String value)
            throws NullPointerException, IllegalArgumentException {
        CommonUtil.checkIfNulls("Input value is null", value);

        try {
            return Integer.valueOf(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid Integer type: " + value);
        }
    }

}