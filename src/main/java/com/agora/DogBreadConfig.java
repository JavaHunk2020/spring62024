package com.agora;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("")
public class DogBreadConfig {
	
	
	@Bean("cdog")
	public Dog getDog() {
		Dog dog1=new Dog();
		dog1.setName("Jacky");
		dog1.setColor("white");
		dog1.setAge(3);
		dog1.setMybread(this.getBread());
		return dog1;
	}
	
	@Bean("bread")
	public Bread getBread() {
		Bread bread=new Bread();
		bread.setName("Omaoai");
		bread.setPrice(12);
		return bread;
	}

}
