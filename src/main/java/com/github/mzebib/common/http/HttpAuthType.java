package com.github.mzebib.common.http;

import com.github.mzebib.common.util.Base64Util;
import com.github.mzebib.common.util.StringUtil;

/**
 * @author mzebib
 */
public enum HttpAuthType {
    BASIC("Basic") {
        public String toHttpHeaderValue(String... params)
                throws NullPointerException, IllegalArgumentException {

            if (params == null || params.length == 0) {
                throw new NullPointerException("Missing username and password parameters");
            }

            if (params.length == 2) {
                String username = params[0];
                String password = params[1];

                return BASIC + " " + new String(Base64Util.encode(StringUtil.getBytes(username + ":" + password)));
            }

            throw new IllegalArgumentException("Basic authentication requires username and password parameters only");
        }

        public HttpAuthBasic toHttpAuth(String value) {
            if (value != null) {
                if (value.toLowerCase().startsWith(HttpAuthType.BASIC.getName().toLowerCase())) {
                    value = value.substring(HttpAuthType.BASIC.getName().toLowerCase().length()).trim();
                }

                String decodedValue = new String(Base64Util.decode(StringUtil.getBytes(value)));

                int index = decodedValue.indexOf(':');

                if (index == -1) {
                    return null;
                }

                String username = decodedValue.substring(0, index);
                String password = decodedValue.substring(index + 1);

                username = username.trim();
                password = password.trim();

                return new HttpAuthBasic(username, password);
            }

            return null;
        }
    },
    BEARER("Bearer") {
        public String toHttpHeaderValue(String... params)
                throws NullPointerException, IllegalArgumentException {
            if (params == null || params.length == 0) {
                throw new NullPointerException("Missing token parameter");
            }

            if (params.length == 1) {
                return BEARER + " " + params[0];
            }

            throw new IllegalArgumentException("Bearer authentication requires token parameter only");
        }

        public HttpAuthBearer toHttpAuth(String value) {
            if (value != null) {
                if (value.toLowerCase().startsWith(HttpAuthType.BEARER.getName().toLowerCase())) {
                    value = value.substring(HttpAuthType.BEARER.getName().toLowerCase().length()).trim();
                }

                return new HttpAuthBearer(value);
            }

            return null;
        }
    };

    private final String name;

    HttpAuthType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }

    public abstract String toHttpHeaderValue(String... params)
            throws NullPointerException, IllegalArgumentException;

    public abstract <V extends HttpAuth> V toHttpAuth(String value);

    public static HttpAuth parse(String value)
            throws NullPointerException, IllegalArgumentException {
        if (value == null) throw new NullPointerException("Missing value");

        String[] strs = StringUtil.parse(value, " ");

        if (strs.length != 0) {
            int index = 0;

            HttpAuthType type = (HttpAuthType) StringUtil.lookupEnum(values(), strs[index]);

            if (type == null) {
                throw new IllegalArgumentException("Invalid value: " + value);
            }

            return type.toHttpAuth(strs[index+1]);

        } else {
            throw new IllegalArgumentException("Invalid value: " + value);
        }

    }

}