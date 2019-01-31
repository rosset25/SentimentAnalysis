package data;

import org.junit.jupiter.api.Test;
import util.PurgeString;

public class NaiveBayesTest {
    @Test
    public void first() {
        NaiveBayes nb = new NaiveBayes();
        nb.initialize("src/main/resources/yelp_labelled.txt");
        String sentence = "So Far So Good!.";
        System.out.println("yelp_labelled:");
        System.out.println("Positive probability: " + nb.positiveProbability(sentence));
        System.out.println("Negative probability: " + nb.negativeProbability(sentence));
        System.out.println();
    }

    @Test
    public void scoreTest() {
        NaiveBayes nb = new NaiveBayes();
        nb.initialize("src/main/resources/yelp_labelled.txt");
        System.out.println("yelp_labelled: " + nb.test());
        nb.initialize("src/main/resources/imdb_labelled.txt");
        System.out.println("imdb_labelled: " + nb.test());
        nb.initialize("src/main/resources/amazon_cells_labelled.txt");
        System.out.println("amazon_cells_labelled: " + nb.test());

        System.out.println();

        nb.initialize("src/main/resources/all.txt");
        System.out.println("all: " + nb.test());
    }
}
