import java.util.ArrayList;
import java.util.Random;

public class Jatekos {

    protected ArrayList<Mezo> mezok;
    private int szinId;

    public Jatekos(int szinId) {
        this.szinId = szinId;
        mezok = new ArrayList<Mezo>();
    }

    public int getSzinId() {
        return szinId;
    }

    public void mezoHozzaad(Mezo mezo){
        mezok.add(mezo);
        mezo.setBirtokos(this);
    }
    public void mezoTorles(Mezo mezo){
        mezok.remove(mezo);
    }
    public Mezo mezoPop(){
        return mezok.remove(0);
    }

    public int getMezokSzama(){
        return mezok.size();
    }

    protected Mezo randomMezo(){
        Random r = new Random();
        return mezok.get(r.nextInt(mezok.size()));
    }

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

    public void dobokockaElosztas(){
        int osszesKocka = getMezokSzama() * 3;
        for (Mezo mezo: mezok) {
            mezo.setDobokockaSzama(1);
            osszesKocka--;
        }
        dobokockaOsztogatas(osszesKocka);
    }

    public void dobokockaSzamNoveles(){
        int osszeKocka = getMezokSzama() / 2;
        dobokockaOsztogatas(osszeKocka);
    }

    public boolean el(){
        if (getMezokSzama() == 0) return false;
        else return true;
    }

    public Lepes kovetkezoLepes(Beolvas be, Palya palya){
        boolean ujra = true;
        Koordinata koordinata1 = new Koordinata();
        Koordinata koordinata2 = new Koordinata();
        while (ujra) {
            int[] koordinatak = new int[4];
            System.out.println("sor oszlop sor oszlop");
            String sor = be.kovetkezoSor();
            if (sor.equals("0")) return null;
            if (sor.length() == 7) {
                try {
                    String[] sorok = sor.split(" ");
                    for (int i = 0; i < 4; i++){
                        koordinatak[i] = Integer.parseInt(sorok[i]) - 1;
                    }
                    ujra = false;
                } catch (Exception e) {
                    System.out.println("Helytelen formatum");
                }
                for(int i = 0; i < 4; i++){
                    if (koordinatak[i] < 0 || koordinatak[i] > (palya.getN() - 1)){
                        System.out.println(( i + 1 ) + ". koordinata1 kivul esik a palyan");
                        ujra = true;
                    }
                }
            }
            else System.out.println("Helytelen bemenet");
            koordinata1.setX(koordinatak[0]);
            koordinata1.setY(koordinatak[1]);
            koordinata2.setX(koordinatak[2]);
            koordinata2.setY(koordinatak[3]);
            if (!(koordinata1.szomszed(koordinata2))){
                System.out.println("Nem szomszedos mezok");
                ujra = true;
            }
            if (palya.getMezo(koordinata1).getBirtokos() != this){
                System.out.println("sajat mezot valassz ki");
                ujra = true;
            }
            if (palya.getMezo(koordinata1).getBirtokos() == palya.getMezo(koordinata2).getBirtokos()) {
                System.out.println("magadat nem tamadhatod meg");
                ujra = true;
            }
            if (palya.getMezo(koordinata1).getDobokockaSzama() < 2){
                System.out.println("olyan mezot valassz ahol legalabb 2 kocka van");
                ujra = true;
            }
            System.out.println();
        }
        return new Lepes(palya.getMezo(koordinata1),palya.getMezo(koordinata2));
    }

    public int getOsszDobokockakSzama(){
        int osszes = 0;
        for (Mezo m: mezok) {
            osszes+=m.getDobokockaSzama();
        }
        return osszes;
    }

    @Override
    public String toString() {
        return Szinek.szinez(szinId,""+getMezokSzama()+" ("+getOsszDobokockakSzama()+") ");
    }
}
