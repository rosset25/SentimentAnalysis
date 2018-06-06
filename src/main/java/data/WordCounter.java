package data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {
    private Map<String, Long> wordsCount;
    private long wordCount = 0;

    public WordCounter() {
        super();
        wordsCount = new HashMap<>();
    }

    public void countWords(List<String> sentences) {
        String[] words;
        for(String sentece: sentences) {
            words = sentece.split(" ");
            addWords(words);
        }
    }

    private void addWords(String[] words) {
        wordCount += words.length;

        for(int i=0 ; i<words.length-1 ; i++ ){
            String twoWords = words[i]+" "+words[i+1];
            if (wordsCount.containsKey(twoWords)){
                long previous = wordsCount.get(twoWords);
                wordsCount.replace(twoWords, ++previous);
            }else {
                wordsCount.put(twoWords, 1L);
            }
        }

        for(String word: words) {
            if(wordsCount.containsKey(word)) {
                long previous = wordsCount.get(word);
                wordsCount.replace(word, ++previous);
            } else {
                wordsCount.put(word, 1L);
            }
        }


    }

    public long times(String word) {
        if(wordsCount.containsKey(word)) return wordsCount.get(word);
        return 0;
    }

    public long totalWords() {
        return wordCount;
    }

    public double frequency(String word) {
        return ((double)times(word))/wordCount;
    }

    public double logarithmicFrequency(String word) {
        return Math.log(frequency(word));
    }
}
