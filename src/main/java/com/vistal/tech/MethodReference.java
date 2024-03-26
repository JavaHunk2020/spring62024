package com.vistal.tech;

import java.util.function.Function;

public class MethodReference {

	public static void main(String[] args) {
		// String::length;
		Function<String, Integer> cool = new Function<String, Integer>() {
			public Integer apply(String t) {
				return t.length();
			}
		};

		Function<String, Integer> cool2 = (String t) -> {
			return t.length();
		};

		Function<String, Integer> cool3 = t -> t.length();
		int len=cool3.apply("Krishna");
		System.out.println(len);
		
		//in Lambda - > method definition => we have one statement
		// this is a method invocation
		Function<String, Integer> cool4 = t -> t.length();
		
		Function<String, Integer> cool5 = String::length; //METHOD REFERENCE IN CORE JAVA
		len=cool5.apply("Ravi");
		System.out.println(len);
	}
}
