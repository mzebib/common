package com.github.mzebib.common.http;

import com.github.mzebib.common.util.StringUtil;

/**
 * @author mzebib
 */
public class HttpAuthBearer
    implements HttpAuth {

    private final String token;

    public HttpAuthBearer(String token) {
        this.token = token;
    }

    @Override
    public HttpAuthType getAuthType() {
        return HttpAuthType.BEARER;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toHttpHeaderValue() {
        if (!StringUtil.isEmpty(token)) {
            return HttpAuthType.BEARER.toHttpHeaderValue(token);
        }

        return null;
    }

}