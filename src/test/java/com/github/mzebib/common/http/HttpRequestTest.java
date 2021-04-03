package com.github.mzebib.common.http;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author mzebib
 */
public class HttpRequestTest {

    @Test
    public void testCreateHttpRequest() {
        HttpRequest httpRequest = new HttpRequest("http://localhost:8080", HttpMethod.GET);
        httpRequest.addParameter("city", "San+Francisco");
        httpRequest.addParameter("state", "CA");

        assertNotNull("http://locahost:8080", httpRequest.getUrl());
        assertEquals(2, httpRequest.getParameters().size());
        assertNotNull(httpRequest.getUrlWithParameters());
        assertEquals("http://localhost:8080?city=San+Francisco&state=CA", httpRequest.getUrlWithParameters());
    }

}
