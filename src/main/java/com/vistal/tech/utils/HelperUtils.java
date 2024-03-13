package com.vistal.tech.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class HelperUtils {

	static public String generateRandomCode(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuilder codeBuilder = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(characters.length());
			codeBuilder.append(characters.charAt(randomIndex));
		}
		return codeBuilder.toString();
	}
	
	public static String getBaseURI(HttpServletRequest httpServletRequest) {
		StringBuilder builder=new  StringBuilder();
		builder.append("http//:");
		  InetAddress localHost=null;
		try {
			localHost = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		builder.append(localHost.getHostAddress()+":");
		builder.append(httpServletRequest.getServerPort());
		return builder.toString();
	}

}
