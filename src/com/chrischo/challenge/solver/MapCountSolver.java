package com.chrischo.challenge.solver;

import java.util.List;
import java.util.Map;

import com.chrischo.challenge.data.ArtistDataManager;
import com.chrischo.challenge.model.ArtistPair;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps;

/**
 * Iterate through each line, populating a Map and count
 * the occurrences of each pair encountered.
 */
public class MapCountSolver extends AbstractSolver {

	@Override
	public void outputSolution(int minOccurrences) {
		List<String> lines = artistDataManager.getLines();

		Map<ArtistPair, Integer> solution = solve(lines, minOccurrences);

		for (ArtistPair ap : solution.keySet()) {
			System.out.println(ap);
		}
	}

	private Map<ArtistPair, Integer> solve(List<String> lines, final int minOccurrences) {
		Map<ArtistPair, Integer> map = Maps.newHashMap();

		for (String line : lines) {
			List<ArtistPair> artistPairs = ArtistDataManager.getPairs(line);

			for (ArtistPair pair : artistPairs) {
				if (map.get(pair) != null) {
					map.put(pair, map.get(pair)+1);
				} else {
					map.put(pair, 1);
				}
			}
		}

		return Maps.filterValues(map, new Predicate<Integer>() {
			@Override 
			public boolean apply(Integer k) {
				return k >= minOccurrences;			
			}   
		});	
	}

}
