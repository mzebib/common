package com.github.mzebib.common.validator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author mzebib
 */
public class CreditCardValidatorTest {

    @Test
    public void testValidateValidValueReturnsValue() {
        assertEquals("4400123412341234", CreditCardValidator.getInstance().validate("4400123412341234"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateInvalidValueThrowsException() {
        CreditCardValidator.getInstance().validate("35356363");
    }

    @Test(expected = NullPointerException.class)
    public void testValidateNullValueThrowsException() {
        CreditCardValidator.getInstance().validate(null);
    }

    @Test
    public void testIsValid() {
        assertTrue(CreditCardValidator.getInstance().isValid("4400123412341234"));

        assertFalse(CreditCardValidator.getInstance().isValid("45037580358"));
    }

}
