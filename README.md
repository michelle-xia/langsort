# langsort

## Overview
This project calls [Phoible](https://phoible.org/) as a database of letters in each language and its classification (consonant or vowel). It takes in a string and a language and outputs the string with vowels for that language sorted by descending order followed by consonants in ascending order.

## How to use
This project is run through App.java. It starts by taking an input for language and an input for the string to sort. The program can handle upper or lower case, spaces, and special characters.

## Future things to work on
Phoible.org is not perfect and a lot of the letters on the webpage don't have standard ASCII lettering. Therefore, not every language that gets searched will accurately sort out consonants for vowels. For instance, if you enter `English` or `German`, Phoible.org's version of the letter `e` and `i` on those pages do not have standard ASCII coding. So, if you enter a phrase like `wie geht es dir` and `German` it will return `deeeghiirstw` as if all the letters are consonants. Ideally, I'd spend some time looking at all the versions of the different non standard letters in the standard English alphabet and create a map to translate those letters to the standard ASCII encoding.
