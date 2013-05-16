package com.chrischo.challenge.solver;

import com.chrischo.challenge.data.ArtistDataManager;

/**
 * Just in case I have time for other solutions.
 */
public abstract class AbstractSolver {
	ArtistDataManager artistDataManager;
	
	public void initData(String filePath) throws Exception {
		artistDataManager = new ArtistDataManager();
		artistDataManager.loadFile(filePath);
	}
	
	public abstract void outputSolution(int k);
	
}
