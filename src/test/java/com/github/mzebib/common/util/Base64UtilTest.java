package com.github.mzebib.common.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author mzebib
 */
public class Base64UtilTest {

    private static final String ORIGINAL_STRING = "username:password";
    private static final String ENCODED_STRING = "dXNlcm5hbWU6cGFzc3dvcmQ=";

    @Test
    public void testEncode() {
        byte[] encodedBytes = Base64Util.encode(ORIGINAL_STRING.getBytes());
        assertEquals(ENCODED_STRING, new String(encodedBytes));
    }

    @Test
    public void testDecode() {
        byte[] decodedBytes = Base64Util.decode(ENCODED_STRING.getBytes());
        assertEquals(ORIGINAL_STRING, new String(decodedBytes));
    }

}
