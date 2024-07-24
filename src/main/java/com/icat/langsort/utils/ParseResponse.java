package com.icat.langsort.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.icat.langsort.model.ResponseModel;

public class ParseResponse {

	private static Pattern LANGUAGE_CODE_PATTERN = Pattern.compile("(\\([A-Z]+\\s)(?<langcode>[1-9]+)");
	
	private static Pattern VOWEL_PATTERN = Pattern.compile("(title\\=\")(?<vowel>.+)(\")");

	private static Set<String> vowelSet = new HashSet<>();

	public static ResponseModel parseResponse(String response, String language) {

		Gson gson = new GsonBuilder().create();

		ResponseModel responseModel = gson.fromJson(response, ResponseModel.class);
		
		return responseModel;
	}

	public static String getLanguageCode(ResponseModel responseModel, String language) {
		List<List<String>> responseArray = responseModel.getAaData();
		for (List<String> unparsedList : responseArray) {

			if (unparsedList.toString().contains(language)) {
				Matcher m = LANGUAGE_CODE_PATTERN.matcher(unparsedList.toString());

				while (m.find()) {		
					System.out.println("Found the language code for " + language);			
					return m.group("langcode");
				}
			}
		}
		// Default is American English
		System.out.println("Could not find language, defaulting to English");
		return "1561";
	}

	public static Set<String> getVowels(ResponseModel responseModel) {
		List<List<String>> responseArray = responseModel.getAaData();
		for (List<String> unparsedList : responseArray) {
			if (unparsedList.toString().contains("vowel")) {
				Matcher m = VOWEL_PATTERN.matcher(unparsedList.toString());

				while (m.find()) {	
					vowelSet.add(m.group("vowel"));
				}
			}
		}
		return vowelSet;
	}
}
