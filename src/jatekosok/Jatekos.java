package jatekosok;

import jatek.Lepes;
import jatek.Szinek;
import beolvasas.Beolvas;
import palya.Palya;
import palya.Mezo;
import palya.Koordinata;

import java.util.ArrayList;
import java.util.Random;

/**
 * Ez a nem gepi jatekos<br>
 * A gepi jatekosok alapja
 */
public class Jatekos {

    protected ArrayList<Mezo> mezok;
    private int szinId;

    public Jatekos(int szinId) {
        this.szinId = szinId;
        mezok = new ArrayList<Mezo>();
    }

    /**
     * Beallitja a jatekos szinet
     * @return jatekos szine
     */
    public int getSzinId() {
        return szinId;
    }

    /**
     * Mezot ad a jatekosnak
     * @param mezo ezt a mezot adja a jatekosnak
     */
    public void mezoHozzaad(Mezo mezo){
        mezok.add(mezo);
        mezo.setBirtokos(this);
    }

    /**
     * Mezot torol a jatekostol
     * @param mezo ezt a mezot torli
     */
    public void mezoTorles(Mezo mezo){
        mezok.remove(mezo);
    }

    /**
     * Az elso elemet torli a mezokbol
     * @return torol egy elemet a mezokbol
     */
    public Mezo mezoPop(){
        return mezok.remove(0);
    }

    /**
     * Megmondja hany mezoje van egy jatekosnak
     * @return mezok szama
     */
    public int getMezokSzama(){
        return mezok.size();
    }

    /**
     * A birtokolt mezokbol egy randomot ad vissza
     * @return random mezo
     */
    protected Mezo randomMezo(){
        Random r = new Random();
        return mezok.get(r.nextInt(mezok.size()));
    }

    /**
     * Szetosztja egy jatekosnak a dobokockait a mezoi kozott
     * @param osszesKocka az osszes dobokocka
     */
    private void dobokockaOsztogatas(int osszesKocka){
        int count = 0;
        while (osszesKocka > 0) {
            count++;
            if ((count > 1000) && (getOsszDobokockakSzama() >= getMezokSzama() * 8)) break;
            Mezo randomMezo = randomMezo();
            if (randomMezo.getDobokockaSzama() < 8) {
                randomMezo.novelDobokockaSzama();
                osszesKocka--;
                count = 0;
            }
        }
    }

    /**
     * Beallit minden birtokolt mezonek egy kockat, majd random feltolti a tobbi kioszthatoval
     */
    public void dobokockaElosztas(){
        int osszesKocka = getMezokSzama() * 3;
        for (Mezo mezo: mezok) {
            mezo.setDobokockaSzama(1);
            osszesKocka--;
        }
        dobokockaOsztogatas(osszesKocka);
    }

    /**
     * Egy kor vegen ennyivel noveli a jatekos kockainak a szamat
     */
    public void dobokockaSzamNoveles(){
        int osszeKocka = getMezokSzama() / 2;
        dobokockaOsztogatas(osszeKocka);
    }

    /**
     * Itt lehet megtudni hogy a jatekos el-e meg
     * @return jatekos el-e
     */
    public boolean el(){
        if (getMezokSzama() == 0) return false;
        else return true;
    }

    /**
     * A jatekosnak a kovetkezo lepese.<br>
     *     Kivalasztja hoyg melyik mezojerol akar tamadni es melyik ellenseges mezot akarja tamadni.
     * @param be beolvassa a megfelelo tamado es tamadhato mezot
     * @param palya ezen tortenik a jatekosok kozott a lepesek
     * @return a megvaltozott palya a lepes utan
     */
    public Lepes kovetkezoLepes(Beolvas be, Palya palya){
        boolean helyes = false;
        boolean ujra = true;
        Koordinata koordinata1 = new Koordinata();
        Koordinata koordinata2 = new Koordinata();
        while (ujra) {
            int[] koordinatak = new int[4];
            System.out.println("(tamado) sor oszlop (celpont) sor oszlop");
            String sor = be.kovetkezoSor();
            if (sor.equals("0")) return null;
            if (sor.length() == 7) {
                try {
                    String[] sorok = sor.split(" ");
                    for (int i = 0; i < 4; i++){
                        koordinatak[i] = Integer.parseInt(sorok[i]) - 1;
                    }
                    ujra = false;
                    helyes = true;
                } catch (Exception e) {
                    System.out.println("Helytelen formatum");
                }
                for(int i = 0; i < 4; i++){
                    if (koordinatak[i] < 0 || koordinatak[i] > (palya.getN() - 1)){
                        System.out.println(( i + 1 ) + ". koordinata kivul esik a palyan");
                        ujra = true;
                    }
                }
            }
            else System.out.println("Helytelen bemenet");
            koordinata1.setX(koordinatak[0]);
            koordinata1.setY(koordinatak[1]);
            koordinata2.setX(koordinatak[2]);
            koordinata2.setY(koordinatak[3]);
            if (!(koordinata1.szomszed(koordinata2)) && helyes){
                System.out.println("Nem szomszedos mezok");
                ujra = true;
            }
            if (palya.getMezo(koordinata1).getBirtokos() != this && helyes){
                System.out.println("Sajat mezot valassz ki");
                ujra = true;
            }
            if (palya.getMezo(koordinata1).getBirtokos() == palya.getMezo(koordinata2).getBirtokos() && helyes) {
                System.out.println("Magadat nem tamadhatod meg");
                ujra = true;
            }
            if (palya.getMezo(koordinata1).getDobokockaSzama() < 2 && helyes){
                System.out.println("olyan mezot valassz ahol legalabb 2 kocka van");
                ujra = true;
            }

            System.out.println();
        }
        return new Lepes(palya.getMezo(koordinata1),palya.getMezo(koordinata2));
    }

    /**
     * Osszes birtokolt dobokocka szama
     * @return osszes dobokocka szama
     */
    public int getOsszDobokockakSzama(){
        int osszes = 0;
        for (Mezo m: mezok) {
            osszes+=m.getDobokockaSzama();
        }
        return osszes;
    }

    /**
     * Kiirja az adott jatekosnak hany mezoje es hany kockaja van
     * @return mezok es kockak szama
     */
    @Override
    public String toString() {
        return Szinek.szinez(szinId,""+getMezokSzama()+" ("+getOsszDobokockakSzama()+") ");
    }
}
