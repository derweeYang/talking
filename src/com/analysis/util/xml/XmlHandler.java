package com.analysis.util.xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Comment;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XmlHandler {
	
	public void readContent(String path)
	{
		SAXBuilder builder = new SAXBuilder();
		try {
			Document doc = builder.build(new File(path));
			Element rootE = doc.getRootElement();
			List<Element> list = rootE.getChildren();
			
			for(Element el:list)
			{
				String name = el.getAttributeValue("name");
				String capacity = el.getChildText("capacity");
				String directories = el.getChildText("directories");
				String files = el.getChildText("files");
				
				System.out.println(name);
				
			}
			
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	// create file 
	public boolean createXML(String path)
	{
		boolean flag = false;
		Document doc = new Document();
		Element root = new Element("root");
		doc.addContent(root);
		root.addContent(new Comment("This root comment"));
		
		Element el1 = new Element("element1");
		el1.setAttribute("name","derwee");
		
		root.addC
		
		
		
		return flag;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   String filePath = "com/analysis/util/xml/disk.xml";
		   String file = XmlHandler1.class.getClassLoader().getResource(filePath).getPath();
		   //System.out.println(file);
		   new XmlHandler().readContent(file);

	}

}
