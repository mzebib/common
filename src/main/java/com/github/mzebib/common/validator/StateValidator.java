package com.github.mzebib.common.validator;

import com.github.mzebib.common.data.State;
import com.github.mzebib.common.util.CommonUtil;

/**
 * @author mzebib
 */
public class StateValidator
        extends BaseValidator<String,State> {

    private static StateValidator instance;

    private StateValidator() {
    }

    public static StateValidator getInstance() {
        if (instance == null) {
            instance = new StateValidator();
        }

        return instance;
    }

    /**
     * Validates given value.
     * @param value
     * @return value if valid
     * @throws NullPointerException
     * @throws IllegalArgumentException
     */
    @Override
    public State validate(String value)
            throws NullPointerException, IllegalArgumentException {
        CommonUtil.checkIfNulls("Input value is null", value);

        value = value.trim();

        State state = State.lookup(value);

        if (state != null) {
            return state;
        }

        throw new IllegalArgumentException("Invalid state: " + value);
    }

}