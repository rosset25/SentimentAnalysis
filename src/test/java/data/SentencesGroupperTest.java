package data;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;

public class SentencesGroupperTest {
    @Test
    public void positiveSentecesTest() {
        DataReader dt = new DataReader("src/main/resources/yelp_labelled.txt", 80);
        List<DataReader.SentenceSentimentScore>result = dt.process();
        SentencesGroupper gs = new SentencesGroupper(result);

        long positiveSenteces = gs.getPositiveSentences().stream()
                .count();

        assertThat(positiveSenteces, is(500L));
    }

    @Test
    public void allSentecesTest() {
        DataReader dt = new DataReader("src/main/resources/yelp_labelled.txt", 80);
        List<DataReader.SentenceSentimentScore>result = dt.process();
        SentencesGroupper gs = new SentencesGroupper(result);

        long allSenteces = gs.allSentences().stream()
                .count();

        assertThat(allSenteces, is(1000L));
    }
}
