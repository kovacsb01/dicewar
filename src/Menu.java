import java.util.Scanner;

public class Menu {
    public enum Valasztas {
        ISMERETLEN,
        JATEK,
        BETOLTES,
        KILEPES
    }
    private Scanner be;
    public Menu() {
        be = new Scanner(System.in);
    }

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
