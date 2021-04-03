package com.github.mzebib.common.validator;

import com.github.mzebib.common.util.CommonUtil;

/**
 * @author mzebib
 */
public class DoubleValidator
        extends BaseValidator<String,Double> {

    private static DoubleValidator instance;

    private DoubleValidator() {
    }

    public static DoubleValidator getInstance() {
        if (instance == null) {
            instance = new DoubleValidator();
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
    public Double validate(String value)
            throws NullPointerException, IllegalArgumentException {
        CommonUtil.checkIfNulls("Input value is null", value);

        try {
            return Double.valueOf(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid Double type: " + value);
        }
    }

}
