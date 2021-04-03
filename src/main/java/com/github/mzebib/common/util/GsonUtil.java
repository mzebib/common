package com.github.mzebib.common.util;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author mzebib
 */
public class GsonUtil {

    private static Gson gson;

    static {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        gson = builder.create();
    }

    private GsonUtil() {
    }

    public static Gson createGson() {
        return gson;
    }

    public static String toJson(Object object) {
        CommonUtil.checkIfNulls("Object is null", object);

        return gson.toJson(object);
    }

    public static <V> V fromJson(String json, Class<V> classType) {
        CommonUtil.checkIfNulls("Input json is null", json);
        CommonUtil.checkIfNulls("Class type is null", classType);

        return gson.fromJson(json, classType);
    }

    public static <V> V fromJsonFile(String filePath, Class<V> classType)
            throws FileNotFoundException {
        return fromJsonFile(filePath, classType, null);
    }

    public static <V> V fromJsonFile(String filePath, Class<V> classType, Gson clientGson)
            throws FileNotFoundException {
        CommonUtil.checkIfNulls(".json file path is null", filePath);
        CommonUtil.checkIfNulls("Class type is null", classType);

        Reader reader = new InputStreamReader(new FileInputStream(filePath));

        Gson usedGson = clientGson;
        if (usedGson == null) {
            usedGson = gson;
        }
        return usedGson.fromJson(reader, classType);
    }

    public static void toJsonFile(Object object, String fileName)
            throws IOException {
        toJsonFile(object, fileName, null);
    }

    public static void toJsonFile(Object object, String fileName, Gson clientGson)
            throws IOException {
        CommonUtil.checkIfNulls("Object is null", object);
        CommonUtil.checkIfNulls("File name is null", fileName);

        String json;

        Gson usedGson = clientGson;
        if (usedGson == null) {
            usedGson = gson;
        }
        json = usedGson.toJson(object);

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(json);
        } catch (IOException e) {
            throw e;
        }
    }

    public static <V> V copy(V v) {
        if (v == null) {
            return null;
        }

        return fromJson(toJson(v), (Class<V>) v.getClass());
    }

}