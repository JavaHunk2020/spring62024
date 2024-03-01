package com.agora.pk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainMainMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(ServiceConfig.class);
		AgoraService  agoraService=applicationContext.getBean(AgoraService.class);
		agoraService.update();
		
		AgoraService  agoraService2=applicationContext.getBean(AgoraService.class);
		
		if(agoraService==agoraService2) {
			System.out.println("Ahahha these beans are same!");
		}
		
	}
}
