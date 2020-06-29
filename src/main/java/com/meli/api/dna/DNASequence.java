package com.meli.api.dna;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor
public class DNASequence {
	
	private String id;
	@NonNull private String[] dna;
	
	boolean isMutant() {
		return Validator.INSTANCE.validate(this);	
	}
}
