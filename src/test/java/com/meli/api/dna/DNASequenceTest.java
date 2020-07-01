package com.meli.api.dna;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

class DNASequenceTest {

	private static final String RESOURCE_PATH = "src/test/resources/meliMatriz-%s_07x07.json";

	private static final String HAS = "HAS";
	private static final String DOES_NOT_HAVE = "DOES_NOT_HAVE";
	private static final String HAS_DIAGONAL = "HAS_DIAGONAL";
	private static final String HAS_VERTICAL = "HAS_VERTICAL";
	private static final String INV_DIAGONAL = "INV_DIAGONAL";

	private static DNASequence has;
	private static DNASequence doesNotHave;
	private static DNASequence hasDiagonal;
	private static DNASequence hasVertical;
	private static DNASequence hasInvertedDiagonal;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		has = loadJson(HAS);
		doesNotHave = loadJson(DOES_NOT_HAVE);
		hasDiagonal = loadJson(HAS_DIAGONAL);
		hasVertical = loadJson(HAS_VERTICAL);
		hasInvertedDiagonal = loadJson(INV_DIAGONAL);
	}

	private static DNASequence loadJson(final String type) throws Exception {
		final byte[] jsonFromFile = Files.readAllBytes(Paths.get(format(RESOURCE_PATH, type)));
		ObjectMapper objectMapper = new ObjectMapper();
		final DNASequence dnaObject = objectMapper.readValue(jsonFromFile, DNASequence.class);
		return dnaObject;
	}

	@Test
	void testIsMutant() {
		assertTrue(has.isMutant());
		assertTrue(hasVertical.isMutant());
		assertTrue(hasDiagonal.isMutant());
		assertTrue(hasInvertedDiagonal.isMutant());
	}

	@Test
	void testIsNotMutant() {
		assertFalse(doesNotHave.isMutant());
	}

}