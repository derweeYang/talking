package com.analysis.util.xml;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class MyJDOMAPP {
	public static void main(String args[])throws Exception
	 {
	     //得到一个SAXBuilder实例
	     SAXBuilder saxBuilder = new SAXBuilder();
	     //根据文档“addressbookA.xml”构造为一个Document对象
	     Document doc = saxBuilder.build(new FileInputStream("D://addressbookA.xml"));
	     Element root = doc.getRootElement(); //得到Document对象根元素
	     java.util.List persons = root.getChildren(); //得到根元素所有子元素的集合
	     Element person = (Element)persons.get(0); //得到第一个联系人元素
	      //构造一个Attribute对象
	     Attribute attr = new Attribute("性别","男");
	     //将刚构造的属性对象添加到第一本书
	     person.setAttribute(attr);
	     //得到标记名为“Email”的元素
	     Element email = person.getChild("Email");
	      //将邮件地址改为"Steven2005@abc.com"
	     email.setText("Steven2005@abc.com");
	     //将修改后的文件输出到addressbookB.xml
	     String indent = "";
	     boolean newLines = true;
	     Format format = Format.getPrettyFormat();
	     format.setIndent("  ");
	     format.setEncoding("utf-8");
	     XMLOutputter outp = new XMLOutputter(format);
	     //XMLOutputter outp = new XMLOutputter(indent,newLines,"GBK");
	     outp.output(doc, new FileOutputStream("D://addressbookB.xml"));
	}
}
