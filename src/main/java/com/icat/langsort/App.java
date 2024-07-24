package com.icat.langsort;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

import com.icat.langsort.utils.HttpGetRequest;
import com.icat.langsort.utils.ParseResponse;
import com.icat.langsort.model.ResponseModel;
import com.icat.langsort.utils.Sorter;

public class App 
{
    public static int numLanguagesToParse = 400000;

    public static String language; // defaults to English if can't find this

    public static String stringToSort;

    /**
     * Gets user input
     * language: the language to look up
     * stringToSort: the string to sort
     */
    public static void getInput() { 
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a language: "); // Try Abua, the unicoding isn't great from Phoible.org
        language = reader.nextLine();
        System.out.println("Enter a string in " + language + " to sort"); // No punctuation
        stringToSort = reader.nextLine();

        reader.close();
    }

    /**
     * Takes the user input and returns the sorted string
     * @param args
     * @throws IOException
     */
    public static void main( String[] args ) throws IOException
    {
        getInput();

        // Get the numerical code for the language on Phoible
        String getLanguageCodeUrl = HttpGetRequest.createGetLanguageCodeUrl(numLanguagesToParse);
        String langCodeResponse = HttpGetRequest.sendGET(getLanguageCodeUrl);
        ResponseModel langCodeResponseModel = ParseResponse.parseResponse(langCodeResponse, language);
        String langCode = ParseResponse.getLanguageCode(langCodeResponseModel, language);

        // Get the set of vowels for the language
        String getVowelUrl = HttpGetRequest.createGetVowelsUrl(langCode);
        String vowelResponse = HttpGetRequest.sendGET(getVowelUrl);
        ResponseModel vowelModel = ParseResponse.parseResponse(vowelResponse, getLanguageCodeUrl);
        Set<String> vowelSet = ParseResponse.getVowels(vowelModel);

        // Sort the string
        String sortedString = Sorter.sort(stringToSort, vowelSet);

        // Print result
        System.out.println("Sorted String: " + sortedString);
    }
}
