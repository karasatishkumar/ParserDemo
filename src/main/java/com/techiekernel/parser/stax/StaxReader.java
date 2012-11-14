package com.techiekernel.parser.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StaxReader {
	public static void main(String[] args) {
	    try {
	      // First create a new XMLInputFactory
	      XMLInputFactory inputFactory = XMLInputFactory.newInstance();
	      // Setup a new eventReader
	      InputStream in = new FileInputStream("product.xml");
	      XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

	      while (eventReader.hasNext()) {
	        XMLEvent event = eventReader.nextEvent();

	        if (event.isStartElement()) {
	          StartElement startElement = event.asStartElement();
	          // If we have a item element we create a new item
	          if (startElement.getName().getLocalPart() == ("product")) {
	        	  //Do nothing
	        	  System.out.println("Start Product.");
	        	  continue;
	          }

	          if (event.isStartElement()) {
	            if (event.asStartElement().getName().getLocalPart()
	                .equals("name")) {
	              event = eventReader.nextEvent();
	              System.out.println("Name : " + event.asCharacters().getData());
	              continue;
	            }
	          }
	          if (event.asStartElement().getName().getLocalPart()
	              .equals("make")) {
	            event = eventReader.nextEvent();
	            System.out.println("Make : " + event.asCharacters().getData());
	            continue;
	          }

	          if (event.asStartElement().getName().getLocalPart()
	              .equals("engine-cc")) {
	            event = eventReader.nextEvent();
	            System.out.println("Engine : " + event.asCharacters().getData());
	            continue;
	          }

	          if (event.asStartElement().getName().getLocalPart()
	              .equals("type")) {
	            event = eventReader.nextEvent();
	            System.out.println("Type : " + event.asCharacters().getData());
	            continue;
	          }
	        }
	        // If we reach the end of an item element we add it to the list
	        if (event.isEndElement()) {
	          EndElement endElement = event.asEndElement();
	          if (endElement.getName().getLocalPart() == ("product")) {
	            //Nothing to do
	        	System.out.println("End Product.");  
	          }
	        }

	      }
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (XMLStreamException e) {
	      e.printStackTrace();
	    }
	}
}
