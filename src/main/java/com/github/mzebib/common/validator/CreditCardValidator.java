package com.github.mzebib.common.validator;

import com.github.mzebib.common.data.CreditCardType;
import com.github.mzebib.common.util.CommonUtil;

/**
 * @author mzebib
 */
public class CreditCardValidator
        extends BaseValidator<String,String> {

    private static CreditCardValidator instance;

    private CreditCardValidator() {
    }

    public static CreditCardValidator getInstance() {
        if (instance == null) {
            instance = new CreditCardValidator();
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
        value = value.replaceAll("[ -]", "");

        CreditCardType type = CreditCardType.lookup(value);

        if (type != null) {
            return value;
        }

        throw new IllegalArgumentException("Invalid credit card number: " + value);
    }

}
