package com.vistal.tech;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ForEachDemo {
	
	public static void main(String[] args) {
		List<String> list =new ArrayList<>();
		list.add("Apple");
		list.add("Banana");
		list.add("Mango");
		
		Consumer<String> consumer=new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		list.forEach(consumer);
		
		
		list.forEach(System.out::println);
		
		
		
		list.forEach((String t) -> {
				System.out.println(t);
			});
		
		list.forEach(t -> {
			System.out.println(t);
		});
		
		list.forEach(t -> System.out.println(t));
		
		list.forEach(System.out::println);
		
	}

}
