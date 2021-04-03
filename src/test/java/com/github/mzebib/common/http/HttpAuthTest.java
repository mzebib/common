package com.github.mzebib.common.http;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class HttpAuthTest {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String TOKEN = "AbCdEf123456";
    private static final String BASIC_VALUE = "Basic dXNlcm5hbWU6cGFzc3dvcmQ=";
    private static final String BEARER_VALUE = "Bearer AbCdEf123456";

    @Test
    public void testToHttpHeaderBasicGivenTwoParamsReturnsValue() {
        String value = HttpAuthType.BASIC.toHttpHeaderValue(USERNAME, PASSWORD);
        assertNotNull(value);
        assertEquals(BASIC_VALUE, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testToHttpHeaderBasicGivenOneParamThrowsException() {
        HttpAuthType.BASIC.toHttpHeaderValue(USERNAME);
    }

    @Test(expected = NullPointerException.class)
    public void testToHttpHeaderBasicGivenNoParamsThrowsException() {
        HttpAuthType.BASIC.toHttpHeaderValue();
    }

    @Test
    public void testToHttpHeaderBearerGivenOneParamReturnsValue() {
        String value = HttpAuthType.BEARER.toHttpHeaderValue(TOKEN);
        assertNotNull(value);
        assertEquals(BEARER_VALUE, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testToHttpHeaderBearerGivenMultipleParamsThrowsException() {
        HttpAuthType.BEARER.toHttpHeaderValue(TOKEN, TOKEN);
    }

    @Test(expected = NullPointerException.class)
    public void testToHttpHeaderBearerGivenNoParamsThrowsException() {
        HttpAuthType.BEARER.toHttpHeaderValue();
    }

    @Test
    public void testToHttpAuthBasicGivenValidFormatReturnsResult() {
        HttpAuthBasic httpAuthBasic = HttpAuthType.BASIC.toHttpAuth(BASIC_VALUE);
        assertNotNull(httpAuthBasic);
        assertEquals(USERNAME, httpAuthBasic.getUsername());
        assertEquals(PASSWORD, httpAuthBasic.getPassword());
    }

    @Test
    public void testToHttpAuthBasicGivenValidFormatReturnsNull() {
        HttpAuthBasic httpAuthBasic = HttpAuthType.BASIC.toHttpAuth(null);
        assertNull(httpAuthBasic);
    }

    @Test
    public void testToHttpAuthBearerGivenValidFormatReturnsResult() {
        HttpAuthBearer httpAuthBearer = HttpAuthType.BEARER.toHttpAuth(BEARER_VALUE);
        assertNotNull(httpAuthBearer);
        assertEquals(TOKEN, httpAuthBearer.getToken());
    }

    @Test
    public void testToHttpAuthBearerGivenValidFormatReturnsNull() {
        HttpAuthBasic httpAuthBearer = HttpAuthType.BEARER.toHttpAuth(null);
        assertNull(httpAuthBearer);
    }

    @Test
    public void testParseGivenValidBasicAuthFormatReturnsResult() {
        HttpAuth httpAuth = HttpAuthType.parse(BASIC_VALUE);
        assertNotNull(httpAuth);
        assertEquals(HttpAuthType.BASIC, httpAuth.getAuthType());
        assertEquals(USERNAME, ((HttpAuthBasic) httpAuth).getUsername());
        assertEquals(PASSWORD, ((HttpAuthBasic) httpAuth).getPassword());
    }

    @Test
    public void testParseGivenValidBearerAuthFormatReturnsResult() {
        HttpAuth httpAuth = HttpAuthType.parse(BEARER_VALUE);
        assertNotNull(httpAuth);
        assertEquals(HttpAuthType.BEARER, httpAuth.getAuthType());
        assertEquals(TOKEN, ((HttpAuthBearer) httpAuth).getToken());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseGivenInvalidFormatThrowsException() {
        HttpAuthType.parse("");
    }

    @Test(expected = NullPointerException.class)
    public void testParseGivenNullThrowsException() {
        HttpAuthType.parse(null);
    }

}