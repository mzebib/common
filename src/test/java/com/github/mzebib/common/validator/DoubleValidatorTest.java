package com.github.mzebib.common.validator;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author mzebib
 */
public class DoubleValidatorTest {

    @Test
    public void testValidateValidValueReturnsValue() {
        assertEquals((Double) 1.0, DoubleValidator.getInstance().validate("1"));
        assertEquals((Double) 99.99, DoubleValidator.getInstance().validate("99.99"));
        assertEquals((Double) 100.0, DoubleValidator.getInstance().validate("100.00"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateInvalidValueThrowsException() {
        DoubleValidator.getInstance().validate("hello");
    }

    @Test(expected = NullPointerException.class)
    public void testValidateNullValueThrowsException() {
        DoubleValidator.getInstance().validate(null);
    }

    @Test
    public void testIsValid() {
        assertTrue(DoubleValidator.getInstance().isValid("1"));
        assertTrue(DoubleValidator.getInstance().isValid("100.00"));

        assertFalse(DoubleValidator.getInstance().isValid("hello"));
    }

}
