package com.meli.api.dna;

import static org.junit.jupiter.api.Assertions.*;
import static com.meli.api.dna.DNAMutantSequences.*;

import org.junit.jupiter.api.Test;

class DNAMutantSequencesTest {

	private static final String CYTOSINE = "CCCC";

	@Test
	void testPattern() {
		assertEquals(CYTOSINE, CCCC.pattern());
	}

	@Test
	void testLength() {
		assertEquals(CYTOSINE.length(), CCCC.length());
	}

	@Test
	void testValuesAsString() {
		assertEquals(values().length, valuesAsString().length);
	}
}
