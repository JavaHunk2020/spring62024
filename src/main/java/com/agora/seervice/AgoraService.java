package com.agora.seervice;

import org.springframework.stereotype.Component;

//<bean id="agoraService"  class="com.agora.AgoraService"
//@Respository , @Controller, @Component
//@Service("chilliService")
@Component
public class AgoraService {
	
	public void save() {
		System.out.println("calling agora service save method");
	}

}
