import java.util.ArrayList;
import java.util.Random;

public class Jatekos {

    private ArrayList<Mezo> mezok;
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
    public void dobokockaElosztas(){
        int osszesKocka = getMezokSzama() * 3;
        for (Mezo mezo: mezok) {
            mezo.setDobokockaSzama(1);
            osszesKocka--;
        }
        Random r = new Random();
        while (osszesKocka > 0){
            Mezo randomMezo = mezok.get(r.nextInt(mezok.size()));
            if (randomMezo.getDobokockaSzama() < 8){
                randomMezo.novelDobokockaSzama();
                osszesKocka--;
            }
        }
    }

    @Override
    public String toString() {
        return "0";
    }
}
