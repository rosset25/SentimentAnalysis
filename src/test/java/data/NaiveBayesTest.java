package data;

import org.junit.jupiter.api.Test;
import util.PurgeString;

public class NaiveBayesTest {
    @Test
    public void first() {
        NaiveBayes nb = new NaiveBayes();
        nb.initialize("src/main/resources/yelp_labelled.txt");
        String sentence = "So Far So Good!.";
        System.out.println(nb.positiveProbability(sentence));
        System.out.println(nb.negativeProbability(sentence));
    }

    @Test
    public void scoreTest() {
        NaiveBayes nb = new NaiveBayes();
        nb.initialize("src/main/resources/yelp_labelled.txt");
        System.out.println(nb.test());
        nb.initialize("src/main/resources/imdb_labelled.txt");
        System.out.println(nb.test());
        nb.initialize("src/main/resources/amazon_cells_labelled.txt");
        System.out.println(nb.test());
        nb.initialize("src/main/resources/all.txt");
        System.out.println(nb.test());
    }
}
