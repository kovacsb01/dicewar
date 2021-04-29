package palya;

import jatek.Szinek;
import jatekosok.Jatekos;

public class Mezo {
    private Koordinata koordinata;
    private int dobokockaSzama;
    private Jatekos birtokos;

    public Mezo(Koordinata koordinata) {
        this.koordinata = koordinata;
        dobokockaSzama = 0;
    }

    public Koordinata getKoordinata() {
        return koordinata;
    }

    public int getDobokockaSzama() {
        return dobokockaSzama;
    }

    public void setDobokockaSzama(int dobokockaSzama) {
        this.dobokockaSzama = dobokockaSzama;
    }

    public void novelDobokockaSzama(){
        dobokockaSzama++;
    }

    public Jatekos getBirtokos() {
        return birtokos;
    }

    public void setBirtokos(Jatekos birtokos) {
        this.birtokos = birtokos;
    }

    public String getDobokockakSzamaSzinesen() {
        return Szinek.szinez(birtokos.getSzinId(),""+dobokockaSzama);
    }

    @Override
    public String toString() {
        return "(" + (koordinata.getX() + 1) + ", " + (koordinata.getY() + 1) + ") "+getDobokockakSzamaSzinesen();
    }
}
