package com.vistal.tech;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataStore {
	
	private static Map<String,SignupDTO> map=new ConcurrentHashMap<>();
	
	public static void deleteData(String key) {
		 map.remove(key);
	}
	
	public static Map<String,SignupDTO> getMap(){
		return map;
	}
	
	public static void put(SignupDTO signupDTO) {
		map.put(signupDTO.getUsername(), signupDTO);
	}
	
	public static SignupDTO get(String key) {
		return map.get(key);
	}

}
