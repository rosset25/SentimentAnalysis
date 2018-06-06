package data;

import util.PurgeString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {
    private String fileName;
    private double trainPercentage;
    private List<SentenceSentimentScore> sentences = null;
    private List<SentenceSentimentScore> trainSentences = null;
    private List<String> punctuationSymbols = Arrays.asList(",", ".", "\"", "!", "?");

    public DataReader(String fileName, double trainPercentage) {
        this.fileName = fileName;
        this.trainPercentage = trainPercentage;
    }

    public List<SentenceSentimentScore> process() {
        if(sentences != null) return sentences;

        Path path = Paths.get(fileName);
        try {
            sentences = Files.lines(path)
                    .map(e -> sentenceScore(e))
                    .collect(Collectors.toList());

//            trainSentences = sentences.subList(0, (int)(trainPercentage * sentences.size()/100.0));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sentences;
    }

    public List<SentenceSentimentScore> getTrainSet() {
//        int index = (int)(trainPercentage * sentences.size()/100.0);
//        return sentences.subList(0, index);
        int index = sentences.size() - (int)(trainPercentage * sentences.size()/100.0)+1;
        return sentences.subList(index, sentences.size()-1);
    }

    public List<SentenceSentimentScore> getTestSet() {
//        int index = (int)(trainPercentage * sentences.size()/100.0) + 1;
//        return sentences.subList(index, sentences.size()-1);
        int index = (int)(trainPercentage * sentences.size()/100.0);
        return sentences.subList(0, index);
    }

    private SentenceSentimentScore sentenceScore(String sentenceWithScore) {
        char charScore = sentenceWithScore.charAt(sentenceWithScore.length() - 1);
        int score = Integer.parseInt(charScore + "");
        String sentence = sentenceWithScore.substring(0, sentenceWithScore.length() - 2).trim();
        sentence = sentence.toLowerCase();
//        sentence = purgePunctuation(sentence);
        sentence = PurgeString.trainingRemovePunctuationSymbols(sentence);
        sentence = PurgeString.removeDeterminants(sentence);
        return new SentenceSentimentScore(sentence, score);
    }

//    private String purgePunctuation(final String input) {
//        String output = new String(input);
//        for(String symbol: punctuationSymbols) {
//            output = output.replace(symbol, "");
//        }
//        return output;
//    }

    public class SentenceSentimentScore {
        public final String sentence;
        public final int score;

        public SentenceSentimentScore(String sentence, int score) {
            this.sentence = sentence;
            this.score = score;
        }

        @Override
        public String toString() {
            return sentence + ": " + score;
        }
    }
}
