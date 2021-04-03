package com.github.mzebib.common.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * @author mzebib
 */
public class CreditCardTypeTest {

    private static final String SAMPLE_VISA_NUMBER = "4111111111111111";
    private static final String SAMPLE_MASTERCARD_NUMBER = "5500000000000004";
    private static final String SAMPLE_AMEX_NUMBER = "340000000000009";
    private static final String SAMPLE_VISA_CVV = "123";
    private static final String SAMPLE_MASTERCARD_CVV = "123";
    private static final String SAMPLE_AMEX_CVV = "1234";

    @Test
    public void testValidateValidNumberReturnsType() {
        assertEquals(CreditCardType.VISA, CreditCardType.VISA.validate(SAMPLE_VISA_NUMBER));
        assertEquals(CreditCardType.MASTER, CreditCardType.MASTER.validate(SAMPLE_MASTERCARD_NUMBER));
        assertEquals(CreditCardType.AMEX, CreditCardType.AMEX.validate(SAMPLE_AMEX_NUMBER));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateInvalidNumberThrowsException() {
        CreditCardType.VISA.validate("12345");
    }

    @Test(expected = NullPointerException.class)
    public void testValidateNullNumberThrowsException() {
        CreditCardType.VISA.validate(null);
    }

    @Test
    public void testIsValid() {
        assertTrue(CreditCardType.VISA.isValid(SAMPLE_VISA_NUMBER));
        assertTrue(CreditCardType.MASTER.isValid(SAMPLE_MASTERCARD_NUMBER));
        assertTrue(CreditCardType.AMEX.isValid(SAMPLE_AMEX_NUMBER));

        assertFalse(CreditCardType.VISA.isValid("12345"));
        assertFalse(CreditCardType.MASTER.isValid("12345"));
        assertFalse(CreditCardType.AMEX.isValid("12345"));
    }

    @Test
    public void testLookupCreditType() {
        assertEquals(CreditCardType.VISA, CreditCardType.lookup(SAMPLE_VISA_NUMBER));
        assertEquals(CreditCardType.MASTER, CreditCardType.lookup(SAMPLE_MASTERCARD_NUMBER));
        assertEquals(CreditCardType.AMEX, CreditCardType.lookup(SAMPLE_AMEX_NUMBER));

        assertNull(CreditCardType.lookup("12345"));
    }

    @Test
    public void testValidateCVVValidValue() {
        assertEquals(SAMPLE_VISA_CVV, CreditCardType.VISA.validateCVV(SAMPLE_VISA_CVV));
        assertEquals(SAMPLE_MASTERCARD_CVV, CreditCardType.MASTER.validateCVV(SAMPLE_MASTERCARD_CVV));
        assertEquals(SAMPLE_AMEX_CVV, CreditCardType.AMEX.validateCVV(SAMPLE_AMEX_CVV));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateCVVInvalidValueThrowsException() {
        CreditCardType.VISA.validateCVV("1");
    }

    @Test(expected = NullPointerException.class)
    public void testValidateCVVNullValueThrowsException() {
        assertNull(CreditCardType.VISA.validateCVV(null));
    }

}
