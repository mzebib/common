package com.github.mzebib.common.http;

import com.github.mzebib.common.util.CommonUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author mzebib
 */
public class HttpRequest {

    private String url;
    private Map<String, Object> parameters = new HashMap<>();
    private HttpMethod method;
    private HttpAuth authorization;
    private Map<String, String> headers = new LinkedHashMap<>();
    private byte[] content;

    public HttpRequest() {
    }

    public HttpRequest(String url, HttpMethod method) {
        setUrl(url);
        setMethod(method);
    }

    public HttpRequest(String url, String method) {
        setUrl(url);
        setMethod(method);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public void addParameter(String name, Object value) {
        if (parameters != null) {
            parameters.put(name, value);
        }
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public void setMethod(String method) {
        setMethod(HttpMethod.lookup(method));
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public HttpAuth getAuthorization() {
        return authorization;
    }

    public void setAuthorization(HttpAuth authorization) {
        this.authorization = authorization;
    }

    public String getUrlWithParameters() {
        if (url != null && parameters != null && !parameters.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(url);
            sb.append("?");
            sb.append(CommonUtil.format(parameters, "=", "&"));

            return sb.toString();
        }

        return url;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "{" +
                "url='" + url + '\'' +
                ", parameters=" + parameters +
                ", method=" + method +
                ", authorization=" + authorization +
                ", headers=" + headers +
                ", content=" + Arrays.toString(content) +
                '}';
    }

}