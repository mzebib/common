package com.github.mzebib.common.util;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author mzebib
 */
public class XmlParserUtilTest {

    private static final String TAG_NOTE = "note";
    private static final String TAG_HEADING = "heading";
    private static final String TAG_BODY = "body";

    @Test
    public void testParseValidXml()
            throws ParserConfigurationException, SAXException, IOException {

        String sampleXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<note>"
                + "<heading>Sample XML</heading>"
                + "<body>Hello World!</body>"
                + "</note>";

        Document doc = XmlParserUtil.parseXmlToDocument(sampleXML);
        assertNotNull(doc);

        doc.getDocumentElement().normalize();
        String rootNode =  doc.getDocumentElement().getNodeName();

        assertNotNull(rootNode);
        assertEquals(TAG_NOTE, rootNode);

        NodeList nodeList = doc.getElementsByTagName(rootNode);
        assertNotNull(nodeList);
        assertEquals(1, nodeList.getLength());

        String heading = ((Element) nodeList.item(0)).getElementsByTagName(TAG_HEADING).
                item(0).getChildNodes().item(0).getNodeValue();
        heading = heading.trim();

        assertNotNull(heading);
        assertEquals("Sample XML", heading);

        String body = ((Element) nodeList.item(0)).getElementsByTagName(TAG_BODY).
                item(0).getChildNodes().item(0).getNodeValue();
        body = body.trim();

        assertNotNull(body);
        assertEquals("Hello World!", body);
    }

    @Test(expected = SAXParseException.class)
    public void testParseInvalidXml()
            throws ParserConfigurationException, SAXException, IOException {
        XmlParserUtil.parseXmlToDocument("Hello World!");
    }

}
