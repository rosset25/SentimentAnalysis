package data;

import org.junit.jupiter.api.Test;

import java.util.List;

public class WordCounterTest {
    @Test
    public void firstTest() {
        DataReader dt = new DataReader("src/main/resources/yelp_labelled.txt", 80);
        List<DataReader.SentenceSentimentScore> result = dt.process();
        SentencesGroupper gs = new SentencesGroupper(result);
        WordCounter wc = new WordCounter();
        wc.countWords(gs.getPositiveSentences());
        System.out.println(wc.times("good"));
        System.out.println(wc.frequency("good"));
        System.out.println(wc.logarithmicFrequency("good"));
        System.out.println(wc.totalWords());
    }
}
