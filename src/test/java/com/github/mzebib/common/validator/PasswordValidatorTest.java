package com.github.mzebib.common.validator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author mzebib
 */
public class PasswordValidatorTest {

    @Test
    public void testValidateValidValueReturnsValue() {
        assertEquals("Password123", PasswordValidator.getInstance().validate("Password123"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateInvalidValueThrowsException() {
        PasswordValidator.getInstance().validate("password");
    }

    @Test(expected = NullPointerException.class)
    public void testValidateNullValueThrowsException() {
        PasswordValidator.getInstance().validate(null);
    }

    @Test
    public void testIsValid() {
        assertTrue(PasswordValidator.getInstance().isValid("Password123"));
        assertTrue(PasswordValidator.getInstance().isValid("Password123!"));

        assertFalse(PasswordValidator.getInstance().isValid("Password"));
        assertFalse(PasswordValidator.getInstance().isValid("password"));
        assertFalse(PasswordValidator.getInstance().isValid("password123"));
        assertFalse(PasswordValidator.getInstance().isValid("123456789"));
        assertFalse(PasswordValidator.getInstance().isValid("pass"));

    }
}
