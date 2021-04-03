package com.github.mzebib.common.validator;

import com.github.mzebib.common.util.CommonUtil;

/**
 * @author mzebib
 */
public class ZipCodeValidator
        extends BaseValidator<String,String> {

    private static ZipCodeValidator instance;

    private static final String REGEX = "^[0-9]{5}(?:-[0-9]{4})?$";

    private ZipCodeValidator() {
    }

    public static ZipCodeValidator getInstance() {
        if (instance == null) {
            instance = new ZipCodeValidator();
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

        value = value.trim();

        if (value.matches(REGEX)) {
            return value.toLowerCase();
        }

        throw new IllegalArgumentException("Invalid zip code: " + value);
    }

}
