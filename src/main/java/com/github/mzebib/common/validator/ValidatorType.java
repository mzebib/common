package com.github.mzebib.common.validator;

/**
 * @author mzebib
 */
public enum ValidatorType
        implements Validator<String, String> {
    BIG_DECIMAL {
        @Override
        public String validate(String value)
                throws NullPointerException, IllegalArgumentException {
            return BigDecimalValidator.getInstance().validate(value).toString();
        }

        @Override
        public boolean isValid(String value) {
            return BigDecimalValidator.getInstance().isValid(value);
        }
    },
    BOOLEAN {
        @Override
        public String validate(String value)
                throws NullPointerException, IllegalArgumentException {
            return "" + BooleanValidator.getInstance().validate(value);
        }

        @Override
        public boolean isValid(String value) {
            return BooleanValidator.getInstance().isValid(value);
        }
    },
    CREDIT_CARD {
        @Override
        public String validate(String value)
                throws NullPointerException, IllegalArgumentException {
           return CreditCardValidator.getInstance().validate(value);
        }

        @Override
        public boolean isValid(String value) {
            return CreditCardValidator.getInstance().isValid(value);
        }
    },
    DOMAIN {
        @Override
        public String validate(String value)
                throws NullPointerException, IllegalArgumentException {
            return DomainValidator.getInstance().validate(value);
        }

        @Override
        public boolean isValid(String value) {
            return DomainValidator.getInstance().isValid(value);
        }
    },
    DOUBLE {
        @Override
        public String validate(String value)
                throws NullPointerException, IllegalArgumentException {
            return "" + DoubleValidator.getInstance().validate(value);
        }

        @Override
        public boolean isValid(String value) {
            return DoubleValidator.getInstance().isValid(value);
        }
    },
    EMAIL {
        @Override
        public String validate(String value)
                throws NullPointerException, IllegalArgumentException {
            return EmailValidator.getInstance().validate(value);
        }

        @Override
        public boolean isValid(String value) {
            return EmailValidator.getInstance().isValid(value);
        }
    },
    FLOAT {
        @Override
        public String validate(String value)
                throws NullPointerException, IllegalArgumentException {
            return "" + FloatValidator.getInstance().validate(value);
        }

        @Override
        public boolean isValid(String value) {
            return FloatValidator.getInstance().isValid(value);
        }
    },
    INTEGER {
        @Override
        public String validate(String value)
                throws NullPointerException, IllegalArgumentException {
            return "" + IntegerValidator.getInstance().validate(value);
        }

        @Override
        public boolean isValid(String value) {
            return IntegerValidator.getInstance().isValid(value);
        }
    },
    LONG {
        @Override
        public String validate(String value)
                throws NullPointerException, IllegalArgumentException {
            return "" + LongValidator.getInstance().validate(value);
        }

        @Override
        public boolean isValid(String value) {
            return LongValidator.getInstance().isValid(value);
        }
    },
    NUMBER {
        @Override
        public String validate(String value)
                throws NullPointerException, IllegalArgumentException {
            return NumberValidator.getInstance().validate(value);
        }

        @Override
        public boolean isValid(String value) {
            return NumberValidator.getInstance().isValid(value);
        }
    },
    PASSWORD {
        @Override
        public String validate(String value)
                throws NullPointerException, IllegalArgumentException {
            return PasswordValidator.getInstance().validate(value);
        }

        @Override
        public boolean isValid(String value) {
            return PasswordValidator.getInstance().isValid(value);
        }
    },
    URL {
        @Override
        public String validate(String value)
                throws NullPointerException, IllegalArgumentException {
            return UrlValidator.getInstance().validate(value);
        }

        @Override
        public boolean isValid(String value) {
            return UrlValidator.getInstance().isValid(value);
        }
    },
    ZIP_CODE {
        @Override
        public String validate(String value)
                throws NullPointerException, IllegalArgumentException {
            return ZipCodeValidator.getInstance().validate(value);
        }

        @Override
        public boolean isValid(String value) {
            return ZipCodeValidator.getInstance().isValid(value);
        }
    }
}