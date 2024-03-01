package com.agora.pk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
//Since spring 4.3.3
//singleton , prototype , request , session , application
public class AgoraService {
	
	@Autowired
	private SqlService sqlService;
	
	public void update() {
		System.out.println("Updating agora service!!!!");
		System.out.println("_____________________________");
		sqlService.load();
	}

}
