package beolvasas;

import java.util.Scanner;

/**
 * Konzolrol olvas be vagy egy sor számot vagy egy sor szöveget
 */
public class BeolvasKonzol extends Beolvas {

    private Scanner be;

    public BeolvasKonzol() {
        be = new Scanner(System.in);
    }

    /**
     * Beolvas egy sort
     * @return beolvasott sor
     */
    @Override
    public String kovetkezoSor(){
        return be.nextLine();
    }

    /**
     * Beolvas egy sor szamot
     * @return beolvasott szam(ok)
     */
    @Override
    public int kovetkezoSzam(){
        int szam = 0;
        boolean ujra = true;
        while (ujra) {
            String sor = kovetkezoSor();
            try {
                szam = Integer.parseInt(sor);
                ujra = false;
            } catch (Exception e) {
                System.out.println("Ez nem szam, szamot irj!");
            }
        }
        return szam;
    }
}
