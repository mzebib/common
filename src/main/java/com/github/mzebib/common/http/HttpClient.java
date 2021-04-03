package com.github.mzebib.common.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @author mzebib
 */
public class HttpClient {

    private HttpRequest request;

    public HttpClient() {
    }

    public HttpClient(HttpRequest request) {
        setRequest(request);
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public HttpResponse send() throws IOException {
        if (request == null) {
            throw new NullPointerException("Http request is null");
        }

        HttpURLConnection connection = null;
        BufferedReader in = null;

        int responseCode;
        String responseData;
        Map<String, List<String>> responseHeaders;

        try {
            URL url = new URL(request.getUrlWithParameters());

            connection = (HttpURLConnection) url.openConnection();

            if (request.getMethod() != null) {
                connection.setRequestMethod(request.getMethod().getName());
            }

            if (request.getHeaders() != null && !request.getHeaders().isEmpty()) {
                for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }

            if (request.getAuthorization() != null) {
                HttpAuth httpAuth = request.getAuthorization();

                if (httpAuth.toHttpHeaderValue() != null) {
                    connection.setRequestProperty(HttpHeaderField.AUTHORIZATION.getName(), httpAuth.toHttpHeaderValue());
                }
            }

            if (request.getContent() != null) {
                connection.setDoOutput(true);
                connection.getOutputStream().write(request.getContent());
            }

            // Response
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String output;
            StringBuffer buffer = new StringBuffer();

            while ((output = in.readLine()) != null) {
                buffer.append(output);
            }

            responseData = buffer.toString();
            responseCode = connection.getResponseCode();
            responseHeaders = connection.getHeaderFields();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }

            if (in != null) {
                in.close();
            }
        }

        return new HttpResponse(responseCode, responseData, responseHeaders);
    }

}