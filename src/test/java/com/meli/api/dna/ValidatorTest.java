package com.meli.api.dna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorTest {
	
	private String[] has = {"ATGCGA", "CAGTGC", "TTTTTT", "AGACGG", "GCGTCA", "TCACTG"};
	private Validator validator = Validator.INSTANCE;
	private String[] mutantSequences;
	
	@BeforeEach
	void setUp() throws Exception {
		mutantSequences = DNAMutantSequences.valuesAsString();
	}

	@Test
	void testContainsAny() {
		assertTrue(validator.containsAny(has, mutantSequences));
	}

}
