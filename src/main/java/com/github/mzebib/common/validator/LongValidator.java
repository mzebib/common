package com.github.mzebib.common.validator;

import com.github.mzebib.common.util.CommonUtil;

/**
 * @author mzebib
 */
public class LongValidator
        extends BaseValidator<String,Long> {

    private static LongValidator instance;

    private LongValidator() {
    }

    public static LongValidator getInstance() {
        if (instance == null) {
            instance = new LongValidator();
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
    public Long validate(String value)
            throws NullPointerException, IllegalArgumentException {
        CommonUtil.checkIfNulls("Input value is null", value);

        try {
            return Long.valueOf(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid Long type: " + value);
        }
    }

}