package com.agora;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainMainDodWithSpring {

	public static void main(String[] args) {
		//
		ApplicationContext ap=new ClassPathXmlApplicationContext("dogs.xml");
		Dog dog=(Dog)ap.getBean("cdog");
		//who is creating dog ? programmer
		System.out.println(dog);
		dog.bark();
		dog=null;
		
		dog=(Dog)ap.getBean("cdog");
		System.out.println("Dog is died or not ? yes");
		System.out.println(dog.toString());
	}
}
