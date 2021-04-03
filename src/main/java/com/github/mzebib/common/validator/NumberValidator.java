package com.github.mzebib.common.validator;

import com.github.mzebib.common.util.CommonUtil;

/**
 * @author mzebib
 */
public class NumberValidator
        extends BaseValidator<String,String> {

    private static NumberValidator instance;

    private static final String REGEX = "[0-9]+";

    private NumberValidator() {
    }

    public static NumberValidator getInstance() {
        if (instance == null) {
            instance = new NumberValidator();
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
    public String validate(String value)
            throws NullPointerException, IllegalArgumentException {
        CommonUtil.checkIfNulls("Input value is null", value);

        if (value.matches(REGEX)) {
            return value;
        } else {
            throw new IllegalArgumentException("Invalid number: " +  value);
        }
    }

}
