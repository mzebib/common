package com.github.mzebib.common.validator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author mzebib
 */
public class DomainValidatorTest {

    @Test
    public void testValidateValidValueReturnsValue() {
        assertEquals("google.com", DomainValidator.getInstance().validate("google.com"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateInvalidValueThrowsException() {
        DomainValidator.getInstance().validate(".google.com");
    }

    @Test(expected = NullPointerException.class)
    public void testValidateNullValueThrowsException() {
        DomainValidator.getInstance().validate(null);
    }

    @Test
    public void testIsValid() {
        assertTrue(DomainValidator.getInstance().isValid("www.google.com"));
        assertTrue(DomainValidator.getInstance().isValid("google.com"));
        assertTrue(DomainValidator.getInstance().isValid("www.google.com.us"));
        assertTrue(DomainValidator.getInstance().isValid("www.google.us"));

        assertFalse(DomainValidator.getInstance().isValid(""));
        assertFalse(DomainValidator.getInstance().isValid("www.google.com/"));
    }
}
