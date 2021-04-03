package com.github.mzebib.common.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Contains common utility methods.
 */
public final class CommonUtil {

    private CommonUtil() {
    }

    /**
     * Checks for null objects. If any of them is null, throws NullPointerException.
     * @param msg message
     * @param objects objects to be checked
     * @throws NullPointerException
     */
    public static void checkIfNulls(String msg, Object... objects)
            throws NullPointerException {

        if (msg == null) {
            throw new NullPointerException();
        }

        if (objects == null) {
            throw new NullPointerException(msg);
        }

        for (Object o : objects) {
            if (o == null) {
                throw new NullPointerException(msg);
            }
        }
    }

    /**
     * Checks if object class type is valid.
     * Example:
     * - Given value is 100 and type is Integer.class then returns true
     * - Given value is 100 and type is String.class then returns false
     * @param value
     * @param classTypes
     * @return
     */
    public static boolean isValidClassType(Object value, Class<?>... classTypes) {
        if (value != null && classTypes != null) {
            for (Class<?> classType : classTypes) {
                if (value.getClass().isAssignableFrom(classType)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Checks if given classes are of the same type.
     * @param class1
     * @param class2
     * @return
     */
    public static boolean isSameClassType(Class class1, Class class2) {
        if (class1 != null && class2 != null) {
            if (class1 == class2) {
                return true;
            }

            if (((class1 == int.class || class1 == Integer.class) && (class2 == int.class || class2 == Integer.class))
                    || ((class1 == long.class || class1 == Long.class) && (class2 == long.class || class2 == Long.class))
                    || ((class1 == double.class || class1 == Double.class) && (class2 == double.class || class2 == Double.class))
                    || ((class1 == float.class || class1 == Float.class) && (class2 == float.class || class2 == Float.class))
                    || ((class1 == boolean.class || class1 == Boolean.class) && (class2 == boolean.class || class2 == Boolean.class))
                    || ((class1 == byte.class || class1 == Byte.class) && (class2 == byte.class || class2 == Byte.class))
                    || ((class1 == char.class || class1 == Character.class) && (class2 == char.class || class2 == Character.class))) {
                return true;
            }
        }

        return false;
    }

    /**
     * Converts the given value to the actual enum value (mapped to enum.name()).
     * @param enumClass
     * @param value
     * @return
     */
    public static Enum lookupEnumValue(Class<? extends Enum> enumClass, String value) {
        if (value != null) {
            Enum<?>[] enums = (Enum<?>[]) enumClass.getEnumConstants();

            for (int i=0; i < enums.length; i++) {
                if (enums[i].name().equals(value)) {
                    return enums[i];
                }
            }
        }

        return null;
    }

    /**
     * Checks the list type based on given class.
     * Returns true if given class is of the list's object class, otherwise returns false.
     * @param list
     * @param classToCheck
     * @return
     */
    public static boolean isValidType(List<?> list, Class<?> classToCheck) {
        if (list != null && !list.isEmpty() && classToCheck != null) {
            for (Object obj : list) {
                if (obj.getClass() == classToCheck
                        || classToCheck.isAssignableFrom(obj.getClass())) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Looks up NVPair value in list based on given name.
     * @param list
     * @param name
     * @return
     */
    public static <V> V lookupValue(List<NVPair> list, String name) {
        V ret = null;

        if (list != null && !list.isEmpty() && !StringUtil.isEmpty(name)) {
            for (NVPair nvp : list) {
                if (nvp.getName().equals(name)) {
                    ret = (V) nvp.getValue();
                    break;
                }
            }
        }

        return ret;
    }

    /**
     * Converts the given object to String representation. Supported object class types that can be
     * converted to String include:
     * - int.class and Integer.class
     * - long.class and Long.class
     * - double.class and Double.class
     * - float.class and Float.class
     * - boolean.class and Boolean.class
     *
     * @param object the object to converted
     * @return converted string value
     */
    public static String convertToStringValue(Object object) {
        if (object != null) {
            Class<?> classType = object.getClass();

            if (classType == String.class) {
                return (String) object;
            } else if ((classType == int.class || classType == Integer.class) ||
                    (classType == long.class || classType == Long.class) ||
                    (classType == double.class || classType == Double.class) ||
                    (classType == float.class || classType == Float.class) ||
                    (classType == boolean.class || classType == Boolean.class)) {
                return String.valueOf(object);
            } else {
                throw new IllegalArgumentException("Cannot convert to String for given class type: " + classType);
            }
        }

        return null;
    }

    /**
     * Converts the given String to value of specified class type. Supported object class types that can be
     * converted from String include:
     * - int.class and Integer.class
     * - long.class and Long.class
     * - double.class and Double.class
     * - float.class and Float.class
     * - boolean.class and Boolean.class
     *
     * @param str the string to be converted
     * @param classType the class type to convert to
     * @return converted value based on class type
     */
    public static Object convertFromStringValue(String str, Class<?> classType) {
        return convertFromStringValue(str, classType.getName());
    }

    /**
     * Converts the given String to value of specified class type. Supported object class types that can be
     * converted from String include:
     * - int.class and Integer.class
     * - long.class and Long.class
     * - double.class and Double.class
     * - float.class and Float.class
     * - boolean.class and Boolean.class
     *
     * @param str the string to be converted
     * @param className the class name to convert to
     * @return converted value based on class type
     */
    public static Object convertFromStringValue(String str, String className) {
        if (str != null && className != null) {
            if (className.equals(String.class.getName())) {
                return str;
            } else if (className.equals(int.class.getName()) || className.equals(Integer.class.getName())) {
                return Integer.valueOf(str);
            } else if (className.equals(long.class.getName()) || className.equals(Long.class.getName())) {
                return Long.valueOf(str);
            } else if (className.equals(double.class.getName()) || className.equals(Double.class.getName())) {
                return Double.valueOf(str);
            } else if (className.equals(float.class.getName()) || className.equals(Float.class.getName())) {
                return Float.valueOf(str);
            } else if (className.equals(boolean.class.getName()) || className.equals(Boolean.class.getName())) {
                return Boolean.valueOf(str);
            } else {
                throw new IllegalArgumentException("Cannot convert String to given class type: " + className);
            }
        }

        return null;
    }

    /**
     * Formats given values into String format based name-value separator and the separator between each name-value pair.
     * @param map
     * @param nameValueSeparator
     * @param nvpSeparator
     * @return
     */
    public static <V> String format(Map<String, V> map, String nameValueSeparator, String nvpSeparator) {

        if (map != null) {
            List<NVPair> list = new ArrayList<>();

            for (Map.Entry entry : map.entrySet()) {
                list.add(new NVPair((String) entry.getKey(), entry.getValue()));
            }

            return format(list, nameValueSeparator, nvpSeparator);
        }

        return null;
    }

    /**
     * Formats given list of NVPair into String format based on the name-value separator and the separator
     * between each NVPair.
     * Example:
     * (1) Parameters: list = {NVPair("name", "John"), NVPair("year", 2016)}, nameValueSeparator = "=",
     *  nvpSeparator = ","  Returns: "name=John, year=2016"
     *
     * @param list
     * @param nameValueSeparator
     * @param nvpSeparator
     * @return
     */
    public static String format(List<NVPair> list, String nameValueSeparator, String nvpSeparator) {
        StringBuilder sb = new StringBuilder();

        if (!list.isEmpty())
            for (int i = 0; i < list.size(); i++) {
                sb.append(StringUtil.format(list.get(i).getName(), list.get(i).getValue(), nameValueSeparator));

                if (!list.isEmpty() && i != list.size() - 1) {
                    if (nvpSeparator != null) {
                        sb.append(nvpSeparator);
                    } else {
                        sb.append(",");
                    }
                }
            }

        return sb.toString();
    }

    /**
     *
     * @param list
     * @param separator
     * @return
     */
    public static String toString(List<?> list, String separator) {
        return toString(list.toArray(new Object[0]), separator);
    }

    /**
     * Converts objects array to string representation.
     * @param objects
     * @param separator
     * @return
     */
    public static String toString(Object[] objects, String separator) {
        if (objects != null && separator != null) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < objects.length; i++) {
                sb.append(objects[i]);

                if (i + 1 != objects.length) {
                    sb.append(separator);
                }
            }

            return sb.toString();
        }

        return null;
    }

    /**
     * Converts NVPair list to string representation based on the name-value separator and the NVPair separator.
     * Example:
     * (1) Parameters: nvParis = {NVPair("name", "John"), NVPair("year", 2016)}, nameValueSeparator = ":", nvpSeparator = ", "
     *     Returns: "name:John, year:2016"
     *
     * @param list
     * @param nameValueSeparator
     * @param nvpSeparator
     * @return
     */
    public static String toString(List<NVPair> list, String nameValueSeparator, String nvpSeparator) {
        return toString(list.toArray(new NVPair[0]), nameValueSeparator, nvpSeparator);
    }

    /**
     * Converts NVPair list to string representation based on the name-value separator and the NVPair separator.
     * Example:
     * (1) Parameters: nvParis = {NVPair("name", "John"), NVPair("year", 2016)}, nameValueSeparator = ":", nvpSeparator = ", "
     *     Returns: "name:John, year:2016"
     * @param nvPairs
     * @param nameValueSeparator
     * @param nvpSeparator
     * @return
     */
    public static String toString(NVPair[] nvPairs, String nameValueSeparator, String nvpSeparator) {
        if (nvPairs != null && nameValueSeparator != null && nvpSeparator != null) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < nvPairs.length; i++) {
                String name = nvPairs[i].getName();
                Object value = nvPairs[i].getValue();

                sb.append(name);
                sb.append(nameValueSeparator);
                sb.append(value);

                if (i + 1 != nvPairs.length) {
                    sb.append(nvpSeparator);
                }
            }

            return sb.toString();
        }

        return null;
    }

    /**
     * Returns the MIME type for the specified file name.
     * @param fileName the file name
     * @return MIME type for the file name if found, otherwise null
     * @throws IOException
     */
    public static String getMimeType(String fileName)
            throws IOException {

        String ret = null;

        if (fileName != null) {
            FileNameMap fileNameMap = URLConnection.getFileNameMap();

            if (fileNameMap != null) {
                ret = fileNameMap.getContentTypeFor(fileName);
            }

            if (ret == null) {
                Constants.MIMEType mimeType = Constants.MIMEType.lookup(getFileExtension(fileName));

                if (mimeType != null) {
                    ret = mimeType.getName();
                }
            }
        }

        return ret;
    }


    /**
     * Returns the extension for the given file name.
     * Example: config.json returns .json
     * @param fileName
     * @return
     */
    public static String getFileExtension(String fileName) {
        if (fileName != null) {
            int index = fileName.lastIndexOf('.');

            if (index >= 0) {
                return fileName.substring(index);
            }
        }

        return null;
    }

    public static String removeFileExtension(String fileName) {
        if (fileName != null) {
            int index = fileName.lastIndexOf('.');

            if (index >= 0) {
                return fileName.substring(0, index);
            } else {
                return fileName;
            }
        }

        return null;
    }

    /**
     * Return the index of the first occurrence of match[] in buffer[]
     * @param buffer
     * @param match
     * @return index of the match, -1 if no match found
     */
    public static int indexOf(byte[] buffer, byte[] match) {
        return indexOf(buffer, 0, buffer.length, match, 0, match.length);
    }

    public static int indexOf(byte[] buffer, int bufferStartIndex, int bufferEndIndex, byte[] match, int matchOffset, int matchLen) {
        if (matchOffset < 0 || matchLen < 1 || (matchOffset+matchLen) > match.length || bufferEndIndex > buffer.length) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = bufferStartIndex; i < bufferEndIndex; i++) {
            int j = 0;

            for ( ; j < matchLen && j+i < bufferEndIndex; j++) {
                if (buffer[i + j] != match[matchOffset + j]) {
                    break;
                }
            }

            if (j == matchLen) {
                return i;
            }
        }

        return -1;
    }

    public static int indexOf(byte[] buffer, String str) {
        return indexOf(buffer, 0, buffer.length, str, 0, str.length(), false);
    }

    public static int indexOf(byte[] buffer, int bufferStartIndex, int bufferEndIndex, CharSequence cs, int csOffset, int csLen, boolean ignoreCase) {
        if (csOffset < 0 || csLen < 1 || (csOffset+csLen) > cs.length()  || bufferEndIndex > buffer.length) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = bufferStartIndex; i < bufferEndIndex; i++) {
            int j = 0;

            for (; j < csLen && j+i < bufferEndIndex; j++) {
                if (ignoreCase) {
                    if ((buffer[i + j] != Character.toUpperCase(cs.charAt(csOffset + j)) && buffer[i + j] != Character.toLowerCase(cs.charAt(csOffset + j)))) {
                        break;
                    }
                } else if (buffer[i + j] != cs.charAt(csOffset + j)) {
                    break;
                }
            }

            if (j == csLen) {
                return i;
            }
        }

        return -1;
    }

    public static Properties toProperties(String propertiesFile)
            throws IOException {
        return toProperties(new FileInputStream(propertiesFile));
    }

    public static Properties toProperties(InputStream is)
            throws IOException {
        Properties properties = new Properties();

        try {
            properties.load(is);
        } finally {
            IOUtil.close(is);
        }

        return properties;
    }

}