package com.github.mzebib.common.util;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class CommonUtilTest {

    @Test
    public void testIsValidClassType() {
        assertTrue(CommonUtil.isValidClassType("Hello World!", String.class));
        assertTrue(CommonUtil.isValidClassType(100, Integer.class));
        assertTrue(CommonUtil.isValidClassType(true, Boolean.class));
        assertTrue(CommonUtil.isValidClassType(99.99, Double.class));
        assertTrue(CommonUtil.isValidClassType(UUID.randomUUID(), UUID.class));

        assertFalse(CommonUtil.isValidClassType(100, String.class));
        assertFalse(CommonUtil.isValidClassType(true, String.class));
    }

    @Test
    public void testIsSameClassType() {
        assertTrue(CommonUtil.isSameClassType(int.class, Integer.class));
        assertTrue(CommonUtil.isSameClassType(long.class, Long.class));
        assertTrue(CommonUtil.isSameClassType(double.class, Double.class));
        assertTrue(CommonUtil.isSameClassType(float.class, Float.class));
        assertTrue(CommonUtil.isSameClassType(boolean.class, Boolean.class));
        assertTrue(CommonUtil.isSameClassType(byte.class, Byte.class));
        assertTrue(CommonUtil.isSameClassType(char.class, Character.class));

        assertFalse(CommonUtil.isSameClassType(int.class, String.class));
        assertFalse(CommonUtil.isSameClassType(Object.class, String.class));
    }

    @Test
    public void testLookupNVPairValue() {
        List<NVPair> list = new ArrayList<>();
        list.add(new NVPair<>("host", "localhost"));
        list.add(new NVPair<>("port", 8080));

        assertNotNull(CommonUtil.lookupValue(list, "host"));
        assertNotNull(CommonUtil.lookupValue(list, "port"));
        assertNull(CommonUtil.lookupValue(list, "name"));
    }

    @Test
    public void testLookupEnumValue() {
        assertEquals(CRUD.CREATE, CommonUtil.lookupEnumValue(CRUD.class, "CREATE"));
        assertNull(CommonUtil.lookupEnumValue(CRUD.class, "create"));
    }


    @Test
    public void testIsValidType() {
        List<String> list = new ArrayList<>();
        list.add("A");
        assertTrue(CommonUtil.isValidType(list, String.class));
        assertFalse(CommonUtil.isValidType(list, Integer.class));
    }

    @Test
    public void testConvertToStringValue() {
        assertEquals("test", CommonUtil.convertToStringValue("test"));
        assertEquals("1000", CommonUtil.convertToStringValue(1000));
        assertEquals("1000000", CommonUtil.convertToStringValue(1000000));
        assertEquals("99.99", CommonUtil.convertToStringValue(99.99));
        assertEquals("1.01", CommonUtil.convertToStringValue(1.01f));
        assertEquals("true", CommonUtil.convertToStringValue(true));

    }

    @Test
    public void testConvertFromStringValue() {
        assertEquals("test", CommonUtil.convertFromStringValue("test", String.class));
        assertEquals(1000, CommonUtil.convertFromStringValue("1000", Integer.class));
        assertEquals(2000, CommonUtil.convertFromStringValue("2000", int.class));
        assertEquals((long) 1000000, CommonUtil.convertFromStringValue("1000000", Long.class));
        assertEquals(99.99, CommonUtil.convertFromStringValue("99.99", Double.class));
        assertEquals((float) 1.01, CommonUtil.convertFromStringValue("1.01f", Float.class));
        assertEquals(true, CommonUtil.convertFromStringValue("true", Boolean.class));
    }

    @Test
    public void testGetMIMEType() throws IOException {
        assertEquals("application/xml", CommonUtil.getMimeType("file://c:/temp/test.xml"));
        assertEquals("application/xml", CommonUtil.getMimeType("file://c:/temp/hibernate.cfg.xml"));
        assertEquals("text/plain", CommonUtil.getMimeType("file://c:/temp/test.txt"));
        assertEquals("application/pdf", CommonUtil.getMimeType("file://c:/temp/test.pdf"));
        assertEquals("image/jpeg", CommonUtil.getMimeType("file://c:/temp/test.jpg"));
        assertEquals("application/zip", CommonUtil.getMimeType("file://c:/temp/test.zip"));
        assertEquals("application/json", CommonUtil.getMimeType("file://c:/temp/test.json"));
        assertEquals("application/octet-stream", CommonUtil.getMimeType("file://c:/temp/test.bin"));
        assertEquals("application/octet-stream", CommonUtil.getMimeType("file://c:/temp/test"));

        assertNotNull(CommonUtil.getMimeType("file://c:/temp/test"));

        Constants.MIMEType type = Constants.MIMEType.lookup(".json");
        assertNotNull(type);
        assertEquals("application/json", type.getName());
    }

    @Test
    public void testFileExtension() {
        String extension = CommonUtil.getFileExtension("hibernate.cfg.xml");
        assertNotNull(extension);
        assertEquals(".xml", extension);

        extension = CommonUtil.getFileExtension("config.json");
        assertNotNull(extension);
        assertEquals(".json", extension);

        extension = CommonUtil.getFileExtension("test.doc");
        assertNotNull(extension);
        assertEquals(".doc", extension);

        extension = CommonUtil.getFileExtension("file://c:/temp/hibernate.cfg.xml");
        assertNotNull(extension);
        assertEquals(".xml", extension);

        extension = CommonUtil.getFileExtension("file://c:/temp/test.xml");
        assertNotNull(extension);
        assertEquals(".xml", extension);

        extension = CommonUtil.getFileExtension("file://c:/temp/config.json");
        assertNotNull(extension);
        assertEquals(".json", extension);

        extension = CommonUtil.getFileExtension("file://c:/temp/test.txt");
        assertNotNull(extension);
        assertEquals(".txt", extension);

        extension = CommonUtil.getFileExtension("file://c:/temp/test.pdf");
        assertNotNull(extension);
        assertEquals(".pdf", extension);

        extension = CommonUtil.getFileExtension("file://c:/temp/test.jpg");
        assertNotNull(extension);
        assertEquals(".jpg", extension);

        extension = CommonUtil.getFileExtension("file://c:/temp/test.zip");
        assertNotNull(extension);
        assertEquals(".zip", extension);


        String fileName = CommonUtil.removeFileExtension("test.zip");
        assertNotNull(fileName);
        assertEquals("test", fileName);

        fileName = CommonUtil.removeFileExtension("file://c:/temp/test.zip");
        assertNotNull(fileName);
        assertEquals("file://c:/temp/test", fileName);
    }

}