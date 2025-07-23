/*
    Description:
    You are going to be given a non-empty string. Your job is to return the middle character(s) of the string.

    If the string's length is odd, return the middle character.
    If the string's length is even, return the middle 2 characters.

    Examples:
    "test" --> "es"
    "testing" --> "t"
    "middle" --> "dd"
    "A" --> "A"
    */

public class Kata {

    public static String getMiddle(String word) {
        int length = word.length();
        int middle = length / 2;
        if (length % 2 == 0) {
            // longueur paire : on retourne les 2 caractères du milieu
            return word.substring(middle - 1, middle + 1);
        } else {
            // longueur impaire : on retourne 1 caractère du milieu
            return word.substring(middle, middle + 1);
        }
    }
}
