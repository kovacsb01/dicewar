package palya;

import jatekosok.Jatekos;

import java.util.*;

/**
 * Ez a palya ahol jatszodik a jatek
 */
public class Palya {

    private Mezo[] mezok;
    private int n;
    private int m;

    public Palya(int n, int m) {
        this.n = n;
        this.m = m;

        mezok = new Mezo[n * m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                mezok[(i * m) + j] = new Mezo(new Koordinata(i, j));
            }
        }
    }

    public Palya(int n) {
        this((n+1)*2, (n+1)*2);
    }

    /**
     * A palya merete
     * @return palya meret
     */
    public int meret(){
        return mezok.length;
    }

    /**
     * Itt osztja ki a jatekosok kozott a mezoket a palya
     * @param jatekosok a jatszo jatekosok
     */
    public void kiosztas(Jatekos[] jatekosok){
        int mezokSzamaPerJatekos = mezok.length / jatekosok.length;
        assert mezokSzamaPerJatekos * jatekosok.length == mezok.length;
        Jatekos jatekos;
        Random r = new Random();
        int index;
        for (Mezo mezo : mezok) {
            index = r.nextInt(jatekosok.length);
            jatekos = jatekosok[index];
            jatekos.mezoHozzaad(mezo);
        }
        ArrayList<Mezo> mezoArrayList = new ArrayList<Mezo>();
        for (Jatekos j: jatekosok) {
            int jMezokSzama = j.getMezokSzama();
            while (jMezokSzama > mezokSzamaPerJatekos) {
                mezoArrayList.add(j.mezoPop());
                jMezokSzama--;
            }
        }
        for (Jatekos j: jatekosok) {
            int jMezokSzama = j.getMezokSzama();
            while (jMezokSzama < mezokSzamaPerJatekos) {
                Mezo m = mezoArrayList.remove(0);
                j.mezoHozzaad(m);
                jMezokSzama++;
            }
        }
        for (Jatekos j: jatekosok) {
            assert j.getMezokSzama() == mezokSzamaPerJatekos;
        }
        assert mezoArrayList.isEmpty();
    }

    /**
     * Egy mezo koordinatajanak a lekerdezese
     * @param koordinata a lekerdezendo koordinata
     * @return x es y koordinata
     */
    public Mezo getMezo(Koordinata koordinata){
        return getMezo(koordinata.getX(), koordinata.getY());
    }

    /**
     * Egy mezo koordinatajanak a lekerdezese
     * @param x x oldali szomszed
     * @param y y oldali szomszed
     * @return szomszedos koordinatak
     */
    public Mezo getMezo(int x, int y){
        int index = (x * m) + y;
        Mezo mezo = null;
        if (mezok.length > index && 0 <= index){
            mezo = mezok[index];
            assert mezo.getKoordinata().equals(x, y):""+ x +" "+ y;
        }
        return mezo;
    }

    /**
     * Osszegyujti az adott mezo szomszedos koordinatait
     * @param mezo a kivalasztott mezo
     * @return szomszedos koordinatak lista
     */
    public List<Mezo> getSzomszedMezok(Mezo mezo){
        List<Mezo> mezoList = new ArrayList<Mezo>();
        for (Mezo m: mezok) {
            if (m.getKoordinata().szomszed(mezo.getKoordinata())) mezoList.add(m);
        }
        assert mezoList.size() <= 4 && mezoList.size() >= 2;
        return mezoList;
    }

    /**
     * A palya egyik oldala
     * @return egyik oldal meret
     */
    public int getN() {
        return n;
    }

    /**
     * Kiirja a palyat
     * @return palya
     */
    @Override
    public String toString() {
        String palya = "";
        for (int i = 0; i < n+1; i++){
            for (int j = 0; j < m+1; j++){
                if (i == 0 || j == 0) palya += i + j + " ";
                else palya += mezok[((i - 1) * m) + (j - 1)].getDobokockakSzamaSzinesen() + " ";
            }
            palya += "\n";
        }
        return palya;
    }
}