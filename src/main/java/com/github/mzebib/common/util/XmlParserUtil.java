package com.github.mzebib.common.util;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

/**
 * @author mzebib
 */
public class XmlParserUtil {

    private XmlParserUtil() {
    }

    public static Document parseXmlToDocument(String xml)
            throws IOException, SAXException, ParserConfigurationException {
        CommonUtil.checkIfNulls("Input XML is null", xml);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));

        return db.parse(is);
    }

}