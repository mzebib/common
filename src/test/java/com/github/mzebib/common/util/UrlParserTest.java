package com.github.mzebib.common.util;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author mzebib
 */
public class UrlParserTest {

    private static final String DEFAULT_URL = "http://localhost:8080";
    private static final String URL_WITH_SINGLE_PARAM = "http://localhost:8080?name=John";
    private static final String URL_WITH_MULTIPLE_PARAMS = "http://localhost:8080?city=SanFrancisco&state=CA";

    @Test
    public void testParseUrlNoParams()
            throws MalformedURLException, UnsupportedEncodingException {
        UrlParser.UrlParsedResult result = UrlParser.parse(DEFAULT_URL);
        assertNotNull(result);
        assertEquals(DEFAULT_URL, result.getBaseUrl());
    }

    @Test
    public void testParseUrlSingleParam()
            throws MalformedURLException, UnsupportedEncodingException {
        UrlParser.UrlParsedResult result = UrlParser.parse(URL_WITH_SINGLE_PARAM);
        assertNotNull(result);
        assertNotNull(result.getBaseUrl());
        assertEquals(DEFAULT_URL, result.getBaseUrl());
        assertNotNull(result.getParams());
        assertEquals(1, result.getParams().size());
        assertEquals("John", result.lookupParam("name"));
    }

    @Test
    public void testParseUrlMultipleParams()
            throws MalformedURLException, UnsupportedEncodingException {
        UrlParser.UrlParsedResult result = UrlParser.parse(URL_WITH_MULTIPLE_PARAMS);
        assertNotNull(result);
        assertNotNull(result.getBaseUrl());
        assertEquals(DEFAULT_URL, result.getBaseUrl());
        assertNotNull(result.getParams());
        assertEquals(2, result.getParams().size());
        assertEquals("SanFrancisco", result.lookupParam("city"));
        assertEquals("CA", result.lookupParam("state"));
    }

    @Test(expected = NullPointerException.class)
    public void testParseNullUrl()
            throws MalformedURLException, UnsupportedEncodingException {
        UrlParser.parse(null);
    }

    @Test(expected = MalformedURLException.class)
    public void testParseInvalidUrl()
            throws MalformedURLException, UnsupportedEncodingException {
        UrlParser.parse("http/localhost;");
    }

}