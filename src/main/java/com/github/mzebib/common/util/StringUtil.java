package com.github.mzebib.common.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Contains String related utility methods.
 * @author mzebib
 */
public class StringUtil {

    private StringUtil() {
    }

    /**
     * Checks if the given String is null and length is equal to zero.
     * @param str to check
     * @return true if null or empty, otherwise false
     */
    public static boolean isEmpty(String str) {
        return !(str != null && str.trim().length() != 0);
    }

    public static String truncate(String str, int length) {
        if (str == null) {
            return null;
        }

        if (str.length() > length) {
            return str.substring(0, length);
        }

        return str;
    }

    public static String trimOrNull(String str) {
        if (str != null) {
            str = str.trim();

            if (str.length() > 0) {
                return str;
            }
        }

        return null;
    }

    public static boolean contains(String[] strs, String lookingFor) {
        if (strs != null && strs.length > 0 && lookingFor != null) {
            for (String str : strs) {
                if (lookingFor.equals(str)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static <V> String format(String name, V value, String separator) {
        StringBuilder sb = new StringBuilder();

        if (name != null) {
            sb.append(name);

            if (separator != null) {
                sb.append(separator);
            } else {
                sb.append("=");
            }
        }

        sb.append(value);

        return sb.toString();
    }

    public static String valueBeforeToken(String str, String token) {
        if (str != null && token != null) {
            int lastIndex = str.lastIndexOf(token);

            if (lastIndex != -1) {
                return str.substring(0, lastIndex);
            }
        }

        return str;
    }

    public static String valueAfterToken(String str, String token) {
        if (str != null && token != null) {
            int lastIndex = str.lastIndexOf(token);

            if (lastIndex != -1) {
                return str.substring(lastIndex+token.length());
            }
        }

        return str;
    }

    public static byte[] getBytes(String str)
            throws NullPointerException, IllegalArgumentException {
        if (str == null) {
            throw new NullPointerException("Input string is null");
        }

        try {
            return str.getBytes(Constants.UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String bytesToString(byte[] array)
            throws NullPointerException, IllegalArgumentException {
        if (array == null) {
            throw new NullPointerException("Input array is null");
        }

        try {
            return new String(array, Constants.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static String[] parse(String str, String regex, CharSequence... filter) {
        if (filter != null) {
            str = filter(str, filter);
        }

        return str.split(regex);
    }

    public static String filter(String str, CharSequence... filter) {
        if (str != null) {
            int length = filter.length;

            for(int i = 0; i < length; ++i) {
                CharSequence cs = filter[i];
                str = str.replace(cs, "");
            }
        }

        return str;
    }

    public static Enum<?> lookupEnum(Enum<?>[] enumValues, String str) {
        if (str != null) {
            int length = enumValues.length;

            for(int i = 0; i < length; ++i) {
                Enum<?> e = enumValues[i];
                if (str.equalsIgnoreCase(e.name())) {
                    return e;
                }

                if (str.equalsIgnoreCase(e.toString())) {
                    return e;
                }

                if (e instanceof GetName && str.equalsIgnoreCase(((GetName)e).getName())) {
                    return e;
                }

                if (e instanceof GetValue && str.equalsIgnoreCase("" + ((GetValue)e).getValue())) {
                    return e;
                }
            }
        }

        return null;
    }

    public static String[] permute(String str) {
        if (str != null) {
            List<String> result = permute(new ArrayList<>(), str, 0, str.length() - 1);
            return result.toArray(new String[0]);
        }

        return null;
    }

    /**
     * Permutations for given string.
     * @param result array containing permutations
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     * @return
     */
    private static List<String> permute(List<String> result, String str, int l, int r) {
        if (result == null) {
            result = new ArrayList<>();
        }

        if (l == r) {
            result.add(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str,l,i);
                permute(result, str, l+1, r);
                str = swap(str,l,i);
            }
        }

        return result;
    }

    /**
     *
     * @param a
     * @param i
     * @param j
     * @return
     */
    private static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    /**
     * Checks if the two given strings are anagram.
     * Two String are anagram if they contain same characters but in different order (e.g. army and mary).
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isAnagram(String str1, String str2) {
        str1 = str1.replaceAll(" ", "");
        str1 = str1.toLowerCase();

        str2 = str2.replaceAll(" ", "");
        str2 = str2.toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        } else if (str1.equals(str2)) {
            return true;
        }

        Set<Character> characterSet = new HashSet<>();

        for (int i=0; i<str1.length(); i++) {
            characterSet.add(str1.charAt(i));
        }

        for (char c : str2.toCharArray()) {
            if (!characterSet.contains(c)) return false;
        }

        return true;
    }

    /**
     * Checks if given string is a palindrome.
     * A string is a palindrome if it remains unchanged when reversed (e.g. "bob").
     * @param str string to check if palindrome
     * @return true if palindrome, false if not
     */
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        int length = chars.length;
        int endIndex = length-1;

        for (int i=0; i < length; i++) {
            if (i == endIndex || (length == 2 && chars[i] == chars[endIndex])) return true;
            if (chars[i] != chars[endIndex]) return false;
            endIndex = endIndex - 1;
        }

        return false;
    }
}