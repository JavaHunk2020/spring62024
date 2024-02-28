package com.agora;

public class MainMainDog {

	public static void main(String[] args) {
		//who is creating dog ? programmer
		Dog dog1=new Dog();
		dog1.setAge(1); //who is setting attribute?  programmer
		dog1.setColor("red");
		dog1.setName("tommy");
		System.out.println(dog1);
		dog1.bark();
		dog1=null;
		System.out.println("Dog is died or not ? yes");
		//System.out.println(dog1.toString());
	}
}
