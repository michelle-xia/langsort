# langsort

## Overview
This project calls [Phoible](https://phoible.org/) as a database of letters in each language and its classification (consonant or vowel). It takes in a string and a language and outputs the string with vowels for that language sorted by descending order followed by consonants in ascending order.

## How to use
This project is run through `src/main/java/com/icat/langsort/App.java`. It starts by taking an input for language and an input for the string to sort. The program can handle upper or lower case, spaces, and special characters. To default to English, enter a jibberish language. For the other language I want to choose to sort by, French will work as well as Abua.

## Thought Process
I decided to use [Phoible](https://phoible.org/) because it was the first online database of many different languages with the classification of each letter. I parsed the data on [Phoible](https://phoible.org/) for the classification of each letter. 

I decided to use Gson to parse the data, because it is simple to use and clean. I used `gson.fromJson()` and created a model to bind the data to, but I could've just as easily used `JsonObject` and `JsonArray` as I didn't really need any of the other fields other than `aaData`. 

I used maven to manage build dependencies because it was mentioned in the job description, and because maven is easier than downloading jar files and adding to build path.

I decided to have separate classes for HttpGetRequest and ParseRequest and Sorter because those are the 3 main components in this process - you make HTTP calls, you parse the data you get from the call, and then you process the data. 

## Logic
Phoible has the letters and their classification (consonant or vowel) of most languages. The URL for the breakdown per language is `https://phoible.org/inventories/view/[Language Code]`. I find the language code by looking the language up at `https://phoible.org/inventories`. I then create a vowel set of the vowels from Phoible and then check if each letter in the string to sort is in the vowel set.

## Future things to work on
- If I wanted to make this more scalable, I would only process the data on Phoible once and save a map of each language with its vowels to a text file then read the text file in and use it to make the sorting program quicker without needing to make URL calls.

- Phoible.org is not perfect and a lot of the letters on the webpage don't have standard ASCII lettering. Therefore, not every language that gets searched will accurately sort out consonants for vowels. For instance, if you enter `English` or `German`, Phoible.org's version of the letter `e` and `i` on those pages do not have standard ASCII coding. So, if you enter a phrase like `wie geht es dir` and `German` it will return `deeeghiirstw` as if all the letters are consonants. Ideally, I'd spend some time looking at all the versions of the different non standard letters in the standard English alphabet and create a map to translate those letters to the standard ASCII encoding.

- I would add unit tests if I was going to push this to production.
