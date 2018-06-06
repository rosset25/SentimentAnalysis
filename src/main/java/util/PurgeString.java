package util;

import java.util.Arrays;
import java.util.List;

public class PurgeString {
    private static List<String> punctuationSymbols = Arrays.asList(",", ".", "\"", "!", "?");
    private static List<String> determinants = Arrays.asList("the", "a", "some", "i", "i'm", "to");

    public static String trainingRemovePunctuationSymbols(String input) {
        String output = new String(input);
        for(String symbol: punctuationSymbols) {
            output = output.replace(symbol, "");
        }
        return output;
    }



    public static String[] removePunctuationSymbols(String input) {
        String modifiedInput = new String(input);
        for(String symbol: punctuationSymbols) {
            modifiedInput = modifiedInput.replace(symbol, " . ");
        }
        String[] output = modifiedInput.split(" . ");
        return output;
    }

    public static String removeDeterminants(String input) {
        String output = new String(input);
        String[] outputSplitted = output.split(" ");
        output = new String();
        for(String word: outputSplitted) {
            if (!determinants.contains(word)) {
                output = output + " " + word;
            }
        }
        return output;
    }

    public static String[] stringToVector(String input) {
        String sentence = new String(input).toLowerCase();

        //devuelve el texto separado por , o "."
        String[] allSentence = removePunctuationSymbols(sentence);

        for(int i=0; i < allSentence.length; i++) {
            allSentence[i] = removeDeterminants(allSentence[i]);
        }

        return allSentence;
    }
}
