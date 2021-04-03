package com.github.mzebib.common.validator;

import com.github.mzebib.common.data.State;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author mzebib
 */
public class StateValidatorTest {

    @Test
    public void testValidateValidValueReturnsValue() {
        assertEquals(State.CALIFORNIA, StateValidator.getInstance().validate("CA"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateInvalidValueThrowsException() {
        StateValidator.getInstance().validate("A");
    }

    @Test(expected = NullPointerException.class)
    public void testValidateNullValueThrowsException() {
        StateValidator.getInstance().validate(null);
    }

    @Test
    public void testIsValid() {
        assertTrue(StateValidator.getInstance().isValid("California"));
        assertTrue(StateValidator.getInstance().isValid("CA"));
        assertTrue(StateValidator.getInstance().isValid("Calif."));
        assertTrue(StateValidator.getInstance().isValid("california"));
        assertTrue(StateValidator.getInstance().isValid("ca"));
        assertTrue(StateValidator.getInstance().isValid("calif."));

        assertFalse(StateValidator.getInstance().isValid(""));
        assertFalse(StateValidator.getInstance().isValid("100"));
    }
}
