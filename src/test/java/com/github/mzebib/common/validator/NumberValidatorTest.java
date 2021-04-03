package com.github.mzebib.common.validator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author mzebib
 */
public class NumberValidatorTest {

    @Test
    public void testValidateValidValueReturnsValue() {
        assertEquals("100", NumberValidator.getInstance().validate("100"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateInvalidValueThrowsException() {
        NumberValidator.getInstance().validate("Hello World!");
    }

    @Test(expected = NullPointerException.class)
    public void testValidateNullValueThrowsException() {
        NumberValidator.getInstance().validate(null);
    }

    @Test
    public void testIsValid() {
        assertTrue(NumberValidator.getInstance().isValid("1"));
        assertTrue(NumberValidator.getInstance().isValid("1000"));
        assertTrue(NumberValidator.getInstance().isValid("12346789"));

        assertFalse(NumberValidator.getInstance().isValid("A"));
        assertFalse(NumberValidator.getInstance().isValid("1A"));
        assertFalse(NumberValidator.getInstance().isValid("Hello World!"));
        assertFalse(NumberValidator.getInstance().isValid("100.0f"));
    }

}
