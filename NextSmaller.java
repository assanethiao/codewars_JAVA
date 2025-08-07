/*
Write a function that takes a positive integer and returns the next smaller positive integer containing the same digits.

For example:

nextSmaller(21) == 12
nextSmaller(531) == 513
nextSmaller(2071) == 2017
Return -1 (for Haskell: return Nothing, for Rust: return None), when there is no smaller number that contains the same digits.
Also return -1 when the next smaller number with the same digits would require the leading digit to be zero.

nextSmaller(9) == -1
nextSmaller(111) == -1
nextSmaller(135) == -1
nextSmaller(1027) == -1 // 0721 is out since we don't write numbers with leading zeros
some tests will include very large numbers.
test data only employs positive integers.
The function you write for this challenge is the inverse of this kata: "Next bigger number with the same digits."
*/

public class Kata {
    public static long nextSmaller(long n) {
        char[] digits = Long.toString(n).toCharArray();

        // Étape 1 : Trouver l'indice où les chiffres cessent d'augmenter de droite à gauche
        int i = digits.length - 2;
        while (i >= 0 && digits[i] <= digits[i + 1]) {
            i--;
        }

        if (i < 0) return -1; // Aucune permutation plus petite

        // Étape 2 : Trouver le chiffre le plus grand à droite de i qui est plus petit que digits[i]
        int j = digits.length - 1;
        while (digits[j] >= digits[i]) {
            j--;
        }

        // Étape 3 : Échanger i et j
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // Étape 4 : Trier les chiffres à droite de i en ordre décroissant
        reverse(digits, i + 1, digits.length - 1);

        
        long result = Long.parseLong(new String(digits));

        // Vérifier qu'il n'y a pas de 0 en tête
        if (String.valueOf(result).length() != digits.length || result >= n) return -1;

        return result;
    }

    
    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    
}
