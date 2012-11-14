package com.techiekernel.parser.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxReader {
	public static void main(String argv[]) {
		 
	    try {
	 
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
	 
		DefaultHandler handler = new DefaultHandler() {
	 
		boolean name = false;
		boolean make = false;
		boolean engineCC = false;
		boolean type = false;
	 
		public void startElement(String uri, String localName,String qName, 
	                Attributes attributes) throws SAXException {
	 
			//System.out.println("Start Element :" + qName);
	 
			if (qName.equalsIgnoreCase("name")) {
				name = true;
			}
	 
			if (qName.equalsIgnoreCase("make")) {
				make = true;
			}
	 
			if (qName.equalsIgnoreCase("engine-cc")) {
				engineCC = true;
			}
	 
			if (qName.equalsIgnoreCase("type")) {
				type = true;
			}
	 
		}
	 
		public void endElement(String uri, String localName,
			String qName) throws SAXException {
	 
			//System.out.println("End Element :" + qName);
	 
		}
	 
		public void characters(char ch[], int start, int length) throws SAXException {
	 
			if (name) {
				System.out.println("Name : " + new String(ch, start, length));
				name = false;
			}
	 
			if (make) {
				System.out.println("Make : " + new String(ch, start, length));
				make = false;
			}
	 
			if (engineCC) {
				System.out.println("Engine : " + new String(ch, start, length));
				engineCC = false;
			}
	 
			if (type) {
				System.out.println("Type : " + new String(ch, start, length));
				type = false;
			}
	 
		}
	 
	     };
	 
	       saxParser.parse("product.xml", handler);
	 
	     } catch (Exception e) {
	       e.printStackTrace();
	     }
	 
	   }
}
