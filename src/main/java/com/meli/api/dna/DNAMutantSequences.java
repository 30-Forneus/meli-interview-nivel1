package com.meli.api.dna;

enum DNAMutantSequences {
	CCCC, GGGG, AAAA, TTTT;
	
	static final int SIZE = 4;
	
	public String pattern() {
		return toString();
	}
	
	public int length() {
		return this.pattern().length();
	}
	
	public static String[] valuesAsString() {
		String[] strings = new String[values().length];
		for (int i = 0; i < values().length; i++) {
			strings[i] =  values()[i].toString();
		}
		return strings;
	}
}
