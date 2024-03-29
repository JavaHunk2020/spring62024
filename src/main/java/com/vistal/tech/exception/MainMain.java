package com.vistal.tech.exception;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainMain {
	
	public static void main(String[] args) {
		
		String str="india";
		System.out.println(str.chars().mapToObj(ch->(char)ch).collect(Collectors.groupingBy(c->c,Collectors.counting())));
		int[] arr= {1,2,3,4,5,2,3,6,8,9,4,3};
		Map<Integer, List<Integer>> map=IntStream.range(0, arr.length).boxed().collect(Collectors.groupingBy(x->arr[x]));
		System.out.println(map);
		map=map.entrySet().stream().filter(e->e.getValue().size()>1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println(map);
	}

}
