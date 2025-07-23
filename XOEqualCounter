/*
  Check to see if a string has the same amount of 'x's and 'o's. The method must return a boolean and be case insensitive. The string can contain any char.
  Examples input/output:
  XO("ooxx") => true
  XO("xooxx") => false
  XO("ooxXm") => true
  XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
  XO("zzoo") => false
*/

public class XO {

    public static boolean getXO(String str) {
        int countX = 0;
        int countO = 0;
        String lower = str.toLowerCase();

        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if (c == 'x') countX++;
            else if (c == 'o') countO++;
        }

        return countX == countO;
    }
}
