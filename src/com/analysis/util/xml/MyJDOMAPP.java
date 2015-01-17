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
	     //�õ�һ��SAXBuilderʵ��
	     SAXBuilder saxBuilder = new SAXBuilder();
	     //�����ĵ���addressbookA.xml������Ϊһ��Document����
	     Document doc = saxBuilder.build(new FileInputStream("D://addressbookA.xml"));
	     Element root = doc.getRootElement(); //�õ�Document�����Ԫ��
	     java.util.List persons = root.getChildren(); //�õ���Ԫ��������Ԫ�صļ���
	     Element person = (Element)persons.get(0); //�õ���һ����ϵ��Ԫ��
	      //����һ��Attribute����
	     Attribute attr = new Attribute("�Ա�","��");
	     //���չ�������Զ�����ӵ���һ����
	     person.setAttribute(attr);
	     //�õ������Ϊ��Email����Ԫ��
	     Element email = person.getChild("Email");
	      //���ʼ���ַ��Ϊ"Steven2005@abc.com"
	     email.setText("Steven2005@abc.com");
	     //���޸ĺ���ļ������addressbookB.xml
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
