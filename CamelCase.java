/*
Complete the solution so that the function will break up camel casing, using a space between words.

Example
"camelCasing"  =>  "camel Casing"
"identifier"   =>  "identifier"
""             =>  ""


*/

class Solution {
    public static String camelCase(String input) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // Si le caractère est une majuscule, on ajoute un espace avant
            if (Character.isUpperCase(c) && i != 0) {
                result.append(" ");
            }

            result.append(c);
        }

        return result.toString();
    }

}
