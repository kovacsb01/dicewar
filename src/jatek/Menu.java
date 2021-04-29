package jatek;

import java.util.Scanner;

/**
 * Ebben az osztalyban lehet kivalasztani a jatek elejen, mit szeretnenk csinalni
 */
public class Menu {

    private Scanner be;
    public Menu() {
        be = new Scanner(System.in);
    }

    /**
     * A jatekos kivalaszthatja mi tortenjen a program indulasakor
     * @return a kivalasztott utasitas
     */
    public Valasztas valaszt(){
        System.out.println("Valassz:");
        System.out.println("uj jatek = U");
        System.out.println("betoltes = B");
        System.out.println("kilepes = K");
        String sor = be.nextLine();
        Valasztas valasztas = Valasztas.ISMERETLEN;
        if (sor.equals("U") || sor.equals("u")) valasztas = Valasztas.JATEK;
        else if (sor.equals("B") || sor.equals("b")) valasztas = Valasztas.BETOLTES;
        else if (sor.equals("K") || sor.equals("k")) valasztas = Valasztas.KILEPES;
        return valasztas;
    }
}
