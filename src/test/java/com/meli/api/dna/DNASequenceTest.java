package com.meli.api.dna;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DNASequenceTest {
		
	private String[] has = {"ATGCGA", "CAGTGC", "TTTTTT", "AGACGG", "GCGTCA", "TCACTG", "012210", "543345"};
	private String[] hasVertical = {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCATCA", "TCACTG", "012210", "543345"};
	private String[] hasDiagonal = {"ATGCGA", "CAGTGC", "TTATTT", "AGAAGG", "GCGTCA", "TCACTG", "012210", "543345"};
	private String[] hasInvertedDiagonal = {"ATGCGA", "CAGGGC", "TTGTTT", "AGACGG", "GCGTCA", "TCACTG", "012210", "543345"};
	private String[] doesNotHave = {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG", "012210", "543345"};

	@Test
	void testIsMutant() {
		assertTrue(DNASequence.of(has).isMutant());
		assertTrue(DNASequence.of(hasVertical).isMutant());
		assertTrue(DNASequence.of(hasDiagonal).isMutant());
		assertTrue(DNASequence.of(hasInvertedDiagonal).isMutant());
	}

	@Test
	void testIsNotMutant() {
		assertFalse(DNASequence.of(doesNotHave).isMutant());
	}

}
