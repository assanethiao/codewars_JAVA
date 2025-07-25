/**
 * Classe Catalog
 *
 * Cette classe contient une méthode statique `catalog` qui permet de rechercher un article 
 * dans un catalogue donné sous forme de chaîne XML simplifiée. 
 * 
 * Le catalogue est une chaîne contenant plusieurs produits encadrés par la balise <prod>, 
 * chaque produit contient un nom (<name>), un prix (<prx>) et une quantité (<qty>).
 * 
 * La méthode `catalog` :
 * - Sépare le catalogue en produits individuels.
 * - Recherche tous les produits dont le nom contient la chaîne passée en paramètre `article`.
 * - Pour chaque produit trouvé, elle extrait le nom, le prix et la quantité.
 * - Elle construit une chaîne de résultat listant chaque produit trouvé sur une ligne au format :
 *      "nom > prx: $prix qty: quantité"
 * - Si aucun produit ne correspond, elle renvoie "Nothing".
 *
 * Exemple d'utilisation :
 * 
 * String s = "<prod><name>drill</name><prx>99</prx><qty>5</qty></prod>\n\n" +
 *            "<prod><name>hammer</name><prx>10</prx><qty>50</qty></prod>\n\n" +
 *            "<prod><name>table saw</name><prx>1099.99</prx><qty>5</qty></prod>\n\n" +
 *            "<prod><name>saw</name><prx>9</prx><qty>10</qty></prod>";
 * 
 * System.out.println(Catalog.catalog(s, "saw"));
 * 
 * Résultat :
 * table saw > prx: $1099.99 qty: 5
 * saw > prx: $9 qty: 10
 */

public class Catalog {
    public static String catalog(String s, String article) {
        if (s == null || article == null || article.isEmpty()) return "Nothing";
        
        String[] products = s.split("\n\\s*\n"); // Sépare par lignes vides
        
        StringBuilder result = new StringBuilder();
        
        for (String prod : products) {
            String name = extractTagContent(prod, "name");
            if (name == null) continue;
            
            if (name.contains(article)) {
                String prx = extractTagContent(prod, "prx");
                String qty = extractTagContent(prod, "qty");
                if (prx == null || qty == null) continue;
                
                if (result.length() > 0) result.append("\n");
                result.append(String.format("%s > prx: $%s qty: %s", name, prx, qty));
            }
        }
        
        return result.length() == 0 ? "Nothing" : result.toString();
    }
    
    private static String extractTagContent(String text, String tag) {
        String open = "<" + tag + ">";
        String close = "</" + tag + ">";
        int start = text.indexOf(open);
        int end = text.indexOf(close);
        if (start == -1 || end == -1 || end < start) return null;
        return text.substring(start + open.length(), end);
    }
}
