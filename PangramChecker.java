/**
Description :
 Ce programme vérifie si une phrase donnée est un **pangramme**, c’est-à-dire une phrase qui contient 
 toutes les lettres de l’alphabet (de A à Z) au moins une fois. 
 Le test est **insensible à la casse** (majuscules/minuscules) et **ignore les chiffres et la ponctuation**. 
Exemple de pangramme : "The quick brown fox jumps over the lazy dog"

 */
import java.util.HashSet;

public class PangramChecker {

    public boolean check(String sentence) {
        // Convertir toute la phrase en minuscules
        sentence = sentence.toLowerCase();

        // Utiliser un HashSet pour stocker les lettres uniques
        HashSet<Character> letters = new HashSet<>();

        // Parcourir chaque caractère de la phrase
        for (char c : sentence.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                letters.add(c); // Ajouter uniquement les lettres de l'alphabet
            }
        }

        // Si on a trouvé 26 lettres différentes, c'est un pangramme
        return letters.size() == 26;
    }

    // Pour tester
    public static void main(String[] args) {
        PangramChecker checker = new PangramChecker();

        System.out.println(checker.check("The quick brown fox jumps over the lazy dog")); // true
        System.out.println(checker.check("Hello world")); // false
    }
}
