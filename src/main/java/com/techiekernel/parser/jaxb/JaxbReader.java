package com.techiekernel.parser.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JaxbReader {
	public static void main(String[] args) {

		try {
			File file = new File("product.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Products products = (Products) jaxbUnmarshaller.unmarshal(file);
			System.out.println(products.getProducts());

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
