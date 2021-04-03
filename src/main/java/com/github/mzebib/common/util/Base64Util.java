package com.github.mzebib.common.util;

/**
 * Contains utility methods that decodes/encodes a Base64 array to/from a byte array.
 * @author mzebib
 */
public class Base64Util {

    public final static byte BASE_64[] = {
                //"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
                'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                '0','1','2','3','4','5','6','7','8','9','+','/'
        };

    public final static byte URL_BASE_64[] = {
                //"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
                'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                '0','1','2','3','4','5','6','7','8','9','-','_'
        };

    public final static byte[] URL_REVERSE_BASE_64 = {
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,

                //                                                  -           0   1   2   3   4   5   6   7   8  9
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, 0, -1, -1,

                //  A  B  C  D  E  F  G  H  I  J  K   L   M   N   O   P   Q   R   S   T   U   V   W   X   Y   Z                   _
                -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63,

                //   a   b   c   d   e   f   g   h   i  j    k   l   m   n   o   p   q   r   s   t   u   v   w   x   y   z
                -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1,

                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        };

    public final static byte[] REVERSE_BASE_64 = {
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,

                //                                          +               /   0   1   2   3   4   5   6   7   8  9
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, 0, -1, -1,

                //  A  B  C  D  E  F  G  H  I  J  K   L   M   N   O   P   Q   R   S   T   U   V   W   X   Y   Z
                -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1,

                //   a   b   c   d   e   f   g   h   i  j    k   l   m   n   o   p   q   r   s   t   u   v   w   x   y   z
                -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1,
                // the rest
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        };



    public enum Base64Type {
        DEFAULT(BASE_64, REVERSE_BASE_64),
        URL(URL_BASE_64, URL_REVERSE_BASE_64);


        public final byte[] ENCODE_SET;
        public final byte[] DECODE_SET;

        Base64Type(byte[] encode, byte[] decode) {
            ENCODE_SET = encode;
            DECODE_SET = decode;
        }
    }

    private Base64Util() {
    }

    public static byte[] decode(byte[] data) {
        return decode(Base64Type.DEFAULT, data, 0, data.length);
    }

    public static byte[] decode(Base64Type bt, byte[] data) {
        return decode(bt, data, 0, data.length);
    }

    public static byte[] decode(byte[] data, int index, int len) {
        return decode(Base64Type.DEFAULT, data, index, len);
    }

    public static byte[] decode(Base64Type bt, byte[] data, int index, int len) {
        if (data == null || data.length == 0) {
            return new byte[0];
        }

        if (bt == null) {
            bt = Base64Type.DEFAULT;
        }

        int paddings = 0;

        if (data[len - 1] == '=') {
            paddings++;
            if (data[len - 2] == '=') {
                paddings++;
            }
        }

        if (paddings == 0 && (len % 0x04) !=  0) {
            paddings = 4 - (len % 0x04);
        }


        int olen = 3 * ((len + 3) / 4) - paddings;
        byte[] bytes = new byte[olen];

        int iidx = 0;
        int oidx = 0;

        while (iidx < len) {
            int c0 = bt.DECODE_SET[data[index + iidx++] & 0xff];
            int c1 = bt.DECODE_SET[data[index + iidx++] & 0xff];
            int c2 = (index + iidx < len) ? bt.DECODE_SET[data[index + iidx++] & 0xff] : 0;
            int c3 = (index + iidx < len) ? bt.DECODE_SET[data[index + iidx++] & 0xff] : 0;
            int c24 = (c0 << 18) | (c1 << 12) | (c2 << 6) | c3;


            bytes[oidx++] = (byte) (c24 >> 16);

            if (oidx == olen) {
                break;
            }

            bytes[oidx++] = (byte) (c24 >> 8);

            if (oidx == olen) {
                break;
            }

            bytes[oidx++] = (byte) c24;
        }

        return bytes;
    }

    public static byte[] decode(String str) {
        return decode(StringUtil.getBytes(str));
    }

    public static byte[] decode(Base64Type bt, String str) {
        return decode(bt, StringUtil.getBytes(str));
    }

    public static String decodeAsString(Base64Type bt, String str) {
        return StringUtil.bytesToString(decode(bt, StringUtil.getBytes(str)));
    }

    public static byte[] encode(String str) {
        return encode(StringUtil.getBytes(str));
    }

    public static byte[] encode(Base64Type bt, String str) {
        return encode(bt, StringUtil.getBytes(str));
    }

    public static String encodeAsString(Base64Type bt, String str) {
        return StringUtil.bytesToString(encode(bt, StringUtil.getBytes(str)));
    }

    public static String encodeAsString(Base64Type bt, byte[] array) {
        return StringUtil.bytesToString(encode(bt, array));
    }

    public static byte[] encode(byte[] data) {
        return encode(Base64Type.DEFAULT, data, 0, data.length);
    }

    public static byte[] encode(Base64Type bt, byte[] data) {
        return encode(bt, data, 0, data.length);
    }

    public static byte[] encode(byte[] data, int index, int len) {
        return encode(Base64Type.DEFAULT, data, index, len);
    }

    public static byte[] encode(Base64Type bt, byte[] data, int index, int len) {
        if (data == null || data.length == 0) {
            return new byte[0];
        }

        if (index < 0 || len > data.length - index ) {
            throw new IllegalArgumentException("Invalid parameter " + index + "," + len);
        }

        if (bt == null) {
            bt = Base64Type.DEFAULT;
        }

        int olen = 0;

        if (bt == Base64Type.URL) {
            int n = len % 3;
            olen = 4 * (len / 3) + (n == 0 ? 0 : n + 1);
        } else {
            olen = 4 * ((len + 2) / 3);
        }

        byte[] bytes = new byte[olen];

        int iidx = index;
        int oidx = 0;
        int charsLeft = len;

        while (charsLeft > 0) {
            int b0 = data[iidx++] & 0xff;
            int b1 = (charsLeft > 1) ? data[iidx++] & 0xff : 0;
            int b2 = (charsLeft > 2) ? data[iidx++] & 0xff : 0;
            int b24 = (b0 << 16) | (b1 << 8) | b2;

            int c0 = (b24 >> 18) & 0x3f;
            int c1 = (b24 >> 12) & 0x3f;
            int c2 = (b24 >> 6) & 0x3f;
            int c3 = b24 & 0x3f;

            bytes[oidx++] = bt.ENCODE_SET[c0];
            bytes[oidx++] = bt.ENCODE_SET[c1];
            if (oidx < bytes.length) {
                bytes[oidx++] = (byte)((charsLeft > 1) ? bt.ENCODE_SET[c2] : '=');
            } else {
                break;
            }

            if (oidx < bytes.length) {
                bytes[oidx++] = (byte)((charsLeft > 2) ? bt.ENCODE_SET[c3] : '=');
            } else {
                break;
            }

            charsLeft -= 3;
        }

        return bytes;
    }

}