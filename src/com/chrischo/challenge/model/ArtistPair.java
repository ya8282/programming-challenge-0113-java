package com.chrischo.challenge.model;

/**
 * Preconditions: 
 * -Strings are not null
 * -Strings are in alphabetical order
 * -Strings are intern-ed
 */
public class ArtistPair {
	private final String a1, a2;
	
	public ArtistPair(String a1, String a2) {
		this.a1 = a1;
		this.a2 = a2;
	}
	
    @Override
    public String toString() {
        return a1 + "," + a2;
    }

    @Override
    public boolean equals(Object that) {
        if (that == null) {
            return false;
        }
        if (that == this) {
            return true;
        }
        if (!(that instanceof ArtistPair)){
            return false;
        }
        ArtistPair thatPair = (ArtistPair) that;
        return thatPair.a1 == this.a1 && thatPair.a2 == this.a2;
    }

    @Override
    public int hashCode() {
        final int p = 37;
        int result = 1;
        result = p * result + ((a1 == null) ? 0 : a1.hashCode());
        result = p * result + ((a2 == null) ? 0 : a2.hashCode());
        return result;
    }

}
