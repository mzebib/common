package com.github.mzebib.common.validator;

import com.github.mzebib.common.util.CommonUtil;

/**
 * @author mzebib
 */
public class UrlValidator
        extends BaseValidator<String,String> {

    private static UrlValidator instance;

    private static final String REGEX = "^(https?|ftp|file)://[-a-zA-Z0-9][-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    private static final int MAX_LENGTH = 4096;

    private UrlValidator() {
    }

    public static UrlValidator getInstance() {
        if (instance == null) {
            instance = new UrlValidator();
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
            if (value.length() > MAX_LENGTH) {
                throw new IllegalArgumentException("URL length is greater than max length "
                        + MAX_LENGTH + ". Length of " + value  + ": " + value.length());
            }

            return value.toLowerCase();
        }

        throw new IllegalArgumentException("Invalid URL: " + value);
    }

}
