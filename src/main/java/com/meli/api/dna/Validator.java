package com.meli.api.dna;

public enum Validator {
	INSTANCE;

//	boolean containsAny(String[] targetDNA) {	
//		return Arrays.asList(targetDNA).stream()
//				.filter(targetSeq -> Arrays.asList(DNAMutantSequences.values()).stream()
//						.anyMatch(mSeq -> targetSeq.contains(mSeq.toString())))
//				.collect(Collectors.toList()).isEmpty();				
//	}

	boolean containsAny(String[] targetDNA, String[] dnaMutantSequences) {
		for (int i = 0; i < targetDNA.length; i++) {
			for (int j = 0; j < dnaMutantSequences.length; j++) {
				if(targetDNA[i].contains(dnaMutantSequences[j])) {
					return true;
				}
			}
		}
		return false;
	}

}
