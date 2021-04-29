package palya;

import jatek.Szinek;
import jatekosok.Jatekos;

/**
 * Ilyenekbol epul fel a palya
 */
public class Mezo {
    private Koordinata koordinata;
    private int dobokockaSzama;
    private Jatekos birtokos;

    public Mezo(Koordinata koordinata) {
        this.koordinata = koordinata;
        dobokockaSzama = 0;
    }

    /**
     * Lekerdezi a mezo koordinatait
     * @return a mezo koordinatai
     */
    public Koordinata getKoordinata() {
        return koordinata;
    }

    /**
     * A mezon levo dobokockak szama
     * @return dobokockak szama
     */
    public int getDobokockaSzama() {
        return dobokockaSzama;
    }

    /**
     * Beallitja a mezon hany dobokocka legyen
     * @param dobokockaSzama beallitando dobokocka szam
     */
    public void setDobokockaSzama(int dobokockaSzama) {
        this.dobokockaSzama = dobokockaSzama;
    }

    /**
     * Egyel noveli a dobokockak szamat a mezon
     */
    public void novelDobokockaSzama(){
        dobokockaSzama++;
    }

    /**
     * Megmondja melyik jatekos birtokolja a mezot
     * @return mezo birtokosa
     */
    public Jatekos getBirtokos() {
        return birtokos;
    }

    /**
     * Beallitja a mezo birtokosat
     * @param birtokos a mezo leendo birtokosa
     */
    public void setBirtokos(Jatekos birtokos) {
        this.birtokos = birtokos;
    }

    /**
     * Szinesen irja ki a dobokockak szamat
     * @return szines dobokockak
     */
    public String getDobokockakSzamaSzinesen() {
        return Szinek.szinez(birtokos.getSzinId(),""+dobokockaSzama);
    }

    /**
     * Kiirja a mezo koordinatait es a rajta levo kockak szamat szinesen
     * @return koordinatak es kockak szama
     */
    @Override
    public String toString() {
        return "(" + (koordinata.getX() + 1) + ", " + (koordinata.getY() + 1) + ") "+getDobokockakSzamaSzinesen();
    }
}
