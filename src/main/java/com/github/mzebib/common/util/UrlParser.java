package com.github.mzebib.common.util;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author mzebib
 */
public class UrlParser {

    public static class UrlParsedResult {

        private final String baseUrl;
        private final Map<String, List<String>> params;

        public UrlParsedResult(String baseUrl, Map<String, List<String>> params) {
            this.baseUrl = baseUrl;
            this.params = params;
        }

        public String getBaseUrl() {
            return baseUrl;
        }

        public Map<String, List<String>> getParams() {
            return params;
        }

        public String lookupParam(String name) {
            if (params != null && !StringUtil.isEmpty(name)) {
                List<String> values = lookupParams(name);

                if (values != null) {
                    return values.get(0);
                }
            }

            return null;
        }

        public List<String> lookupParams(String name) {
            if (params != null && !StringUtil.isEmpty(name)) {
                return params.get(name);
            }

            return null;
        }
    }

    private UrlParser() {
    }

    public static UrlParsedResult parse(String url)
            throws MalformedURLException, UnsupportedEncodingException {
        CommonUtil.checkIfNulls("Input url is null", url);
        String urlString = StringUtil.valueBeforeToken(url, "?");
        return new UrlParsedResult(urlString, splitQueryParams(url));
    }

    public static Map<String, List<String>> splitQueryParams(String url)
            throws UnsupportedEncodingException, MalformedURLException {
        return splitQueryParams(new URL(url));
    }

    public static Map<String, List<String>> splitQueryParams(URL url)
            throws UnsupportedEncodingException {
        CommonUtil.checkIfNulls("Input url is null", url);
        final Map<String, List<String>> queryPairs = new LinkedHashMap<>();
        if (url.getQuery() != null) {
            final String[] pairs = url.getQuery().split("&");

            if (pairs != null && pairs.length > 0) {
                for (String pair : pairs) {
                    final int index = pair.indexOf("=");
                    final String key = index > 0 ? URLDecoder.decode(pair.substring(0, index), "UTF-8") : pair;

                    if (!queryPairs.containsKey(key)) {
                        queryPairs.put(key, new LinkedList<String>());
                    }

                    final String value = index > 0 && pair.length() > index + 1 ? URLDecoder.decode(pair.substring(index + 1), "UTF-8") : null;
                    queryPairs.get(key).add(value);
                }
            }
        }

        return queryPairs;
    }

}