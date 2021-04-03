package com.github.mzebib.common.util;

public interface BytesValue<V> {

    byte[] toBytes(V value);

    V toValue(byte[] bytes);

    V toValue(byte[] bytes, int offset, int length);

    BytesValue<Integer> INTEGER = new BytesValue<Integer>() {
        @Override
        public byte[] toBytes(Integer in) {
            int val = in.intValue();
            byte[] buffer = new byte[Integer.SIZE/Byte.SIZE];

            for (int i = buffer.length; i > 0; i--) {
                buffer[i-1] = (byte) val;
                val = val >> 8;
            }

            return buffer;
        }

        @Override
        public Integer toValue(byte[] buffer, int offset, int length) {
            int value = 0;

            for (int i = offset; i < length; i++) {
                value = (value << 8) + (buffer[i] & 0xff);
            }

            return value;
        }

        @Override
        public Integer toValue(byte[] bytes) {
            return toValue(bytes, 0, bytes.length);
        }
    };

    BytesValue<Long> LONG = new BytesValue<Long>() {
        @Override
        public byte[] toBytes(Long in) {
            long val = in.longValue();
            byte[] buffer = new byte[Long.SIZE/Byte.SIZE];

            for (int i = buffer.length; i > 0; i--) {
                buffer[i-1] = (byte) val;
                val = val >> 8;
            }

            return buffer;
        }

        /**
         * @param bytes array
         * @param offset
         * @param length
         * @return Long converted value
         */
        @Override
        public Long toValue(byte[] bytes, int offset, int length) {
            long value = 0;

            for (int i = offset; i < length; i++) {
                value = (value << 8) + (bytes[i] & 0xff);
            }

            return value;
        }

        @Override
        public Long toValue(byte[] bytes) {
            return toValue(bytes, 0, bytes.length);
        }
    };

    BytesValue<Float> FLOAT = new BytesValue<Float>() {
        @Override
        public byte[] toBytes(Float in) {
            int val = Float.floatToIntBits(in);
            byte[] buffer = new byte[Float.SIZE/Byte.SIZE];

            for (int i = buffer.length; i > 0; i--) {
                buffer[i-1] = (byte) val;
                val = val >> 8;
            }

            return buffer;
        }

        /**
         * @param bytes
         * @param offset
         * @param length
         * @return float value
         */
        @Override
        public Float toValue(byte[] bytes, int offset, int length) {
            int value = 0;

            for (int i = offset; i < length; i++) {
                value = (value << 8) + (bytes[i] & 0xff);
            }

            return Float.intBitsToFloat(value);
        }

        @Override
        public Float toValue(byte[] bytes) {
            return toValue(bytes, 0, bytes.length);
        }
    };

    BytesValue<Double> DOUBLE = new BytesValue<Double>() {
        @Override
        public byte[] toBytes(Double in) {
            long val = Double.doubleToLongBits(in);
            byte[] buffer = new byte[Double.SIZE/Byte.SIZE];

            for (int i = buffer.length; i > 0; i--) {
                buffer[i-1] = (byte) val;
                val = val >> 8;
            }

            return buffer;
        }


        @Override
        public Double toValue(byte[] bytes, int offset, int length) {
            long value = 0;

            for (int i = offset; i < length; i++) {
                value = (value << 8) + (bytes[i] & 0xff);
            }

            return Double.longBitsToDouble(value);
        }

        @Override
        public Double toValue(byte[] bytes) {
            return toValue(bytes, 0, bytes.length);
        }
    };

    BytesValue<Short> SHORT = new  BytesValue<Short>() {
        @Override
        public byte[] toBytes(Short in) {
            int val = in.intValue();
            byte[] buffer = new byte[Short.SIZE/Byte.SIZE];

            for (int i = buffer.length; i > 0; i--) {
                buffer[i-1] = (byte) val;
                val = val >> 8;
            }

            return buffer;
        }

        @Override
        public Short toValue(byte[] buffer, int offset, int length) {
            int value = 0;

            for (int i = offset; i < length; i++) {
                value = (value << 8) + (buffer[i] & 0xff);
            }

            return (short) (value);
        }

        @Override
        public Short toValue(byte[] bytes) {
            return toValue(bytes, 0, bytes.length);
        }
    };

    BytesValue<Character> CHARACTER = new  BytesValue<Character>() {

        @Override
        public byte[] toBytes(Character in) {
            int val = in;

            int bufferSize;

            if (val > 0xff) {
                // 2-byte character
                bufferSize = Character.SIZE/Byte.SIZE;
            } else {
                // 1-byte character
                bufferSize = Character.SIZE/Byte.SIZE - 1;
            }

            byte[] buffer = new byte[bufferSize];

            for (int i = buffer.length; i > 0; i--) {
                buffer[i-1] = (byte) val;
                val = val >> 8;
            }

            return buffer;
        }

        @Override
        public Character toValue(byte[] buffer, int offset, int length) {
            int value = 0;

            for (int i = offset; i < length; i++) {
                value = (value << 8) + (buffer[i] & 0xff);
            }

            return (char) (value);
        }

        @Override
        public Character toValue(byte[] bytes) {
            return toValue(bytes, 0, bytes.length);
        }
    };

}