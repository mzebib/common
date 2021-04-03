package com.github.mzebib.common.http;

import com.github.mzebib.common.util.StringUtil;

/**
 * @author mzebib
 */
public class HttpAuthBasic
    implements HttpAuth {

    private final String username;
    private final String password;

    public HttpAuthBasic(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public HttpAuthType getAuthType() {
        return HttpAuthType.BASIC;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toHttpHeaderValue() {
        if (!StringUtil.isEmpty(username) && !StringUtil.isEmpty(password)) {
            return HttpAuthType.BASIC.toHttpHeaderValue(username, password);
        }

        return null;
    }

}