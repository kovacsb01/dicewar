import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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

    public void kiosztas(Jatekos[] jatekosok, int mezokSzamaPerJatekos){
        Jatekos jatekos;
        Random r = new Random();
        int index;
        for (Mezo mezo : mezok) {
            index = r.nextInt(jatekosok.length);
            jatekos = jatekosok[index];
            mezo.setBirtokos(jatekos);
            jatekos.mezoHozzaad(mezo);
        }
        ArrayList<Mezo> mezoArrayList = new ArrayList<Mezo>();
        boolean jatekosoknakKulonbozoSzamuMezoiVannak = true;
        while (jatekosoknakKulonbozoSzamuMezoiVannak){
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
                    j.mezoHozzaad(mezoArrayList.remove(0));
                    jMezokSzama++;
                }
            }

            boolean jatekosoknakUgyanAnnyiMezojeVan = true;
            int jatekos1MezoSzam = jatekosok[0].getMezokSzama();
            for (Jatekos j: jatekosok) {
                if (j.getMezokSzama() != jatekos1MezoSzam) {
                    jatekosoknakUgyanAnnyiMezojeVan = false;
                    break;
                }
            }
            if (jatekosoknakUgyanAnnyiMezojeVan) jatekosoknakKulonbozoSzamuMezoiVannak = false;
        }
    }

    public int getN() {
        return n;
    }

    @Override
    public String toString() {

        String palya = "";
        for (int i = 0; i < n+1; i++){
            for (int j = 0; j < m+1; j++){
                if (i == 0 || j == 0) palya += i + j + " ";
                else palya += mezok[((i - 1) * m) + (j - 1)].getDobokockaSzama() + " ";
            }
            palya += "\n";
        }
        return palya;
    }
}