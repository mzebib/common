package com.github.mzebib.common.validator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author mzebib
 */
public class BigDecimalValidatorTest {

    @Test
    public void testValidateValidValueReturnsValue() {
        assertEquals(100, BigDecimalValidator.getInstance().validate("100").intValue());
        assertEquals((Double) 99.9, (Double) BigDecimalValidator.getInstance().validate("99.9").doubleValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateInvalidValueThrowsException() {
        BigDecimalValidator.getInstance().validate("Hello World!");
    }

    @Test(expected = NullPointerException.class)
    public void testValidateNullValueThrowsException() {
        BigDecimalValidator.getInstance().validate(null);
    }

    @Test
    public void testIsValid() {
        assertTrue(BigDecimalValidator.getInstance().isValid("100"));
        assertTrue(BigDecimalValidator.getInstance().isValid("99.9"));

        assertFalse(BigDecimalValidator.getInstance().isValid("Hello World!"));
    }
}
