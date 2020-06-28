package com.meli.api.dna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScannerTest {
	
	private String[] sample1 = {"ABC", "123", "DEF", "GHI", "456", "789"};
	private String[] sample2 = {"A1DG47", "B2EH58", "C3FI69"};
	private String[] sample3 = { "A", "B1", "C2D", "3EG", "FH4", "I57", "68", "9" };
	private byte[][] matrix1;
	private byte[][] matrix2;
	
	@BeforeEach
	void setUp() throws Exception {//
		matrix1 = Scanner.INSTANCE.asByteMatrix(sample1);
		matrix2 = Scanner.INSTANCE.asByteMatrix(sample2);
	}

	@Test
	void testAsStringArray() {
		final int row = new Random().nextInt(sample1.length);
		final String[] stringified = Scanner.INSTANCE.asStringArray(matrix1);
		assertNotNull(stringified, "No puede ser nulo");
		assertEquals(sample1.length, stringified.length, "No tienen el mismo tamaño");
		assertEquals(sample1[row], stringified[row], "Los strings representados no son iguales");
	}

	@Test
	void testAsByteMatrix() {
		final int row1 = new Random().nextInt(sample1.length);
		System.out.println("row1: " + row1);
		assertNotNull(matrix1, "No puede ser nula");
		assertEquals(sample1.length, matrix1.length, "No tienen el mismo tamaño");
		assertEquals(sample1[0], new String(matrix1[0]), "Los strings representados no son iguales");
		assertTrue(sample1[row1].getBytes()[0] == matrix1[row1][0] , "Los elementos de la fila no corresponden al original");
		assertTrue(sample1[row1].getBytes()[1] == matrix1[row1][1] , "Los elementos de la fila no corresponden al original");
		assertTrue(sample1[row1].getBytes()[2] == matrix1[row1][2] , "Los elementos de la fila no corresponden al original");
	}

	@Test
	void testTransposed() {
		final int row = new Random().nextInt(sample1.length);
		final byte[][] transposed = Scanner.INSTANCE.transposed(matrix2);
		System.out.println("row: " + row);
		assertNotNull(transposed, "No puede ser nula");
		assertEquals(sample1.length, transposed.length, "No tienen el mismo tamaño");
		assertEquals(sample1[0].length(), transposed[0].length, "No tienen el mismo tamaño");
		assertTrue(sample1[row].getBytes()[0] == transposed[row][0] , "Los elementos de la fila no corresponden al original");
		assertTrue(sample1[row].getBytes()[1] == transposed[row][1] , "Los elementos de la fila no corresponden al original");
		assertTrue(sample1[row].getBytes()[2] == transposed[row][2] , "Los elementos de la fila no corresponden al original");
	}

	@Test
	void testDiagonal() {
		final int row = 2 + new Random().nextInt(4);
		final byte[][] diagonal = Scanner.INSTANCE.diagonal(matrix1);
		Scanner.INSTANCE.print(matrix1);
		System.out.println("row: " + row);
		assertNotNull(diagonal, "No puede ser nula");
		assertEquals(sample3.length, diagonal.length, "No tienen el mismo tamaño");
		assertEquals(sample3[row].length(), diagonal[row].length, "No tienen el mismo tamaño");
		assertTrue(sample3[row].getBytes()[0] == diagonal[row][2] , "Los elementos de la fila no corresponden al original");
		assertTrue(sample3[row].getBytes()[1] == diagonal[row][1] , "Los elementos de la fila no corresponden al original");
		assertTrue(sample3[row].getBytes()[2] == diagonal[row][0] , "Los elementos de la fila no corresponden al original");
	}
}
