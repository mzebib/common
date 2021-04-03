package com.github.mzebib.common.validator;

import com.github.mzebib.common.util.CommonUtil;

/**
 * @author mzebib
 */
public class BooleanValidator
        extends BaseValidator<String,Boolean> {

    private static BooleanValidator instance;

    private BooleanValidator() {
    }

    public static BooleanValidator getInstance() {
        if (instance == null) {
            instance = new BooleanValidator();
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
    public Boolean validate(String value)
            throws NullPointerException, IllegalArgumentException {
        CommonUtil.checkIfNulls("Input value is null", value);
        value = value.toLowerCase();

        if (value.equals("true")) {
            return true;
        } else if (value.equals("false")) {
            return false;
        }

        throw new IllegalArgumentException("Invalid boolean value: " + value);
    }

}
