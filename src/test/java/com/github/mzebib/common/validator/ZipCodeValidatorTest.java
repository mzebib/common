package com.github.mzebib.common.validator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * @author mzebib
 */
public class ZipCodeValidatorTest {

    @Test
    public void testValidateValidValueReturnsValue() {
        assertEquals("01022", ZipCodeValidator.getInstance().validate("01022"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateInvalidValueThrowsException() {
        ZipCodeValidator.getInstance().validate("1");
    }

    @Test(expected = NullPointerException.class)
    public void testValidateNullValueThrowsException() {
        ZipCodeValidator.getInstance().validate(null);
    }

    @Test
    public void testIsValid() {
        assertTrue(ZipCodeValidator.getInstance().isValid("12345"));
        assertTrue(ZipCodeValidator.getInstance().isValid("12345-6789"));

        assertFalse(ZipCodeValidator.getInstance().isValid(""));
        assertFalse(ZipCodeValidator.getInstance().isValid("1234"));
        assertFalse(ZipCodeValidator.getInstance().isValid("123456"));
        assertFalse(ZipCodeValidator.getInstance().isValid( "12345-"));
        assertFalse(ZipCodeValidator.getInstance().isValid("12345-6"));
        assertFalse(ZipCodeValidator.getInstance().isValid("12345-67"));
        assertFalse(ZipCodeValidator.getInstance().isValid("12345-67"));
        assertFalse(ZipCodeValidator.getInstance().isValid("12345-678"));
        assertFalse(ZipCodeValidator.getInstance().isValid("1234A-123B"));
    }

}
