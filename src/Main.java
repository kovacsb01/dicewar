import java.util.Scanner;
import java.util.Random;

public class Main {
    //itt olvas be es donti el hogy helyes-e a bemenet
    public static int beolvas(Jatek jatek){
        boolean ujra = false;
        while (!ujra) {
            System.out.print("Választás: ");
            Scanner be = new Scanner(System.in);
            try {
                jatek.setEllenfelek(be.nextInt());
                ujra = true;
            } catch (Exception e) {
                System.out.println("Rossz formátum, válassz újat");
            }
        }
        return jatek.getEllenfelek();
    }

    public static void main(String[] args){
        Jatek jatek = new Jatek();
        System.out.println("Dice Wars\nVálassz mennyi ellenfelet szeretnél:\n1 2 3");
        int beolvas = beolvas(jatek);
        String palyameret = Palya.palyameret(jatek);
        int szamol = Palya.szamol;
        System.out.println(beolvas);
        System.out.println(palyameret);
        System.out.println(szamol);
    }

}