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
		// Get all languages and save. Format is a nested list.
		List<List<String>> responseArray = responseModel.getAaData();
		// Iterate through each language in languages
		for (List<String> languageArr : responseArray) {
			// check if this language is the one the user inputted.
			if (languageArr.toString().contains(language)) {
				// Extract the language code
				Matcher m = LANGUAGE_CODE_PATTERN.matcher(languageArr.toString());
				// Return the language code
				while (m.find()) {		
					System.out.println("Found the language code for " + language);			
					return m.group("langcode");
				}
			}
		}
		// Default is English
		System.out.println("Could not find language, defaulting to English");
		return "1561";
	}

	public static Set<String> getVowels(ResponseModel responseModel) {
		// Get all letters and save. Format is a nested list.
		List<List<String>> responseArray = responseModel.getAaData();
		// This first part is the same as above, so I have the option to abstract it out
		// and add a flag for vowels vs language code
		// Iterate through each language in languages
		for (List<String> letterArr : responseArray) {
			// Check if letter is a vowel
			if (letterArr.toString().contains("vowel")) {
				// Extract letter
				Matcher m = VOWEL_PATTERN.matcher(letterArr.toString());
				// Add vowel to vowel set
				while (m.find()) {	
					vowelSet.add(m.group("vowel"));
				}
			}
		}
		return vowelSet;
	}
}
