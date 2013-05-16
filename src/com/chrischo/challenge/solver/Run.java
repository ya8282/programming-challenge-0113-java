package com.chrischo.challenge.solver;


public class Run {
	
	public static void main(String[] args) throws Exception {
		String path = args[0];
		final Integer minOccurrences = Integer.parseInt(args[1]);
		//TODO: add validation and usage statement
		
		MapCountSolver mcs = new MapCountSolver();
		mcs.initData(path);
		mcs.outputSolution(minOccurrences);
	}

}
