package com.chrischo.challenge.data;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import com.chrischo.challenge.model.ArtistPair;
import com.google.common.collect.Lists;

public class ArtistDataManager {
	public static final String CHAR_ENC = "UTF-8";
	private List<String> lines = Lists.newArrayList();
	
	/**
	 * Read in UTF-8 file line-by-line (allows for future expansion
	 * of problem and horizontally-scaling alternative solutions)
	 * @param filePath is the path of the file
	 * @throws IOException
	 */
	public void loadFile(String filePath) throws IOException {
		File file = new File(filePath);
		LineIterator it = FileUtils.lineIterator(file, CHAR_ENC);
		try {
			while (it.hasNext()) {
				lines.add(new String(it.nextLine().getBytes(CHAR_ENC)));
			}
		} finally {
			LineIterator.closeQuietly(it);
		}
	}

	public List<String> getLines() {
		return lines;
	}
	
	/**
	 * Tokenize the comma-separated list and then generate all
	 * combinations.
	 * @param line
	 * @return list of all ArtistPair elements for the line 
	 * @see ArtistPair
	 */
	public static List<ArtistPair> getPairs(String line) {
		List<String> sortedTokens = getAlphabetizedArtists(line);
		List<ArtistPair> pairs = Lists.newArrayList();
		
		for (int i=0; i<sortedTokens.size(); i++) {
			for (int j=i; j<sortedTokens.size(); j++) {
				if (! sortedTokens.get(i).equals(sortedTokens.get(j))) {
					pairs.add(new ArtistPair(
							sortedTokens.get(i).intern(),
							sortedTokens.get(j).intern()));
				}
			}
		}
		return pairs;
	}
	
	/**
	 * Ensure that the list is alphabetical to prevent forming duplicate
	 * pairs.
	 * @param artistLine is a comma-separated list of artists
	 * @return alphabetical list of artists.
	 */
	private static List<String> getAlphabetizedArtists(String artistLine) {
		String[] arr = artistLine.split(",");
		List<String> artistList = Arrays.asList(arr);
		
		Collections.sort(artistList);
		return artistList;
	}
	
}
