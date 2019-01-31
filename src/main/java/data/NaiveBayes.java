package data;

import util.PurgeString;

import java.util.LinkedList;
import java.util.List;

public class NaiveBayes {
    private WordCounter positiveCounter;
    private WordCounter negativeCounter;
    private WordCounter allCounter;
    private DataReader dt;

    public NaiveBayes() {
        super();
    }

    public void initialize(String fileName) {
        dt = new DataReader(fileName, 75);
//        List<DataReader.SentenceSentimentScore> result = dt.process();
        dt.process();
//        SentencesGroupper gs = new SentencesGroupper(result);
        SentencesGroupper gs = new SentencesGroupper(dt.getTrainSet());
        positiveCounter = new WordCounter();
        positiveCounter.countWords(gs.getPositiveSentences());
        negativeCounter = new WordCounter();
        negativeCounter.countWords(gs.getNegativeSentences());
        allCounter = new WordCounter();
        allCounter.countWords(gs.allSentences());
    }

    public double positiveProbability(final String input) {

        String sentence = new String(input).toLowerCase();
        sentence = PurgeString.trainingRemovePunctuationSymbols(sentence);
        sentence = PurgeString.removeDeterminants(sentence);
        double positive, result = 0;
        String[] vectorString = sentence.split(" ");
        for(String word: vectorString) {
            positive = positiveCounter.frequency(word);
            if(positive != 0 ) result += Math.log(positive) / allCounter.logarithmicFrequency(word);
        }
        for (int i=0 ; i<vectorString.length-1 ; i++){
            String twoWords = vectorString[i] + " " +vectorString[i+1];
            positive = positiveCounter.frequency(twoWords);
            if (positive != 0) result += Math.log(positive) / allCounter.logarithmicFrequency(twoWords);
        }
        return result;
    }

    public double negativeProbability(final String input) {

        String sentence = new String(input).toLowerCase();
        sentence = PurgeString.trainingRemovePunctuationSymbols(sentence);
        sentence = PurgeString.removeDeterminants(sentence);
        double negative, result = 0;
        String[] vectorString = sentence.split(" ");
        for(String word: vectorString) {
            negative = negativeCounter.frequency(word);
            if(negative != 0) result += Math.log(negative) / allCounter.logarithmicFrequency(word);
        }
        for (int i=0 ; i<vectorString.length-1 ; i++){
            String twoWords = vectorString[i] + " " +vectorString[i+1];
            negative = negativeCounter.frequency(twoWords);
            if (negative != 0) result += Math.log(negative) / allCounter.logarithmicFrequency(twoWords);
        }
        return result;

    }

    public int sentimentScore(final String input) {
        double scorePositive = 0;
        double scoreNegative = 0;

        String[] sentences = PurgeString.stringToVector(new String(input).toLowerCase());
        List<Frase> allSentences = new LinkedList<Frase>();

        //creamos las Frases y las añadimos en una lista
        for(int i=0; i < sentences.length; i++){
            allSentences.add( new Frase(sentences[i]));
        }

        //obtendremos la puntuación de cada frase de la lista
        for (Frase sentence : allSentences){

            //String de la frase
            String words = sentence.getSentence();

            //si la frase contiene alguna negación
            if (sentence.containsNOT() == true){
               String notSentence = sentence.getSubstringWithNot();

               //se comprueba que al usar not anula una palabra que de normal sería mala y viceversa
                String[] word = notSentence.split(" ", 1);
               if(negativeCounter.frequency(word[0]) > positiveCounter.frequency(word[0])) {
                   //ej. not boring
                   scorePositive += positiveProbability(notSentence);
               }else{
                   //ej. not like
                   scoreNegative += positiveProbability(notSentence);
               }

               /*la frase sin la negación se analizará igual que las demás
               (sacando la prob. de positivo y prob negativo)
                */
               words = sentence.getSubstringWithoutNot();
            }

            scoreNegative += negativeProbability(words);
            scorePositive += positiveProbability(words);

        }

        if (scoreNegative > scorePositive) {
            return 0;
        }

        return 1;

    }

    public double test() {
        List<DataReader.SentenceSentimentScore> test = dt.getTestSet();
        long score = 0;
        for(DataReader.SentenceSentimentScore sentenceSentimentScore: test) {
            if(sentimentScore(sentenceSentimentScore.sentence) == sentenceSentimentScore.score) score++;
        }
        return (double)score / test.size() * 100.0;
    }
}
