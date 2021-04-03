package com.github.mzebib.common.validator;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author mzebib
 */
public class LongValidatorTest {

    @Test
    public void testValidateValidValueReturnsValue() {
        assertEquals((long) 100, (long) LongValidator.getInstance().validate("100"));
        assertEquals((long) Long.valueOf("214748364700000"), (long) LongValidator.getInstance().validate("214748364700000"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateInvalidValueThrowsException() {
        LongValidator.getInstance().validate("100.00");
    }

    @Test(expected = NullPointerException.class)
    public void testValidateNullValueThrowsException() {
        LongValidator.getInstance().validate(null);
    }

    @Test
    public void testIsValid() {
        assertTrue(LongValidator.getInstance().isValid( "100"));
        assertTrue(LongValidator.getInstance().isValid("214748364700000"));

        assertFalse(LongValidator.getInstance().isValid("99.99"));
    }
}
