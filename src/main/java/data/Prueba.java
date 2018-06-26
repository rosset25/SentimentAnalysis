package data;

public class Prueba {

    public static void main(String[] args) {

        String cosa = "it wasn't boring at all";

        Frase frase = new Frase(cosa);

        System.out.println(frase.getSubstringWithNot());

    }
}
