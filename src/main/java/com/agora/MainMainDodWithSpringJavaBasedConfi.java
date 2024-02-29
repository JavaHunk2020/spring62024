package com.agora;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.agora.seervice.AgoraService;

public class MainMainDodWithSpringJavaBasedConfi {

	public static void main(String[] args) {
		//
		ApplicationContext ap=new AnnotationConfigApplicationContext(DogBreadConfig.class);
		Dog dog=(Dog)ap.getBean("cdog");
		//who is creating dog ? programmer
		System.out.println(dog);
		dog.bark();
		dog=null;
		
		dog=(Dog)ap.getBean("cdog");
		System.out.println("Dog is died or not ? yes");
		System.out.println(dog.toString());
		System.out.println(dog.getMybread());
		/*
		 * Bread bread=(Bread)ap.getBean("bread"); System.out.println(bread);
		 */
		
		AgoraService agoraService=ap.getBean(AgoraService.class);
		agoraService.save();
	}
}
