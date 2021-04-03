package com.github.mzebib.common.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author mzebib
 */
public class IOUtil {

    private static final int DEFAULT_BUFFER_SIZE = 4096;

    private IOUtil() {
    }

    public static byte[] toBytes(InputStream is) throws IOException {
        return toBytes(is, -1, true);
    }

    public static byte[] toBytes(InputStream is, long maxBytesAllowed, boolean close) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];

        baos.toByteArray();

        try {
            int bytesRead;
            long totalBytes = 0;

            while((bytesRead = is.read(buffer)) != -1) {
                totalBytes = totalBytes + bytesRead;

                if (maxBytesAllowed > 0 && totalBytes > maxBytesAllowed) {
                    throw new IOException("Length exceeds max bytes allowed (" + maxBytesAllowed + " bytes)");
                }

                baos.write(buffer, 0, bytesRead);
            }
        } finally {
            if (close) {
                close(is);
            }
        }

        return baos.toByteArray();
    }

    public static String toString(String filename) throws IOException {
        return toString(new FileInputStream(filename), true);
    }

    public static String toString(InputStream is, boolean close) throws IOException {
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        StringBuilder sb = new StringBuilder();
        int read;

        while ((read = is.read(buffer, 0, buffer.length)) > 0) {
            sb.append(new String(buffer, 0, read, Constants.UTF_8));
        }

        if (close) {
            close(is);
        }

        return sb.toString();
    }

    public static void writeToFile(File file, byte[] bytes) throws IOException {
        writeToFile(file, bytes, true);
    }

    public static void writeToFile(File file, byte[] bytes, boolean close) throws IOException {
        write(new FileOutputStream(file), bytes, close);
    }

    public static void write(OutputStream os, byte[] bytes) throws IOException {
        write(os, bytes, true);
    }

    public static void write(OutputStream os, byte[] bytes, boolean close) throws IOException {
        if (os != null && bytes != null) {
            try {
                os.write(bytes);
            } finally {
                if (close) {
                    close(os);
                }
            }
        }
    }

    public static void close(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (Exception e) {

            }
        }
    }
}