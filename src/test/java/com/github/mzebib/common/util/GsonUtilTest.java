package com.github.mzebib.common.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GsonUtilTest {

    @Test
    public void testToJson() {
        ConfigInfo configInfo = new ConfigInfo();
        configInfo.setName("Test");
        configInfo.setDescription("This is a test.");
        configInfo.setVersion("1.0");
        configInfo.getConfigParams().put("url", "http://localhost:8080");
        assertNotNull(GsonUtil.toJson(configInfo));
    }

    @Test
    public void testFromJson() {
        String json = "{\n" +
                "  \"name\": \"Test\",\n" +
                "  \"description\": \"This is a test.\",\n" +
                "  \"version\": \"1.0\",\n" +
                "  \"config_params\": {\n" +
                "    \"url\": \"http://localhost:8080\"\n" +
                "  }\n" +
                "}";

        ConfigInfo result = GsonUtil.fromJson(json, ConfigInfo.class);
        assertNotNull(result);
        assertNotNull(result.getName());
        assertEquals("Test", result.getName());
        assertNotNull(result.getDescription());
        assertEquals("This is a test.", result.getDescription());
        assertNotNull(result.getVersion());
        assertEquals("1.0", result.getVersion());
        assertEquals(1, result.getConfigParams().size());
        assertNotNull(result.getConfigParams().get("url"));
        assertEquals("http://localhost:8080", result.getConfigParams().get("url"));
    }

}