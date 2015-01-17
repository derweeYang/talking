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
    String filename="d://person.xml";//����Ҫ������XML�ĵ�
    try {
        //ͨ��������õ�һ��SAXParserʵ����ʵ�ֵķ�����Dom��Щ����
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxparser = factory.newSAXParser();
        // ��ʼ��reader
        XMLReader reader = saxparser.getXMLReader();
        // ����ContentHandler��ʵ��
        ContentHandler contentHandler = new MyContentHandler();
        // ��reader��ע��ʵ������ContentHandler
        reader.setContentHandler( contentHandler );
        // ��ʼ�����ĵ�
        reader.parse(filename);
    } catch ( IOException e ) {
        System.out.println("�����ĵ�����: " + e.getMessage());
    } catch ( SAXException e ) {
        System.out.println("�����ĵ�����: " + e.getMessage());
    }catch(ParserConfigurationException ex)
    {
        System.out.println("�޷�����������: " + ex.getMessage());
    }
  }
}

