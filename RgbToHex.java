/*
Description:
The rgb function is incomplete. Complete it so that passing in RGB decimal values will result in a
hexadecimal representation being returned. Valid decimal values for RGB are 0 - 255. Any values that fall
out of that range must be rounded to the closest valid value.

Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.

Examples (input --> output):
255, 255, 255 --> "FFFFFF"
255, 255, 300 --> "FFFFFF"
0, 0, 0       --> "000000"
148, 0, 211   --> "9400D3"
*/


public class RgbToHex {

    public static String rgb(int r, int g, int b) {
        // Étape 1 : Corriger les valeurs pour qu'elles soient entre 0 et 255
        if (r < 0) r = 0;
        if (r > 255) r = 255;

        if (g < 0) g = 0;
        if (g > 255) g = 255;

        if (b < 0) b = 0;
        if (b > 255) b = 255;

        // Étape 2 : Convertir chaque valeur en hexadécimal
        String rh = Integer.toHexString(r).toUpperCase();
        String gh = Integer.toHexString(g).toUpperCase();
        String bh = Integer.toHexString(b).toUpperCase();

        // Étape 3 : Ajouter un 0 devant si la longueur est 1 caractère
        if (rh.length() == 1) rh = "0" + rh;
        if (gh.length() == 1) gh = "0" + gh;
        if (bh.length() == 1) bh = "0" + bh;

        // Étape 4 : Retourner le résultat final
        return rh + gh + bh;
    }
}
