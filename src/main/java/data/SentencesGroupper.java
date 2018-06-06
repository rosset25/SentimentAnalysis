package data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SentencesGroupper {
    private List<DataReader.SentenceSentimentScore> sentences;
    private List<String> positiveSenteces;
    private List<String> negativeSenteces;

    public SentencesGroupper(List<DataReader.SentenceSentimentScore> sentences) {
        super();
        this.sentences = sentences;
        positiveSenteces = null;
        negativeSenteces = null;
    }

    private void groupSentences() {
        positiveSenteces = sentences.stream()
                .filter(e -> e.score == 1)
                .map(e -> e.sentence)
                .collect(Collectors.toList());

        negativeSenteces = sentences.stream()
                .filter(e -> e.score == 0)
                .map(e -> e.sentence)
                .collect(Collectors.toList());
    }

    public List<String> getPositiveSentences() {
        if(positiveSenteces == null) groupSentences();
        return positiveSenteces;
    }

    public List<String> getNegativeSentences() {
        if(negativeSenteces == null) groupSentences();
        return negativeSenteces;
    }

    public List<String> allSentences() {
        if(positiveSenteces == null) groupSentences();
        List<String> result = new ArrayList<>(positiveSenteces);
        result.addAll(negativeSenteces);
        return result;
    }
}
