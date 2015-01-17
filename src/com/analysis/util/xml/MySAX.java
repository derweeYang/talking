package com.analysis.util.xml;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.*;
import org.xml.sax.XMLReader;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import java.io.IOException;
public class MySAX {
  public static void main( String[] args ) {
    String filename="d://person.xml";//我们要解析的XML文档
    try {
        //通过工厂类得到一个SAXParser实例，实现的方法与Dom有些相似
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxparser = factory.newSAXParser();
        // 初始化reader
        XMLReader reader = saxparser.getXMLReader();
        // 创建ContentHandler的实例
        ContentHandler contentHandler = new MyContentHandler();
        // 在reader中注册实例化的ContentHandler
        reader.setContentHandler( contentHandler );
        // 开始解析文档
        reader.parse(filename);
    } catch ( IOException e ) {
        System.out.println("读入文档出错: " + e.getMessage());
    } catch ( SAXException e ) {
        System.out.println("解析文档出错: " + e.getMessage());
    }catch(ParserConfigurationException ex)
    {
        System.out.println("无法创建分析器: " + ex.getMessage());
    }
  }
}

