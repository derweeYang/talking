package com.analysis.util.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;

import org.jdom2.Document;
import org.jdom2.Element;

/**
 * Xml文本读取函数
 * <p>Title:XmlHandler </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company:JRSoft.,Co.Ltd</p>
 * @author zhubing
 * @version 1.0
 */
public class XmlHandler1
{
  private String xmlPath="";
  private Document xmlDoc;
  Element node;
  private String rootName="";
  private int deepth;
  private int deep;
  private String[] nodeNameCollection;
  private String nodeValue;
  private Node nodeElement;
  private String name;
  private String configXml="";

  /**
   * 构造函数
   */
  public XmlHandler1()
  {
  }

  /**
   * 设置XML配置文件的路径
   * @param configXml
   */
  public void setConfigXml(String configXml)
  {
    this.configXml=configXml;
  }

  /**
   * 获得XML配置文件的位置
   * @return
  */
  public String getConfigXml()
  {
    return configXml;
  }

  /**
   * 打开一个XML文档
   * @param XmlPath:XML文档路径
   * @return
  */
  public boolean open(String XmlPath)
  {
    boolean Rtn = false;
    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    try
    {
      factory = DocumentBuilderFactory.newInstance();
      builder = factory.newDocumentBuilder();
      xmlDoc = (Document) builder.parse(XmlPath);
      Rtn = true;
    }
    catch (Exception e)
    {
      Rtn = false;
      debug.printDug("XmlHandler.open is error,this is errormessage="+e.getMessage());
    }
      return Rtn;
  }

  /**
   * 获得根结点
   * @return:获得根节点
  */
  public String getRoot()
  {
    try
    {
      node = xmlDoc.getDocument().getRootElement();
      rootName = node.getName();
      System.out.println(rootName);
    }
    catch (Exception exception)
    {
      debug.printDug("XmlHandler.getRoot is error,this is errormessage="+exception.getMessage());
    }
    return rootName;
  }


  /**
   * 获得单个节点的值
   * @param Tag:标签
   * @return
   */
/*  public String getSingleNodeValue(String Tag)
  {
    String NodeValue = "";
    NodeList NList;
    Element EleNode;
    NodeList TList;
    try
    {
      node = xmlDoc.getRootElement();
      NList = (NodeList) node.getChildren(Tag);
      EleNode = (Element) NList.item(0);
      TList = EleNode.get();
      Node NodeText = TList.item(0);
      NodeValue = NodeText.getNodeValue();
    }
    catch (Exception exception)
    {
      debug.printDug("XmlHandler.getSingleNodeValue is error,this is errormessage="+exception.getMessage());
    }
    return (NodeValue);
  }

    *//**
     * 获得节点的value值
     * @param XPath:节点路径
     * @return
    *//*
   public String getNodeValue(String XPath)
   {
     deepth = 1;
     deep = 0;
     name = "";
     nodeValue = "";
     try
     {
       deep = getCount(XPath);
       if (deep == 1)
       {
         nodeValue = this.getSingleNodeValue(XPath);
       }
       else
       {
         nodeNameCollection = new String[deep];
         for (int i = 0; i < deep; i++)
         {
           nodeNameCollection[i] = getItem(XPath, i + 1);
         }
         node = xmlDoc.getDocumentElement();
         get(node);
       }
     }
     catch (Exception exception)
     {
       debug.printDug("XmlHandler.getNodeValue is error,this is errormessage="+exception.getMessage());
     }
     return (nodeValue);
   }


  private void getName(Node node)
  {
    NodeList nodelist = node.getChildNodes();
    for (int i = 0; i < nodelist.getLength(); i++)
    {
      Node eleNode = nodelist.item(i);
      name = eleNode.getNodeName().trim();
      if ( (deep == deepth + 1) && (name.equals(nodeNameCollection[deepth])))
      {
        nodeElement = eleNode;
        break;
      }
      else
      {
        if (name.equals(nodeNameCollection[deepth]))
        {
          deepth++;
          getName(eleNode);
        }
      }
    }
  }
//------
  	
  //---------


  *//**
   * 获得某个节点所有的属性集合
   * @param XPath:节点路径
   * @return 返回属性名称和value的二维数组
  *//*
  public String[][] getAllAttributes(String XPath)
  {
    deepth = 1;
    deep = 0;
    name = "";
    String[][] str;
    String[][] str1 = new String[1][1];
    try {
      deep = getCount(XPath);
      Node tempNode;
      node = xmlDoc.getDocumentElement();
      if (deep == 1) {
        tempNode = node;
      }
      else {
        nodeNameCollection = new String[deep];
        for (int i = 0; i < deep; i++) {
          nodeNameCollection[i] = getItem(XPath, i + 1);
        }
        getName(node);
        tempNode = nodeElement;
      }
      NamedNodeMap temp = tempNode.getAttributes();
      int i = temp.getLength();
      str = new String[2][i];
      for (int j = 0; j < i; j++) {
        tempNode = temp.item(j);
        str[0][j] = tempNode.getNodeName();
        str[1][j] = tempNode.getNodeValue();
      }
      return str;
    }
    catch (Exception exception) {
      debug.printDug("XmlHandler.getAllAttributes is error,this is errormessage="+exception.getMessage());
      return str1;
    }
}

  public String[] getAttributes(String XPath)
  {
    deepth = 1;
    deep = 0;
    name = "";
    String[] str;
    String[] str1 = new String[1];
    try
    {
      deep = getCount(XPath);
      Node tempNode;
      node = xmlDoc.getDocumentElement();
      if (deep == 1)
      {
        tempNode = node;
      }
      else
      {
        nodeNameCollection = new String[deep];
        for (int i = 0; i < deep; i++)
        {
          nodeNameCollection[i] = getItem(XPath, i + 1);
        }
        getName(node);
        tempNode = nodeElement;
      }
      NamedNodeMap temp = tempNode.getAttributes();
      int i = temp.getLength();
      str = new String[i];
      for (int j = 0; j < i; j++)
      {
        tempNode = temp.item(j);
        str[j] = tempNode.getNodeValue();
      }
      return str;
    }
    catch (Exception exception)
    {
      debug.printDug("XmlHandler.getAttributes is error,this is errormessage="+exception.getMessage());
      return str1;
    }
  }

    *//**
     * 获得某节点的某属性值
     * @param XPath:节点路径
     * @param attName:属性名称
     * @return 指定节点指定标签的属性值
     *//*
    public String getNodeAttribute(String XPath, String attName)
    {
      deepth = 1;
      deep = 0;
      name = "";
      String str = "";
      try
      {
        deep = getCount(XPath);
        Node tempNode;
        node = xmlDoc.getDocumentElement();
        if (deep == 1)
        {
          tempNode = node;
        }
        else
        {
          nodeNameCollection = new String[deep];
          for (int i = 0; i < deep; i++)
          {
            nodeNameCollection[i] = getItem(XPath, i + 1);
//            System.out.print(nodeNameCollection[i]);
          }
          getName(node);
          tempNode = nodeElement;
          
        }
        NamedNodeMap temp = tempNode.getAttributes();
        tempNode = temp.getNamedItem(attName);
        str = tempNode.getNodeValue();
        //NodeList i = tempNode.getChildNodes();
        //System.out.print(i);
      }
      catch (Exception exception)
      {
        debug.printDug("XmlHandler.getNodeAttribute is error,this is errormessage="+exception.getMessage());
      }
      return str;
    }

    private void get(Node node)
    {
      NodeList nodelist = node.getChildNodes();
      for (int i = 0; i < nodelist.getLength(); i++)
      {
        if ( (deep == deepth) &&
            (nodelist.item(i).getNodeValue().trim()).length() != 0)
        {
          nodeValue = nodelist.item(i).getNodeValue();
          break;
        }
        else
        {
          Node eleNode = nodelist.item(i);
          name = eleNode.getNodeName().trim();
          if (name.equals(nodeNameCollection[deepth]))
          {
            deepth++;
            get(eleNode);
          }
        }
      }
    }

    public String getItem(String str, int n)
    {
      int Cnt = 0, i = 0, Len = 0, Loop = 1;
      String CharStr = "", Rtn = "";
      Cnt = getCount(str);
      if(n > Cnt)
      {
        n=Cnt;
      }
      if(n<0)
      {
        n=1;
      }
      if (Cnt == 0)
      {
        return Rtn;
      }
      str = str.trim();
      Len = str.length();
      for (i = 0; i < Len; i++) {
        CharStr = str.substring(i, i + 1);
        if ( (CharStr.compareTo(".") == 0) | (CharStr.compareTo(";") == 0))
          Loop++;
        else
        if (Loop == n) Rtn = Rtn + CharStr;
      }
      return Rtn;
    }

    private int getCount(String str)
    {
      int Cnt=0,i=0,Len=0;
      String CharStr="";

      if (str==null) return 0;
      str=str.trim();
      Len=str.length();
      if (Len==0) return 0;

      for(i=0;i<Len;i++)
      {
            CharStr=str.substring(i,i+1);
            if ((CharStr.compareTo(".")==0)|(CharStr.compareTo(";")==0))
            Cnt++;
      }
      if ((CharStr.compareTo(".")!=0)&(CharStr.compareTo(";")!=0))
            Cnt++;
      return Cnt;
    }

    *//**
     * 关闭已经打开的XML文件
     * @return
     *//*
    public boolean close()
    {
        xmlDoc=null;
        boolean Rtn=true;
        return Rtn;
    }
//---
  

//----


    *//**
     * 获取指定路径下的xml文件中指定节点value值
     * @param XPath:节点路径 example:root.nodea.nodeb
     * @return 节点value值
    *//*
   public String getGlobleValue(String XPath,String NPath)
   {
      deepth = 1;
      deep = 0;
      name = "";
      nodeValue = "";
      boolean result =false;
      result = open(XPath);
      if(!result)
      {
        return nodeValue;
      }
      try {
        deep = getCount(NPath);
        if (deep == 1) {
          nodeValue = this.getSingleNodeValue(NPath);
        }
        else {
          nodeNameCollection = new String[deep];
          for (int i = 0; i < deep; i++) {
            nodeNameCollection[i] = getItem(NPath, i + 1);
          }
          node = xmlDoc.getDocumentElement();
          get(node);
        }
      }
      catch (Exception exception) {
        debug.printDug("XmlHandler.getGlobleValue is error,this is errormessage="+exception.getMessage());
      }
      return nodeValue;
    }*/
   
   //--------
   public static void main(String arg[])
   {
	   //String file = Thread.currentThread().getContextClassLoader().getResource("").toString();
	   String filePath = "com/analysis/util/xml/disk.xml";
	   String file = XmlHandler1.class.getClassLoader().getResource(filePath).getPath();
	   //System.out.println(file);
	   
	   new XmlHandler1().getRoot();
   }
   //------------
}
