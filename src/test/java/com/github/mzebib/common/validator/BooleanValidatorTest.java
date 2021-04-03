package com.github.mzebib.common.validator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author mzebib
 */
public class BooleanValidatorTest {

    @Test
    public void testValidateValidValueReturnsValue() {
        assertEquals(true, BooleanValidator.getInstance().validate("true"));
        assertEquals(false, BooleanValidator.getInstance().validate("false"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateInvalidValueThrowsException() {
        BooleanValidator.getInstance().validate("100");
    }

    @Test(expected = NullPointerException.class)
    public void testValidateNullValueThrowsException() {
        BooleanValidator.getInstance().validate(null);
    }

    @Test
    public void testIsValid() {
        assertTrue(BooleanValidator.getInstance().isValid("true"));
        assertTrue(BooleanValidator.getInstance().isValid("false"));

        assertFalse(BooleanValidator.getInstance().isValid("100"));
        assertFalse(BooleanValidator.getInstance().isValid("hello"));
    }

}
