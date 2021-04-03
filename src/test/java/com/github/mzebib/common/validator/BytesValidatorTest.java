package com.github.mzebib.common.validator;

import com.github.mzebib.common.util.BytesValue;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author mzebib
 */
public class BytesValidatorTest {

    @Test
    public void testValidateValidValueReturnsValue() {
        assertEquals("Hello World!", new String(BytesValidator.getInstance().validate("Hello World!")));
        assertEquals((Integer) 100, BytesValue.INTEGER.toValue(BytesValidator.getInstance().validate(100)));
        assertEquals((Double) 1.0,  BytesValue.DOUBLE.toValue(BytesValidator.getInstance().validate(1.0)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateInvalidValueThrowsException() {
        BytesValidator.getInstance().validate(new BigDecimal("100.00"));
    }

    @Test(expected = NullPointerException.class)
    public void testValidateNullValueThrowsException() {
        BytesValidator.getInstance().validate(null);
    }

    @Test
    public void testIsValid() {
        assertTrue(BytesValidator.getInstance().isValid(100));
        assertTrue(BytesValidator.getInstance().isValid("Hello World!"));
        assertTrue(BytesValidator.getInstance().isValid(1.0));
        assertTrue(BytesValidator.getInstance().isValid(true));

        assertFalse(BytesValidator.getInstance().isValid(new BigDecimal("100.00")));
    }

}