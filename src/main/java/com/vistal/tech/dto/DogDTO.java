package com.vistal.tech.dto;

public class DogDTO {
	String name;
	String color;
	int did;
	
	public DogDTO() {}

	public DogDTO(String name, String color, int did) {
		super();
		this.name = name;
		this.color = color;
		this.did = did;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	@Override
	public String toString() {
		return "DogDTO [name=" + name + ", color=" + color + ", did=" + did + "]";
	}

}
