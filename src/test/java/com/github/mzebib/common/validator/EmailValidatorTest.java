package com.github.mzebib.common.validator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * @author mzebib
 */
public class EmailValidatorTest {

    @Test
    public void testValidateValidValueReturnsValue() {
        assertEquals("john.smith@gmail.com", EmailValidator.getInstance().validate("john.smith@gmail.com"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateInvalidValueThrowsException() {
        EmailValidator.getInstance().validate("johnsmith");
    }

    @Test(expected = NullPointerException.class)
    public void testValidateNullValueThrowsException() {
        EmailValidator.getInstance().validate(null);
    }

    @Test
    public void testIsValid() {
        assertTrue(EmailValidator.getInstance().isValid("john.smith@gmail.com"));
        assertTrue(EmailValidator.getInstance().isValid("johnsmith@gmail.com"));
        assertTrue(EmailValidator.getInstance().isValid("   johnsmith@gmail.com"));
        assertTrue(EmailValidator.getInstance().isValid("johnsmith@gmail.com   "));
        assertTrue(EmailValidator.getInstance().isValid("johnsmith1@gmail.com"));
        assertTrue(EmailValidator.getInstance().isValid("1johnsmith@g-mail.com"));
        assertTrue(EmailValidator.getInstance().isValid("johnsmith@gmail.com.us"));

        assertFalse(EmailValidator.getInstance().isValid(""));
        assertFalse(EmailValidator.getInstance().isValid("johnsmith"));
        assertFalse(EmailValidator.getInstance().isValid("johnsmith@"));
        assertFalse(EmailValidator.getInstance().isValid( "johnsmith@.com"));
        assertFalse(EmailValidator.getInstance().isValid("johnsmith@.com.com"));
        assertFalse(EmailValidator.getInstance().isValid("johnsmith@gmail.com.1a"));
        assertFalse(EmailValidator.getInstance().isValid("john smith@gmail.com"));
        assertFalse(EmailValidator.getInstance().isValid("johnsmith@gmail"));
        assertFalse(EmailValidator.getInstance().isValid("johnsmith@gmail.c"));
        assertFalse(EmailValidator.getInstance().isValid(".johnsmith@gmail.com"));
    }
}
