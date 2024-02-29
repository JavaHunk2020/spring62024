package com.agora;

public class Dog {
	private String name;
	private String color;
	private int age;
	private Bread mybread;

	public Bread getMybread() {
		return mybread;
	}

	public void setMybread(Bread mybread) {
		this.mybread = mybread;
	}

	public void bark() {
		System.out.println("Dog barks at night!");
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", color=" + color + ", age=" + age + ", bread=" + mybread + "]";
	}

	

}
