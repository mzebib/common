package com.github.mzebib.common.http;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author mzebib
 */
public class HttpClientTest {

    @Test
    public void testHttpCall() throws IOException {
        HttpClient httpClient = mock(HttpClient.class);
        HttpRequest httpRequest = mock(HttpRequest.class);
        HttpResponse httpResponse = mock(HttpResponse.class);

        when(httpRequest.getUrlWithParameters()).thenReturn("http://localhost:8080");
        when(httpRequest.getMethod()).thenReturn(HttpMethod.GET);
        when(httpResponse.getStatusCode()).thenReturn(200);

        httpClient.setRequest(httpRequest);
        httpClient.send();

        assertEquals(200, httpResponse.getStatusCode());
    }

}
