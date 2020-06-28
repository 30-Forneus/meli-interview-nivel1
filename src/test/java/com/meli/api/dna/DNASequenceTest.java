package com.meli.api.dna;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DNASequenceTest {

	private static final String FAKE_ID = "#FAKE_ID#";
	private static final String RESOURCE_PATH = "src/test/resources/meliMatriz-%s_07x07.json";

	private static final String HAS = "HAS";
	private static final String DOES_NOT_HAVE = "DOES_NOT_HAVE";
	private static final String HAS_DIAGONAL = "HAS_DIAGONAL";
	private static final String HAS_VERTICAL = "HAS_VERTICAL";
	private static final String INV_DIAGONAL = "INV_DIAGONAL";

	private static JSONObject has;
	private static JSONObject doesNotHave;
	private static JSONObject hasDiagonal;
	private static JSONObject hasVertical;
	private static JSONObject hasInvertedDiagonal;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		has = loadJson(HAS);
		doesNotHave = loadJson(DOES_NOT_HAVE);
		hasDiagonal = loadJson(HAS_DIAGONAL);
		hasVertical = loadJson(HAS_VERTICAL);
		hasInvertedDiagonal = loadJson(INV_DIAGONAL);
	}

	private static JSONObject loadJson(String type) throws Exception {
		final FileReader in = new FileReader(format(RESOURCE_PATH, type));
		return (JSONObject) (new JSONParser().parse(in));
	}

	@Test
	void testIsMutant() {
		assertTrue(DNASequence.of(FAKE_ID, has).isMutant());
		assertTrue(DNASequence.of(FAKE_ID, hasVertical).isMutant());
		assertTrue(DNASequence.of(FAKE_ID, hasDiagonal).isMutant());
		assertTrue(DNASequence.of(FAKE_ID, hasInvertedDiagonal).isMutant());
	}

	@Test
	void testIsNotMutant() {
		assertFalse(DNASequence.of(FAKE_ID, doesNotHave).isMutant());
	}

}