package com.github.mzebib.common.validator;

import com.github.mzebib.common.util.CommonUtil;

/**
 * @author mzebib
 */
public class EmailValidator
        extends BaseValidator<String,String> {

    private static EmailValidator instance;

    private static final String REGEX ="^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.(([0-9]{1,3})|([a-zA-Z]{2,3}))$";

    private EmailValidator() {
    }

    public static EmailValidator getInstance() {
        if (instance == null) {
            instance = new EmailValidator();
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

        // Remove any leading and trailing whitespaces.
        value = value.trim();

        // Check if input matches the regular expression.
        if (value.matches(REGEX)) {
            return value;
        }

        throw new IllegalArgumentException("Invalid email: " + value);
    }

}
