package com.github.mzebib.common.validator;

import com.github.mzebib.common.util.CommonUtil;

import java.math.BigDecimal;

/**
 * @author mzebib
 */
public class BigDecimalValidator
        extends BaseValidator<String,BigDecimal> {

    private static BigDecimalValidator instance;

    private BigDecimalValidator() {
    }

    public static BigDecimalValidator getInstance() {
        if (instance == null) {
            instance = new BigDecimalValidator();
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
    public BigDecimal validate(String value)
            throws NullPointerException, IllegalArgumentException {
        CommonUtil.checkIfNulls("Input value is null", value);

        try {
            return new BigDecimal(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid BigDecimal type: " + value);
        }
    }

}
