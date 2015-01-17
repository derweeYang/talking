package com.analysis.util.xml;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
public class MyContentHandler implements ContentHandler {
 private StringBuffer buf;
 public void setDocumentLocator( Locator locator ) {    }
 //����ʼ�����ĵ�ʱ���ô˷���
 public void startDocument() throws SAXException {
        buf=new StringBuffer();
        System.out.println("*******��ʼ�����ĵ�*******");
 }
 //�������������ĵ�����ʱ���ô˷���
 public void endDocument() throws SAXException {
        System.out.println("*******�����ĵ�����*******");
 }
 //����Ԫ�ص���ʼ���ʱ���ô˷���
 public void startElement( String namespaceURI, String localName,
 String fullName, Attributes attributes ) throws SAXException 
{
      System.out.println("\n��ʼ����Ԫ��: " + "["+fullName+"]");
// ��ӡ��Ԫ�ص�������Ϣ
     for ( int i = 0; i < attributes.getLength(); i++ ) {
        System.out.println("\t��������:" + attributes.getLocalName(i)
                + " ����ֵ:" + attributes.getValue(i));
     }
}
//����Ԫ�صĽ������ʱ���ô˷���
public void endElement( String namespaceURI, String localName,
                          String fullName ) throws SAXException 
{
 //��ӡ���ǿյ�Ԫ�����ݲ���StringBuffer���
      String nullStr="";
      if (!buf.toString().trim().equals(nullStr)){
           System.out.println("\t������: " + buf.toString().trim());
      }
      buf.setLength(0);
//��ӡԪ�ؽ���������Ϣ
     System.out.println("Ԫ��: "+"["+fullName+"]"+" ��������!");
    }
    public void characters( char[] chars, int start, int length )
                                throws SAXException {
         
 //��Ԫ�������ۼӵ�StringBuffer��
          buf.append(chars,start,length);
    }
  /** ��������ļ����������⣬��ContentHandler�л��������ķ�����Ҫʵ�֣���Ϊ���ǵ���������ﲻ��Ҫ��Щ���������ԾͲ����������ʵ�ֵĹ��̣����Ƕ��������иó���ʱ����Ҫʵ����Щ����������Ϊʲô����ʵ����Щ��������JAVA�г�����ͽӿڵ�֪ʶ�㣬������Ķ�����鼮�� **/
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub
		
	}
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		
	}
	public void processingInstruction(String target, String data) throws SAXException {
		// TODO Auto-generated method stub
		
	}
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub
		
	}
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		// TODO Auto-generated method stub
		
	}
}

