package com.github.mzebib.common.util;

/**
 * @author mzebib
 */
public class Constants {

    public static final String UTF_8 = "UTF-8";
    public static final String UTF_16 = "UTF-16";

    public enum HtmlTag {
        HTML("<html>", "</html>"),
        HEAD("<head>", "</head>"),
        TITLE("<title>", "</title>"),
        BODY("<body>", "</body>")
        ;

        private final String preTag;
        private final String postTag;

        HtmlTag(String preTag, String postTag) {
            this.preTag = preTag;
            this.postTag = postTag;
        }

        public String getPreTag() {
            return preTag;
        }

        public String getPostTag() {
            return postTag;
        }
    }

    public enum RelationalOperator {
        EQ("="),
        NE("!="),
        GT(">"),
        GTE(">="),
        LT("<"),
        LTE("<=")
        ;

        private String symbol;

        RelationalOperator(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }

    public enum LogicalOperator {
        AND("&&"),
        OR("||"),
        NOT("!")
        ;

        private String symbol;

        LogicalOperator(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }

    public enum MIMEType
        implements GetName {

        APPLICATION_JSON("application/json", ".json"),
        APPLICATION_XML("application/xml", ".xml"),
        APPLICATION_OCTET_STREAM("application/octet-stream")

        ;


        private String name;
        private String[] extensions;

        MIMEType(String name, String... extensions) {
            this.name = name;
            this.extensions = extensions;
        }

        @Override
        public String getName() {
            return name;
        }

        public String[] getExtensions() {
            return extensions;
        }

        public static MIMEType lookup(String extension) {
            if (StringUtil.isEmpty(extension)) {
                return APPLICATION_OCTET_STREAM;
            }

            MIMEType ret = null;

            for (MIMEType type : MIMEType.values()) {
                if (StringUtil.contains(type.getExtensions(), extension.toLowerCase())) {
                    ret = type;
                    break;
                }
            }

            return ret;
        }
    }

    protected static final char[] HEX_TOKENS =
            {
                    '0',
                    '1',
                    '2',
                    '3',
                    '4',
                    '5',
                    '6',
                    '7',
                    '8',
                    '9',
                    'A',
                    'B',
                    'C',
                    'D',
                    'E',
                    'F'
            };

    private Constants() {
    }

}