package com.techiekernel.parser.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	String name;
	String make;
	String engine;
	String type;
	
	public String getName() {
		return name;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMake() {
		return make;
	}
	
	@XmlElement
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getEngine() {
		return engine;
	}
	
	@XmlElement(name="engine-cc")
	public void setEngine(String engine) {
		this.engine = engine;
	}
	
	public String getType() {
		return type;
	}
	
	@XmlElement
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", make=" + make + ", engine="
				+ engine + ", type=" + type + ", toString()="
				+ super.toString() + "]";
	}
}
