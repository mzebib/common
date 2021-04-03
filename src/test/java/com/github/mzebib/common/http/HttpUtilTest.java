package com.github.mzebib.common.http;

import com.github.mzebib.common.util.AuthInfo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author mzebib
 */
public class HttpUtilTest {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String TOKEN = "AbCdEf123456";
    private static final String BASIC_VALUE = "Basic dXNlcm5hbWU6cGFzc3dvcmQ=";
    private static final String BEARER_VALUE = "Bearer AbCdEf123456";

    @Test
    public void testIsBasicType() {
        assertTrue(HttpUtil.isBasicType(BASIC_VALUE));

        assertFalse(HttpUtil.isBasicType(BEARER_VALUE));
    }

    @Test
    public void testParseBasicType() {
        AuthInfo authInfo = HttpUtil.parseBasicType(BASIC_VALUE);
        assertNotNull(authInfo);
        assertNotNull(authInfo.getUsername());
        assertNotNull(authInfo.getPassword());
        assertEquals(USERNAME, authInfo.getUsername());
        assertEquals(PASSWORD, authInfo.getPassword());
    }

    @Test
    public void testIsBearerType() {
        assertTrue(HttpUtil.isBearerType(BEARER_VALUE));

        assertFalse(HttpUtil.isBearerType(BASIC_VALUE));
    }

    @Test
    public void testParseBearerType() {
        AuthInfo authInfo = HttpUtil.parseBearerType(BEARER_VALUE);
        assertNotNull(authInfo);
        assertNotNull(authInfo.getToken());
        assertEquals(TOKEN, authInfo.getToken());
    }

}
