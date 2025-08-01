/*
Write two functions that convert a roman numeral to and from an integer value. Multiple roman
numeral values will be tested for each function.
Modern Roman numerals are written by expressing each digit separately starting with the left most
digit and skipping any digit with a value of zero. In Roman numerals:

1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC
2008 is written as 2000=MM, 8=VIII; or MMVIII
1666 uses each Roman symbol in descending order: MDCLXVI.
Input range : 1 <= n < 4000
In this kata 4 should be represented as IV, NOT as IIII (the "watchmaker's four").

Examples
to roman:
2000 -> "MM"
1666 -> "MDCLXVI"
  86 -> "LXXXVI"
   1 -> "I"

from roman:
"MM"      -> 2000
"MDCLXVI" -> 1666
"LXXXVI"  ->   86
"I"       ->    1

*/

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumerals {

  private static final LinkedHashMap<String, Integer> romanMap = new LinkedHashMap<>();

  static {
    romanMap.put("M", 1000);
    romanMap.put("CM", 900);
    romanMap.put("D", 500);
    romanMap.put("CD", 400);
    romanMap.put("C", 100);
    romanMap.put("XC", 90);
    romanMap.put("L", 50);
    romanMap.put("XL", 40);
    romanMap.put("X", 10);
    romanMap.put("IX", 9);
    romanMap.put("V", 5);
    romanMap.put("IV", 4);
    romanMap.put("I", 1);
  }

  // Convertit un entier en chiffre romain
  public static String toRoman(int n) {
    StringBuilder result = new StringBuilder();
    for (Map.Entry<String, Integer> entry : romanMap.entrySet()) {
      while (n >= entry.getValue()) {
        result.append(entry.getKey());
        n -= entry.getValue();
      }
    }
    return result.toString();
  }

  // Convertit un chiffre romain en entier
  public static int fromRoman(String romanNumeral) {
    int i = 0;
    int result = 0;

    while (i < romanNumeral.length()) {
      // On regarde 2 lettres si possible (ex: "CM", "IV", etc.)
      if (i + 1 < romanNumeral.length() && romanMap.containsKey(romanNumeral.substring(i, i + 2))) {
        result += romanMap.get(romanNumeral.substring(i, i + 2));
        i += 2;
      } else {
        result += romanMap.get(romanNumeral.substring(i, i + 1));
        i += 1;
      }
    }

    return result;
  }
}
