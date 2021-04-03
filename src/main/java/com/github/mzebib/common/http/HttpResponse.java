package com.github.mzebib.common.http;

import java.util.List;
import java.util.Map;

/**
 * @author mzebib
 */
public class HttpResponse {

    private final int statusCode;
    private final String data;
    private final Map<String, List<String>> responseHeaders;

    public HttpResponse(int statusCode, String data, Map<String, List<String>> responseHeaders) {
        this.statusCode = statusCode;
        this.data = data;
        this.responseHeaders = responseHeaders;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getData() {
        return data;
    }

    public Map<String, List<String>> getResponseHeaders() {
        return responseHeaders;
    }

    @Override
    public String toString() {
        return "{" +
                "statusCode=" + statusCode +
                ", data='" + data + '\'' +
                ", responseHeaders=" + responseHeaders +
                '}';
    }
}