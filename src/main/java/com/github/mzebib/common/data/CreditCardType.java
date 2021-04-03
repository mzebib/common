package com.github.mzebib.common.data;

import com.github.mzebib.common.validator.Validator;
import com.github.mzebib.common.util.CommonUtil;
import com.github.mzebib.common.util.StringUtil;

/**
 * @author mzebib
 */
public enum CreditCardType
        implements Validator<String,CreditCardType> {

    VISA("Visa", "^4[0-9]{12}(?:[0-9]{3})?$", "[0-9]{3}"),
    MASTER("MasterCard", "[5][12345]\\d{14}", "[0-9]{3}"),
    AMEX("American Express", "[3][47]\\d{13}", "[0-9]{4}"),
	DISCOVER("Discover", "6011\\d{12}", "[0-9]{3}")
    ;

    private String display;
    private String numberPattern;
    private String cvvPattern;

    CreditCardType(String display, String numberPattern, String cvvPattern) {
        this.display = display;
        this.numberPattern = numberPattern;
        this.cvvPattern = cvvPattern;
    }

    public String getDisplay() {
        return display;
    }

    @Override
    public CreditCardType validate(String value)
            throws NullPointerException, IllegalArgumentException {
        CommonUtil.checkIfNulls("Input value is null", value);

        value = StringUtil.trimOrNull(value);
        value = value.replaceAll("[ -]", "");

        if (value.matches(numberPattern)) {
            return this;
        }

        throw new IllegalArgumentException("Credit card type not found: " + value);
    }

    @Override
    public boolean isValid(String value) {
        try {
            validate(value);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public String validateCVV(String cvv)
            throws IllegalArgumentException {
        cvv = StringUtil.trimOrNull(cvv);
        CommonUtil.checkIfNulls("Input cvv is null", cvv);

        if (cvv.matches(cvvPattern)) {
            return cvv;
        }

        throw new IllegalArgumentException("Invalid CVV: " + cvv);
    }

    public static CreditCardType lookup(String number) {
        if (!StringUtil.isEmpty(number)) {
            for (CreditCardType type: CreditCardType.values()) {
                if (type.isValid(number)) {
                    return type;
                }
            }
        }

        return null;
    }

}