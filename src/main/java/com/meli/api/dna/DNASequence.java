package com.meli.api.dna;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor(staticName = "of")
public class DNASequence {
	
	@NonNull final String id;
	@NonNull final JSONObject jsonObject;
	public static final String DNA_JSON_PATH = "dna";
	
	boolean isMutant() {
		return Validator.INSTANCE.validate(this);	
	}
	
	public String[] getDna() {
		JSONArray array = (JSONArray) jsonObject.get(DNASequence.DNA_JSON_PATH);
		return (String[])array.stream().toArray(String[]::new);
	}
}
