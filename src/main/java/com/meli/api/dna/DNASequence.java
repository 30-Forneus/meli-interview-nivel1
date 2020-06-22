package com.meli.api.dna;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class DNASequence {
	@NonNull final String[] dna;
	
	boolean isMutant() {
		return Validator.INSTANCE.validate(this);	
	}
}
