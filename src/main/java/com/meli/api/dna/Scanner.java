package com.meli.api.dna;

import static java.lang.Math.max;
import static java.lang.Math.min;

import lombok.Generated;
import lombok.NonNull;

public enum Scanner {
	
	INSTANCE;

	String[] asStringArray(byte[][] matrix) {	
		final int noRows = matrix.length;
		String[] strArray = new String[noRows];
		for (int r = 0; r < noRows; r++) {
			strArray[r] = new String(matrix[r]);
		}
		return strArray;
	}

	byte[][] asByteMatrix(String[] strArray) {
		final int noCols = strArray[0].length();
		final int noRows = strArray.length;
		byte[][] matrix = new byte[noRows][noCols];
		for (int row = 0; row < noRows; row++) {
			matrix[row] = strArray[row].getBytes();
		}
		return matrix;
	}
	
	byte[][] transposed(byte[][] matrix) {		
		final int noCols = matrix[0].length;
		final int noRows = matrix.length;
		byte[][] trasposed = new byte[noCols][noRows];
		for (int c = 0; c < noCols; c++) {
			byte[] row = new byte[noRows];
			for (int r = 0; r < noRows; r++) {
				row[r] = matrix[r][c];
			}
			trasposed[c] = row;
		}
		return trasposed;
	}
	
	byte[][] mirrored(byte[][] matrix) {
		final int noCols = matrix[0].length;
		final int noRows = matrix.length;
		byte[][] mirrored = new byte[noRows][noCols];
		for (int r = 0; r < noRows; r++) {
			byte[] row = new byte[noRows];
			for (int c = 0; c < noCols; c++) {
				row[(noRows-1)-c] = matrix[r][c];
			}
			mirrored[r] = row;
		}
		return mirrored;
	}
		
	byte[][] diagonal(byte[][] matrix) {
		final int noCols = matrix[0].length;
		final int noRows = matrix.length;
		final int lenDia = min(noCols, noRows);
		final int noDia = noCols + noRows - 1;
		byte[][] diagonals = new byte[noDia][lenDia];
		int dd = 0;
		
	    for (int d = 1; d <= noDia ; d++) { 
	        int startColumn = max(0, d - noRows);      
	        int count = min(min(d, (noCols - startColumn)), noRows);     
	        byte[] diagonal = new byte[lenDia];	  
	        for (int j = 0; j < count; j++) { 
	        	diagonal[j]= matrix[min(noRows, d) - j - 1] [startColumn + j]; 
	        }
	        diagonals[dd++] = diagonal;
	    }
	 
		return diagonals;
	}
	
	@Generated
	String[] transposed(@NonNull String[] matrix) {
		return asStringArray(transposed(asByteMatrix(matrix)));
	}
	
	@Generated
	String[] diagonal(@NonNull String[] matrix) {
		return asStringArray(diagonal(asByteMatrix(matrix)));
	}	
	
	@Generated
	String[] diagonalOfMirrored(@NonNull String[] matrix) {
		return asStringArray(diagonal(mirrored(asByteMatrix(matrix))));
	}

	@Generated
	void print(byte[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
//			System.out.println(new String (matrix[i]));
			System.out.print(matrix[i][0]);
			for (int j = 1; j < matrix[i].length; j++) {
				System.out.print(", ");
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	@Generated
	void print(String[] sequence) {
		this.print(asByteMatrix(sequence));
	}
}
