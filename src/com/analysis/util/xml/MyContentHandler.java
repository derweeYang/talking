package com.analysis.util.xml;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
public class MyContentHandler implements ContentHandler {
 private StringBuffer buf;
 public void setDocumentLocator( Locator locator ) {    }
 //当开始分析文档时调用此方法
 public void startDocument() throws SAXException {
        buf=new StringBuffer();
        System.out.println("*******开始解析文档*******");
 }
 //当分析器发现文档结束时调用此方法
 public void endDocument() throws SAXException {
        System.out.println("*******解析文档结束*******");
 }
 //遇到元素的起始标记时调用此方法
 public void startElement( String namespaceURI, String localName,
 String fullName, Attributes attributes ) throws SAXException 
{
      System.out.println("\n开始解析元素: " + "["+fullName+"]");
// 打印出元素的属性信息
     for ( int i = 0; i < attributes.getLength(); i++ ) {
        System.out.println("\t属性名称:" + attributes.getLocalName(i)
                + " 属性值:" + attributes.getValue(i));
     }
}
//遇到元素的结束标记时调用此方法
public void endElement( String namespaceURI, String localName,
                          String fullName ) throws SAXException 
{
 //打印出非空的元素内容并将StringBuffer清空
      String nullStr="";
      if (!buf.toString().trim().equals(nullStr)){
           System.out.println("\t内容是: " + buf.toString().trim());
      }
      buf.setLength(0);
//打印元素解析结束信息
     System.out.println("元素: "+"["+fullName+"]"+" 解析结束!");
    }
    public void characters( char[] chars, int start, int length )
                                throws SAXException {
         
 //将元素内容累加到StringBuffer中
          buf.append(chars,start,length);
    }
  /** 除了上面的几个方法以外，在ContentHandler中还有其它的方法需要实现，因为我们的这个例子里不需要这些方法，所以就不在这里给出实现的过程，但是读者在运行该程序时必须要实现这些方法。至于为什么必须实现这些方法，是JAVA中抽象类和接口的知识点，请读者阅读相关书籍。 **/
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

