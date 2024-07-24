package com.icat.langsort.utils;

import java.util.Arrays;
import java.util.Set;

public class Sorter {

    private static String vowels = "";

    private static String consonants = "";

    private static char[] vowelArr;

    private static char[] consonantArr;

    public static String sort(String stringToSort, Set<String> vowelSet) {

        stringToSort = stringToSort.replaceAll("\\s+","");
        
        stringToSort = stringToSort.toLowerCase();

        char[] charArray = stringToSort.toCharArray();
        
        for (char letter : charArray) {
            if (vowelSet.contains(String.valueOf(letter))) {
                vowels += letter;
            } else {
                consonants += letter;
            }
        }

        

        vowelArr = vowels.toCharArray();

        consonantArr = consonants.toCharArray();

        Arrays.sort(vowelArr);
        Arrays.sort(consonantArr);
        Arrays.sort(vowelArr);

        String sortedVowels = new String(vowelArr);
        String reversedVowels = new String (new StringBuilder().append(sortedVowels).reverse());

        String sortedConsonants = new String(consonantArr);

        return reversedVowels + sortedConsonants;
    }
    
}
