package com.github.mzebib.common.validator;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author mzebib
 */
public class IntegerValidatorTest {

    @Test
    public void testValidateValidValueReturnsValue() {
        assertEquals((Integer) 100, IntegerValidator.getInstance().validate("100"));
        assertEquals((Integer) 2147483647, IntegerValidator.getInstance().validate("2147483647"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateInvalidValueThrowsException() {
        IntegerValidator.getInstance().validate("214748364700");
    }

    @Test(expected = NullPointerException.class)
    public void testValidateNullValueThrowsException() {
        IntegerValidator.getInstance().validate(null);
    }

    @Test
    public void testIsValid() {
        assertTrue(IntegerValidator.getInstance().isValid("100"));
        assertTrue(IntegerValidator.getInstance().isValid("2147483647"));

        assertFalse(IntegerValidator.getInstance().isValid("99.99"));
        assertFalse(IntegerValidator.getInstance().isValid("214748364700"));
    }
}
