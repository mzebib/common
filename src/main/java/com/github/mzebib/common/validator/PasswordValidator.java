package com.github.mzebib.common.validator;

import com.github.mzebib.common.util.CommonUtil;
import com.github.mzebib.common.util.StringUtil;

/**
 * Default password requirements:
 * - Minimum 8 characters
 * - Contains lowercase letters, uppercase letters, and numbers
 * @author mzebib
 */
public class PasswordValidator
        extends BaseValidator<String, String> {

    private static PasswordValidator instance;

    private static final String REGEX ="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,64})";

    private PasswordValidator() {
    }

    public static PasswordValidator getInstance() {
        if (instance == null) {
            instance = new PasswordValidator();
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
        value = StringUtil.trimOrNull(value);
        CommonUtil.checkIfNulls("Input value is null", value);

        if (value.matches(REGEX)) {
            return value;
        } else {
            throw new IllegalArgumentException("Password must be 8 or more characters containing letters (uppercase and lowercase) and numbers");
        }
    }

}
