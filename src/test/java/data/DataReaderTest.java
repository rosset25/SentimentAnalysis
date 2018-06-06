package data;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.core.Is.*;
import static org.hamcrest.MatcherAssert.*;

public class DataReaderTest {
    private static DataReader dt;// = new DataReader("src/main/resources/yelp_labelled.txt");
    private static List<DataReader.SentenceSentimentScore> result;// = dt.process();

    @BeforeAll
    public static void init() {
        dt = new DataReader("src/main/resources/yelp_labelled.txt", 80);
        result = dt.process();
    }


    @Test
    public void totalNumberOfSentencesTest() {
        long numberOfSenteces = result.stream()
                .count();

        assertThat(numberOfSenteces, is(1000L));
    }

    @Test
    public void positiveNumberOfSenteces() {
        long numberOfSenteces = result.stream()
                .filter(s -> s.score == 1)
                .count();

        assertThat(numberOfSenteces, is(500L));
    }

    @Test
    public void negativeNumberOfSenteces() {
        long numberOfSenteces = result.stream()
                .filter(s -> s.score == 0)
                .count();

        assertThat(numberOfSenteces, is(500L));
    }

    @Test
    public void remove() {
        result.stream()
                .forEach(System.out::println);
    }
}
