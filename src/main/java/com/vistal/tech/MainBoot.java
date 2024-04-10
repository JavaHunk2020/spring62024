package com.vistal.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 
 * @author javahunk
 *
 */
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableEurekaClient
public class MainBoot {

	public static void main(String[] magic) {
		SpringApplication.run(MainBoot.class, magic);
	}
}
