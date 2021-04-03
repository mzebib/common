package com.github.mzebib.common.validator;

import com.github.mzebib.common.util.CommonUtil;
import com.github.mzebib.common.util.StringUtil;

/**
 * @author mzebib
 */
public class DomainValidator
        extends BaseValidator<String,String> {

    private static DomainValidator instance;

    private static final String REGEX = "^([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,65}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,6}$";
    private static final int MAX_LENGTH = 4096;

    private DomainValidator() {
    }

    public static DomainValidator getInstance() {
        if (instance == null) {
            instance = new DomainValidator();
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
            if (value.length() > MAX_LENGTH) {
                throw new IllegalArgumentException("URL length > max length " + value.length() + ":" + value);
            }

            return value.toLowerCase();
        } else {
            throw new IllegalArgumentException("Invalid URL syntax " + value);
        }
    }

}
