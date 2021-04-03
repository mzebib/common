package com.github.mzebib.common.http;

/**
 * @author mzebib
 */
public enum HttpContentType {
    APPLICATION_JSON("application/json"),
    APPLICATION_OCTET_STREAM("application/octet-stream"),
    APPLICATION_WWW_URL_ENC("application/x-www-form-urlencoded"),
    CHARSET_UTF8("charset=utf-8"),
    MULTIPART_FORM_DATA("multipart/form-data"),
    TEXT_CSV("text/csv"),
    TEXT_HTML("text/html"),
    TEXT_PLAIN("text/plain")
    ;

    private final String name;

    HttpContentType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}