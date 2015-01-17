package com.analysis.util.xml;

/**
 * XML的读写操作Bean
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Vector;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


//--
public class XmlBean {
 private String bookname, author, pub, price, pubdate;

 public String getbookname() {
  return bookname;
 }

 public String getauthor() {
  return author;
 }

 public String getpub() {
  return pub;
 }

 public String getprice() {
  return price;
 }

 public String getpubdate() {
  return pubdate;
 }

 public void setbookname(String bookname) {
  this.bookname = bookname;
 }

 public void setauthor(String author) {
  this.author = author;
 }

 public void setpub(String pub) {
  this.pub = pub;
 }

 public void setprice(String price) {
  this.price = price;
 }

 public void setpubdate(String pubdate) {
  this.pubdate = pubdate;
 }

 public XmlBean() {
 }

 /**
  * 读取XML文件所有信息
  */
 public Vector LoadXML(String path) throws Exception {
  Vector xmlVector = null;
  FileInputStream fi = null;
  System.out.print(path);
  try {
   fi = new FileInputStream(path);
   xmlVector = new Vector();
   SAXBuilder sb = new SAXBuilder();
   Document doc = sb.build(fi);
   Element root = doc.getRootElement(); // 得到根元素
   List books = root.getChildren(); // 得到根元素所有子元素的集合
   Element book = null;
   XmlBean xml = null;
   for (int i = 0; i < books.size(); i++) {
    xml = new XmlBean();
    
    book = (Element) books.get(i); // 得到第一本书元素
    xml.setbookname(book.getChild("bookname").getText());
    xml.setauthor(book.getChild("author").getText());
    xml.setpub(book.getChild("pub").getText());
    xml.setprice(book.getChild("price").getText());
    xml.setpubdate(book.getChild("pubdate").getText());
    xmlVector.add(xml);
   }
  } catch (Exception e) {
   System.err.println(e + "error");
  } finally {
   try {
    fi.close();
   } catch (Exception e) {
    e.printStackTrace();
   }
  }
  return xmlVector;
 }

 /**
  * 删除XML文件指定信息
  */
 public static void DelXML(HttpServletRequest request) throws Exception {
  FileInputStream fi = null;
  FileOutputStream fo = null;
  try {
   request.setCharacterEncoding("GBK");
   String path = request.getParameter("path");
   int xmlid = Integer.parseInt(request.getParameter("id"));
   fi = new FileInputStream(path);
   SAXBuilder sb = new SAXBuilder();
   Document doc = sb.build(fi);
   Element root = doc.getRootElement(); // 得到根元素
   List books = root.getChildren(); // 得到根元素所有子元素的集合
   books.remove(xmlid);// 删除指定位置的子元素
      Format format = Format.getPrettyFormat();
      format.setIndent("  ");
      format.setEncoding("utf-8");
      XMLOutputter outp = new XMLOutputter(format);
   fo = new FileOutputStream(path);
   outp.output(doc, fo);
  } catch (Exception e) {
   System.err.println(e + "error");
  } finally {
   try {
    fi.close();
    fo.close();
   } catch (Exception e) {
    e.printStackTrace();
   }
  }
 }

 /**
  * 添加XML文件指定信息
  */
 public static void AddXML(HttpServletRequest request) throws Exception {
  FileInputStream fi = null;
  FileOutputStream fo = null;
  try {
   request.setCharacterEncoding("gb2312");
   String path = request.getParameter("path");
   fi = new FileInputStream(path);
   SAXBuilder sb = new SAXBuilder();
   Document doc = sb.build(fi);
   Element root = doc.getRootElement(); // 得到根元素
   List books = root.getChildren(); // 得到根元素所有子元素的集合
   String bookname = request.getParameter("bookname");
   System.out.print("bookname=="+bookname);
   String author = request.getParameter("author");
   String price = request.getParameter("price");
   String pub = request.getParameter("pub");
   String pubdate = request.getParameter("pubdate");
//   Text newtext;
   Element newbook = new Element("book");

   Element newname = new Element("bookname");
   newname.setText(bookname);
   newbook.addContent(newname);
   Element newauthor = new Element("author");
   newauthor.setText(author);
   newbook.addContent(newauthor);
   Element newpub = new Element("pub");
   newpub.setText(pub);
   newbook.addContent(newpub);
   Element newprice = new Element("price");
   newprice.setText(price);
   newbook.addContent(newprice);
   Element newdate = new Element("pubdate");
   newdate.setText(pubdate);
   newbook.addContent(newdate);
   books.add(newbook);// 增加子元素
      Format format = Format.getPrettyFormat();
      format.setIndent("  ");
      format.setEncoding("utf-8");
      XMLOutputter outp = new XMLOutputter(format);
   fo = new FileOutputStream(path);
   outp.output(doc, fo);
  } catch (Exception e) {
   System.err.println(e + "error");
  } finally {
   try {
    fi.close();
    fo.close();
   } catch (Exception e) {
    e.printStackTrace();
   }
  }
 }

 /**
  * 修改XML文件指定信息
  */
 public static void EditXML(HttpServletRequest request) throws Exception {
  FileInputStream fi = null;
  FileOutputStream fo = null;
  try {
   request.setCharacterEncoding("GBK");
   String path = request.getParameter("path");
   int xmlid = Integer.parseInt(request.getParameter("id"));
   fi = new FileInputStream(path);
   SAXBuilder sb = new SAXBuilder();
   Document doc = sb.build(fi);
   Element root = doc.getRootElement(); // 得到根元素
   List books = root.getChildren(); // 得到根元素所有子元素的集合
   Element book = (Element) books.get(xmlid);
   String bookname = request.getParameter("bookname");
   String author = request.getParameter("author");
   String price = request.getParameter("price");
   String pub = request.getParameter("pub");
   String pubdate = request.getParameter("pubdate");
   if(bookname!=null&&!"".equals(bookname))
   {
   Element newname = book.getChild("bookname");
   newname.setText(bookname);// 修改书名为新的书名
   }
   if(author!=null&&!"".equals(author))
   {
   Element newauthor = book.getChild("author");
   newauthor.setText(author);
   }
   if(pub!=null&&!"".equals(pub))
   {
   Element newpub = book.getChild("pub");
   newpub.setText(pub);
   }
   if(price!=null&&!"".equals(price))
   {
   Element newprice = book.getChild("price");
   newprice.setText(price);
   }
   if(pubdate!=null&&!"".equals(pubdate))
   {
   Element newdate = book.getChild("pubdate");
   newdate.setText(pubdate);
   }
   Format format = Format.getPrettyFormat();
      format.setIndent("  ");
      format.setEncoding("utf-8");
      XMLOutputter outp = new XMLOutputter(format);
   fo = new FileOutputStream(path);
   outp.output(doc, fo);
  } catch (Exception e) {
   System.err.println(e + "error");
  } finally {
   try {
    fi.close();
    fo.close();
   } catch (Exception e) {
    e.printStackTrace();
   }
  }
 }
//---
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