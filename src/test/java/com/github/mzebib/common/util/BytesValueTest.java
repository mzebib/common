package com.github.mzebib.common.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BytesValueTest {

    @Test
    public void testToBytesShort() {
        byte[] bytes = BytesValue.SHORT.toBytes((short) 100);
        assertNotNull(bytes);
        assertEquals(2, bytes.length);
    }

    @Test
    public void testToValueShort() {
        byte[] bytes = new byte[]{0, 100};
        assertEquals(100, (short) BytesValue.SHORT.toValue(bytes));
    }

    @Test
    public void testToBytesInteger() {
        byte[] bytes = BytesValue.INTEGER.toBytes(100);
        assertNotNull(bytes);
        assertEquals(4, bytes.length);
    }

    @Test
    public void testToValueInteger() {
        byte[] bytes = new byte[]{0, 0, 0, 100};
        assertEquals(100, (int) BytesValue.INTEGER.toValue(bytes));
    }

    @Test
    public void testToBytesLong() {
        byte[] bytes = BytesValue.LONG.toBytes((long) 2147483647);
        assertNotNull(bytes);
        assertEquals(8, bytes.length);
    }

    @Test
    public void testToValueLong() {
        byte[] bytes = new byte[]{0, 0, 0, 0, 127, -1, -1, -1};
        assertEquals((long) 2147483647, (long) BytesValue.LONG.toValue(bytes));
    }

    @Test
    public void testToBytesDouble() {
        byte[] bytes = BytesValue.DOUBLE.toBytes(100.00);
        assertNotNull(bytes);
        assertEquals(8, bytes.length);
    }

    @Test
    public void testToValueDouble() {
        byte[] bytes = new byte[]{64, 89, 0, 0, 0, 0, 0, 0};
        assertEquals((Double) 100.00, BytesValue.DOUBLE.toValue(bytes));
    }

    @Test
    public void testToBytesFloat() {
        byte[] bytes = BytesValue.FLOAT.toBytes(4.0f);
        assertNotNull(bytes);
        assertEquals(4, bytes.length);
    }

    @Test
    public void testToValueFloat() {
        byte[] bytes = new byte[]{64, -128, 0, 0};
        assertEquals((Float) 4.0f, BytesValue.FLOAT.toValue(bytes));
    }

    @Test
    public void testToBytesChar() {
        byte[] bytes = BytesValue.CHARACTER.toBytes('A');
        assertNotNull(bytes);
        assertEquals(1, bytes.length);
    }

    @Test
    public void testToValueChar() {
        byte[] bytes = new byte[]{65};
        assertEquals( 'A', BytesValue.CHARACTER.toValue(bytes).charValue());
    }

}
