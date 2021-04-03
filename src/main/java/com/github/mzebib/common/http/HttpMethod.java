package com.github.mzebib.common.http;

/**
 * @author mzebib
 */
public enum HttpMethod {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    PATCH("PATCH"),
    DELETE("DELETE"),
    HEAD("HEAD"),
    OPTIONS("OPTIONS"),
    CONNECT("CONNECT"),
    TRACE("TRACE")
    ;

    private final String name;

    HttpMethod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static HttpMethod lookup(String method) {
        if (method != null) {
            for (HttpMethod httpMethod : HttpMethod.values()) {
                if (httpMethod.getName().equalsIgnoreCase(method)) {
                    return httpMethod;
                }
            }
        }

        return null;
    }

}