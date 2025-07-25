/**
 * Classe Kata
 Cette classe contient une méthode statique `findShort` qui prend en entrée une chaîne de mots
séparés par des espaces, et retourne la longueur du mot le plus court.
Hypothèses :
La chaîne d'entrée n'est jamais vide.
- Tous les éléments de la chaîne sont des mots (pas besoin de gérer d'autres types).
Exemple :
findShort("The quick brown fox") renvoie 3 (car "The" et "fox" ont 3 lettres).
 */
public class Kata {
    public static int findShort(String s) {
        String[] words = s.split(" ");
        int minLength = Integer.MAX_VALUE;

        for (String word : words) {
            if (word.length() < minLength) {
                minLength = word.length();
            }
        }
        return minLength;
    }
}
