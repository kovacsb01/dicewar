import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jatek {
    private Beolvas beolvas;
    private int jatekosokSzama;
    private Jatekos jatekos;

    public Jatek() {
        beolvas = new BeolasKonzol();
    }

    public void bekerJatekosokSzama(){
        System.out.println("Valassz hany ellenfelet szeretnel:");
        System.out.println("1 2 3");
        boolean ujra = true;
        while (ujra){
            jatekosokSzama = beolvas.kovetkezoSzam();
            if (jatekosokSzama < 1 || jatekosokSzama > 3) System.out.println("Ez nem 1 es 3 kozott van, valassz 1 es 3 kozott");
            else ujra = false;
        }
    }

    public void futas(){
        bekerJatekosokSzama();
        while (true){

        }
    }

    /*private int ellenfelek;

    public Jatek(int ellenfelek) {
        this.ellenfelek = ellenfelek;
    }

    public Jatek() {
        this.ellenfelek = 1;
    }

    public int getEllenfelek() {
        return ellenfelek;
    }

    public void setEllenfelek(int ellenfelek) {
        if (ellenfelek < 1) this.ellenfelek = 1;
        else if (ellenfelek > 3) this.ellenfelek = 3;
        else this.ellenfelek = ellenfelek;
    }
*/
}