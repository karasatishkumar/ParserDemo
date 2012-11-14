package com.techiekernel.parser.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Products {
	List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	@XmlElement(name="product")
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Products [products=" + products + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
