import java.util.Random;
import java.util.Scanner;

public class Jatek {

    private int ellenfelek;

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


}