package com.meli.api.dna;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ValidatorTest {
	
	private String[] has = {"ATGCGA", "CAGTGC", "TTTTTT", "AGACGG", "GCGTCA", "TCACTG"};
	private Validator validator = Validator.INSTANCE;
	private static String[] mutantSequences;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		mutantSequences = DNAMutantSequences.valuesAsString();		
	}
	
	@Test
	void testContainsAny() {
		assertTrue(validator.containsAny(has, mutantSequences));
	}

}
