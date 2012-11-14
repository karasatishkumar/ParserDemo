package com.techiekernel.parser.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JaxbWriter {
	public static void main(String[] args) {

		Products products = new Products();

		List<Product> productList = new ArrayList<Product>();
		Product product = new Product();
		product.setName("R1");
		product.setMake("Yamaha");
		product.setEngine("1000");
		product.setType("sports");

		productList.add(product);

		product = new Product();
		product.setName("GS1200R");
		product.setMake("BMW");
		product.setEngine("1200");
		product.setType("Enduro");

		productList.add(product);
		
		products.setProducts(productList);

		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(products, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
