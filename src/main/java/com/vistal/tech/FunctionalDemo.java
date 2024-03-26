package com.vistal.tech;

@FunctionalInterface
interface FactMagic {
	public abstract int getFact(int num);
}

@FunctionalInterface
interface Runner{
	public abstract String execute(String job);
}



public class FunctionalDemo {
	
	public static void main(String[] args) {
	    //Anonymous class = >> class with out name
		// precondition => you must have either existing class or interface
		Runner runner=new Runner() {
			@Override
			public String execute(String job) {
				return job+"  is runnig now";
			}
		};
		
		owow(runner,"Tring");
		
		//Lambda expression
		//it is compact form of anonymous class based on functional interface
		Runner runner2=(String job) -> {
				return job+"  is runnig now";
			};
		
		Runner runner3=job -> {
				return job+"  is runnig now";
			};
			
    	Runner runner4=job->job+"  is runnig now";
    	
    	owow(job->job+"  is runnig now","Tring");
    	owow(job->job+" makes magic","Tring");
    	String output=runner4.execute("millan");
    	System.out.println(output);
    	
    	
	}
	
	private static void owow(Runner runner,String jobName) {
		String output=runner.execute(jobName);
    	System.out.println(output);
	}
}
