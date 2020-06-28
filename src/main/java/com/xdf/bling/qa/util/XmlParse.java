package com.xdf.bling.qa.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version v1.0
 * @ProjectName: autoTest
 * @ClassName: XmlParse
 * @Description: TODO(一句话描述该类的功能)
 * @Author: liuzhanhui
 * @Date: 2020/6/16 10:57 上午
 */
public class XmlParse {

    private Document getDocument () {
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            InputStream path = XmlParse.class.getResourceAsStream("/data.xml");
            document = saxReader.read(path);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return document;
    }

    public static Map<String, String> getData(String methodName) {
        Map<String, String> result = new HashMap<String, String>();
        XmlParse xmlParse = new XmlParse();
        Document document = xmlParse.getDocument();
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            if (element.getName() == methodName) {
                List<Element> nodeList = element.elements();
                for (Element nodeElement : nodeList) {
                    result.put(nodeElement.getName(), nodeElement.getStringValue());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getData("testLogin"));
    }
}
