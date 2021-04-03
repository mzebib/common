package com.github.mzebib.common.http;

import com.github.mzebib.common.util.AuthInfo;

/**
 * @author mzebib
 */
public class HttpUtil {

    private HttpUtil() {
    }

    public static boolean isBasicType(String value) {
        try {
            parseBasicType(value);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public static AuthInfo parseBasicType(String value) {
        if (value == null) {
            throw new NullPointerException("Null value");
        }

        if (!value.toLowerCase().startsWith(HttpAuthType.BASIC.getName().toLowerCase())) {
            throw new IllegalArgumentException("Invalid Basic type: " + value);
        }

        HttpAuthBasic httpAuthBasic = HttpAuthType.BASIC.toHttpAuth(value);

        if (httpAuthBasic == null) {
            throw new IllegalArgumentException("Invalid Basic type: " + value);
        }

        return new AuthInfo(httpAuthBasic.getUsername(), httpAuthBasic.getPassword());
    }

    public static boolean isBearerType(String value) {
        try {
            parseBearerType(value);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public static AuthInfo parseBearerType(String value) {
        if (value == null) {
            throw new NullPointerException("Null value");
        }

        if (!value.toLowerCase().startsWith(HttpAuthType.BEARER.getName().toLowerCase())) {
            throw new IllegalArgumentException("Invalid Bearer type: " + value);
        }

        HttpAuthBearer httpAuthBearer = HttpAuthType.BEARER.toHttpAuth(value);

        if (httpAuthBearer == null) {
            throw new IllegalArgumentException("Invalid Bearer type: " + value);
        }

        return new AuthInfo(httpAuthBearer.getToken());
    }

}