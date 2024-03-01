package com.agora;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.agora.seervice")
public class DogBreadConfig {
	
	/**
	 *  <bean id = "cdog" class = "com.agora.Dog">
      <property name = "name" value = "Jacky"/>
      <property name = "color" value = "white"/>
      <property name = "age" value = "3"/>
       <property name = "mybread" ref = "bread"/>
   </bean>
	 * @return
	 */
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
