package com.github.mzebib.common.http;

/**
 * @author mzebib
 */
public interface HttpAuth {

    HttpAuthType getAuthType();

    String toHttpHeaderValue();
}