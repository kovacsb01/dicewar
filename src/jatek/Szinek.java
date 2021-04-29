package jatek;

/**
 * Ez az osztaly felelos a jatekban felmerulo szinekert
 */
public class Szinek {
    /**
     * Egy kivalaszt egy szint
     * @param szinId ez alapjan torteni a szinvalasztas
     * @return a kivalasztott szint adja vissza
     */
    public static String szin(int szinId) {
        String szin = "";
        if (szinId == 0) szin = "\u001B[0m"; //reset
        else if (szinId == 1) szin = "\033[1;96m"; //cyan
        else if (szinId == 2) szin = "\033[1;95m"; //lila
        else if (szinId == 3) szin = "\033[1;93m"; //citrom
        else if (szinId == 4) szin = "\033[1;92m"; //zold
        return szin;
    }

    /**
     * Egy adott szoveget egy kivalasztott szinre szinez
     * @param szinId ilyen szinu lesz a szoveg
     * @param szoveg ezt a szoveget szinezi at
     * @return kiszinezett szoveg
     */
    public static String szinez(int szinId, String szoveg){
        return szin(szinId) + szoveg + szin(0);
    }
}