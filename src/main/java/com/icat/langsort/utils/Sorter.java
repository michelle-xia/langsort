package com.icat.langsort.utils;

import java.util.Arrays;
import java.util.Set;

public class Sorter {

    private static String vowels = "";

    private static String consonants = "";

    private static char[] vowelArr;

    private static char[] consonantArr;

    public static String sort(String stringToSort, Set<String> vowelSet) {

        // Remove white spaces
        stringToSort = stringToSort.replaceAll("\\s+","");
        
        // Make lower case
        stringToSort = stringToSort.toLowerCase();

        // Convert to char array
        char[] charArray = stringToSort.toCharArray();
        
        // Iterate through letters and check if it is in vowel set
        // If it is, append to vowels. Otherwise, append to consonants
        for (char letter : charArray) {
            if (vowelSet.contains(String.valueOf(letter))) {
                vowels += letter;
            } else {
                consonants += letter;
            }
        }

        // Convert to char array for sorting
        vowelArr = vowels.toCharArray();
        consonantArr = consonants.toCharArray();

        Arrays.sort(vowelArr);
        Arrays.sort(consonantArr);

        // Reverse vowels with StringBuilder
        String sortedVowels = new String(vowelArr);
        String reversedVowels = new String (new StringBuilder().append(sortedVowels).reverse());

        String sortedConsonants = new String(consonantArr);

        return reversedVowels + sortedConsonants;
    }
    
}
