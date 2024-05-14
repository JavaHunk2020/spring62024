package com.vistal.tech.service;

import org.springframework.stereotype.Service;

@Service
public class AopMagicService {
	
	public void sec10() throws InterruptedException {
		System.out.println("This starts sec10");
		Thread.sleep(10000);
		System.out.println("This ends sec10");
	}
	
	public void sec2() throws InterruptedException {
		System.out.println("This starts sec100");
		Thread.sleep(200);
		System.out.println("This ends sec100");
	}

}
