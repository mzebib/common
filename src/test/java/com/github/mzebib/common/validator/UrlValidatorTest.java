package com.github.mzebib.common.validator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * @author mzebib
 */
public class UrlValidatorTest {

    @Test
    public void testValidateValidValueReturnsValue() {
        assertEquals("https://www.google.com", UrlValidator.getInstance().validate("https://www.google.com"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateInvalidValueThrowsException() {
        UrlValidator.getInstance().validate("google.com");
    }

    @Test(expected = NullPointerException.class)
    public void testValidateNullValueThrowsException() {
        UrlValidator.getInstance().validate(null);
    }

    @Test
    public void testIsValid() {
        assertTrue(UrlValidator.getInstance().isValid("https://www.google.com"));
        assertTrue(UrlValidator.getInstance().isValid("http://www.google.com"));
        assertTrue(UrlValidator.getInstance().isValid("https://www.google.com/"));
        assertTrue(UrlValidator.getInstance().isValid("https://google.com"));
        assertTrue(UrlValidator.getInstance().isValid("https://www.google.com.us"));
        assertTrue(UrlValidator.getInstance().isValid("https://www.google.us"));

        assertFalse(UrlValidator.getInstance().isValid(""));
        assertFalse(UrlValidator.getInstance().isValid("www.google.com"));
        assertFalse(UrlValidator.getInstance().isValid("google.com"));
        assertFalse(UrlValidator.getInstance().isValid( "www.google"));
        assertFalse(UrlValidator.getInstance().isValid("www.google.com.com"));
        assertFalse(UrlValidator.getInstance().isValid("www.google.com@"));
    }

}
