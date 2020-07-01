package com.meli.api.dna;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ValidatorTest {
	
	private String[] has = {"ATGCGA", "CAGTGC", "TTTTTT", "AGACGG", "GCGTCA", "TCACTG"};
	private String[] doesNotHave = {"ACGTACG", "TACGTAC", "CGTACGT", "GTACGTA", "ACGTACG", "TACGTAC", "CGTACGT"};
	private Validator validator = Validator.INSTANCE;
	private static String[] mutantSequences;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		mutantSequences = DNAMutantSequences.valuesAsString();		
	}
	
	@Test
	void testContainsAny() {
		assertTrue(validator.containsAny(has, mutantSequences));
		assertTrue(validator.containsAny(has));
		assertFalse(validator.containsAny(doesNotHave, mutantSequences));
		assertFalse(validator.containsAny(doesNotHave));
	}

}
