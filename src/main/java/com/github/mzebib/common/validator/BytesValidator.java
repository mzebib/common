package com.github.mzebib.common.validator;

import com.github.mzebib.common.util.CommonUtil;
import com.github.mzebib.common.util.BytesValue;
import com.github.mzebib.common.util.GetValue;
import com.github.mzebib.common.util.StringUtil;

/**
 * @author mzebib
 */
public class BytesValidator
        extends BaseValidator<Object,byte[]> {

	private static BytesValidator instance;

	private BytesValidator() {
	}

    public static BytesValidator getInstance() {
        if (instance == null) {
            instance = new BytesValidator();
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
	public byte[] validate(Object value)
            throws NullPointerException, IllegalArgumentException {
        CommonUtil.checkIfNulls("Input value is null", value);

		if (value instanceof GetValue) {
            value = ((GetValue) value).getValue();
		}

        CommonUtil.checkIfNulls("Value is null", value);

		if (value instanceof String) {
			return StringUtil.getBytes((String) value);
		} else if (value instanceof byte[]) {
			return (byte[]) value;
		} else if (value instanceof Boolean) {
			byte[] ret = new byte[1];

			if ((Boolean) value) {
				ret[0] = 1;
			} else {
				ret[0] = 0;
			}

			return ret;
		} else if (value instanceof Integer) {
			return BytesValue.INTEGER.toBytes((Integer) value);
		} else if (value instanceof Long) {
			return BytesValue.LONG.toBytes((Long) value);
		} else if (value instanceof Float) {
			return BytesValue.FLOAT.toBytes((Float) value);
		} else if (value instanceof Double) {
			return BytesValue.DOUBLE.toBytes((Double) value);
		}

		throw new IllegalArgumentException("Unsupported type: " + value.getClass().getName());
	}

}