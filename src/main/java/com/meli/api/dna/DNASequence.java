package com.meli.api.dna;

import static com.meli.api.dna.DNAMutantSequences.valuesAsString;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class DNASequence {
	@NonNull private final String[] dna;
	
	boolean isMutant() {
		final Validator validator = Validator.INSTANCE;
		final Scanner scanner = Scanner.INSTANCE;
		
		final String[] transposed = scanner.transposed(dna);
		final String[] diagonal = scanner.diagonal(dna);
		final String[] invertedDiagonal = scanner.diagonalOfMirrored(dna);
		
//		scanner.print(dna); System.out.println();
//		scanner.print(transposed); System.out.println();
//		scanner.print(diagonal); System.out.println();
//		scanner.print(invertedDiagonal); System.out.println();
		
		return validator.containsAny(dna, valuesAsString())
				|| validator.containsAny(transposed, valuesAsString())
				|| validator.containsAny(diagonal, valuesAsString())
				|| validator.containsAny(invertedDiagonal, valuesAsString());
		
	}
}
