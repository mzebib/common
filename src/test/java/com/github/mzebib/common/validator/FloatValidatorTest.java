package com.github.mzebib.common.validator;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author mzebib
 */
public class FloatValidatorTest {

    @Test
    public void testValidateValidValueReturnsValue() {
        assertEquals((Double) 100.00, Double.valueOf("" + FloatValidator.getInstance().validate("100.00")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateInvalidValueThrowsException() {
        FloatValidator.getInstance().validate("hello");
    }

    @Test(expected = NullPointerException.class)
    public void testValidateNullValueThrowsException() {
        FloatValidator.getInstance().validate(null);
    }

    @Test
    public void testIsValid() {
        assertTrue(FloatValidator.getInstance().isValid("99.9f"));

        assertFalse(FloatValidator.getInstance().isValid("9.a"));
    }

}
