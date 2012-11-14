package com.techiekernel.parser.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomReader {
	public static void main(String argv[]) {
		 
		  try {
	 
			File fXmlFile = new File("product.xml");
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
	 
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("product");
			
			System.out.println("-----------------------");
	 
			for (int temp = 0; temp < nList.getLength(); temp++) {
	 
			   Node nNode = nList.item(temp);
			   if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
			      Element eElement = (Element) nNode;
	 
			      System.out.println("Name : " + getTagValue("name", eElement));
			      System.out.println("Make : " + getTagValue("make", eElement));
		          System.out.println("Engine CC : " + getTagValue("engine-cc", eElement));
			      System.out.println("Type : " + getTagValue("type", eElement));
	 
			   }
			}
		  } catch (Exception e) {
			e.printStackTrace();
		  }
	  }
	 
	  private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
	 
	        Node nValue = (Node) nlList.item(0);
	 
		return nValue.getNodeValue();
	  }
}
