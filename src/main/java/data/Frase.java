package data;

public class Frase {

    String sentence;

    //int puntuación -> 0 ó 1

    public Frase(String frase) {
        frase.toLowerCase();
        this.sentence = frase;
    }


    public boolean containsNOT() {

        if (sentence.indexOf("n't") != -1 || sentence.contains("not")) {
           return true;
        }

        return false;
    }

    public String getSentence(){
        return sentence;
    }



    public String getSubstringWithNot() {
        return getSubstring(true);
    }

    public String getSubstringWithoutNot() {
        return getSubstring(false);
    }

    private String getSubstring(boolean sentenceNOT) {

        String substring = sentence;
        int indice = -1;


        if (sentence.indexOf("n't") != -1) {
            indice = sentence.indexOf("n't");
        } else {
            if (sentence.contains("not")) ;
            indice = sentence.indexOf("not");
        }

        if (indice != -1) {
            if (sentenceNOT == true) {
                if (indice+4 > sentence.length()) {
                    substring = sentence.substring(indice + 3);
                }else {
                    substring = sentence.substring(indice + 4);
                }

            } else {
                /*NOTA: cuando se trata de "n't" la substring resultante incluirá el verbo hasta antes de "n't",
                es decir, ej. that movie wasn't boring at all -> that movie was
                 */
                substring = sentence.substring(0, indice);
            }
        }


        return substring;

    }


}
