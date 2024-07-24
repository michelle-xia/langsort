package com.icat.langsort.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGetRequest {

    private static final String GET_CODE_URL_START = "https://phoible.org/inventories?sEcho=2&iColumns=8&sColumns=name%2Clanguage%2Call%2Cvowel%2Cconsonant%2Ctone%2Ccontributor%2Ccite&iDisplayStart=1&iDisplayLength=";

	private static final String GET_CODE_URL_END ="&mDataProp_0=0&sSearch_0=&bRegex_0=false&bSearchable_0=true&bSortable_0=true&mDataProp_1=1&sSearch_1=&bRegex_1=false&bSearchable_1=true&bSortable_1=true&mDataProp_2=2&sSearch_2=&bRegex_2=false&bSearchable_2=false&bSortable_2=false&mDataProp_3=3&sSearch_3=&bRegex_3=false&bSearchable_3=true&bSortable_3=true&mDataProp_4=4&sSearch_4=&bRegex_4=false&bSearchable_4=true&bSortable_4=true&mDataProp_5=5&sSearch_5=&bRegex_5=false&bSearchable_5=true&bSortable_5=true&mDataProp_6=6&sSearch_6=&bRegex_6=false&bSearchable_6=true&bSortable_6=true&mDataProp_7=7&sSearch_7=&bRegex_7=false&bSearchable_7=false&bSortable_7=false&sSearch=&bRegex=false&iSortCol_0=0&sSortDir_0=asc&iSortingCols=1&__eid__=Inventories&_=1721757413357";

	private static final String VOWELS_URL_START = "https://phoible.org/values?contribution=";
	
	private static final String VOWELS_URL_END = "&sEcho=1&iColumns=5&sColumns=segment_class%2Cvalueset%2Cmarginal%2Callophones%2Cfrequency&iDisplayStart=0&iDisplayLength=100&mDataProp_0=0&sSearch_0=&bRegex_0=false&bSearchable_0=true&bSortable_0=true&mDataProp_1=1&sSearch_1=&bRegex_1=false&bSearchable_1=true&bSortable_1=true&mDataProp_2=2&sSearch_2=&bRegex_2=false&bSearchable_2=true&bSortable_2=true&mDataProp_3=3&sSearch_3=&bRegex_3=false&bSearchable_3=true&bSortable_3=true&mDataProp_4=4&sSearch_4=&bRegex_4=false&bSearchable_4=true&bSortable_4=true&sSearch=&bRegex=false&iSortCol_0=4&sSortDir_0=desc&iSortCol_1=1&sSortDir_1=asc&iSortingCols=2&__eid__=Phonemes&_=1721773454920";
	
	private static final String ACCEPT = "application/json";

    private static final String USER_AGENT = "Mozilla/5.0";

    private static final String X_REQUESTED_WITH = "XMLHttpRequest";

	public static String createGetLanguageCodeUrl(int numLanguagesToParse) {
		return GET_CODE_URL_START + String.valueOf(numLanguagesToParse) +  GET_CODE_URL_END;
	}

	public static String createGetVowelsUrl(String urlCode) {
		return VOWELS_URL_START + urlCode + VOWELS_URL_END;
	}

	public static String sendGET(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		// Set Headers
        con.setRequestProperty("Accept", ACCEPT);
		con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("X-Requested-With", X_REQUESTED_WITH);
		
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			return response.toString();
			
		} else {
			System.out.println("GET request failed.");
			return "";
		}
	}
}