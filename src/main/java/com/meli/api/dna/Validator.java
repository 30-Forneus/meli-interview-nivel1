package com.meli.api.dna;

import static com.meli.api.dna.DNAMutantSequences.valuesAsString;

import java.util.Arrays;
import java.util.stream.Collectors;

enum Validator {
	INSTANCE;

	// java 8+ flavor
	boolean containsAny(String[] targetDNA) {
		return !Arrays.asList(targetDNA).stream()
				.filter(analysedSequence -> Arrays.asList(valuesAsString()).stream()
						.anyMatch(mutantSequence -> analysedSequence.contains(mutantSequence.toString())))
				.collect(Collectors.toList()).isEmpty();				
	}

	// java 7- flavor
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

	public boolean validate(DNASequence dnaSequence) {
		final Scanner scanner = Scanner.INSTANCE;
		String[] dna = dnaSequence.getDna();
		return containsAny(dna, valuesAsString())
				|| containsAny(scanner.transposed(dna), valuesAsString())
				|| containsAny(scanner.diagonal(dna), valuesAsString())
				|| containsAny(scanner.diagonalOfMirrored(dna), valuesAsString()); // java 7- flavor
//		return containsAny(dna)
//				|| containsAny(scanner.transposed(dna))
//				|| containsAny(scanner.diagonal(dna))
//				|| containsAny(scanner.diagonalOfMirrored(dna));	// java 8+ flavor

	}

}
