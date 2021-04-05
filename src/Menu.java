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
        System.out.println("U: uj jatek");
        System.out.println("B: betoltes");
        System.out.println("K: kilepes");
        String sor = be.nextLine();
        Valasztas valasztas = Valasztas.ISMERETLEN;
        if (sor.equals("U")) valasztas = Valasztas.JATEK;
        else if (sor.equals("B")) valasztas = Valasztas.BETOLTES;
        else if (sor.equals("K")) valasztas = Valasztas.KILEPES;
        return valasztas;
    }
}
