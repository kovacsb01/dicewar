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
    public void kiosztas2(Jatekos[] jatekosok){
        int mezokSzamaPerJatekos = mezok.length / jatekosok.length;
        Jatekos jatekos;
        Random r = new Random();
        ArrayList<Jatekos> jatekosArrayList = new ArrayList<Jatekos>();
        for (Jatekos j: jatekosok) {
            jatekosArrayList.add(j);
        }
        int index;
        for (Mezo mezo : mezok) {
            index = r.nextInt(jatekosArrayList.size());
            jatekos = jatekosok[index];
            jatekos.mezoHozzaad(mezo);
            if (jatekos.getMezokSzama() >= mezokSzamaPerJatekos){
                jatekosArrayList.remove(jatekos);
            }
        }
    }
    public void kiosztas3(Jatekos[] jatekosok){
        int mezokSzamaPerJatekos = mezok.length / jatekosok.length;
        Jatekos jatekos;
        Random r = new Random();
        int index;
        for (Mezo mezo : mezok) {
            index = r.nextInt(jatekosok.length);
            jatekos = jatekosok[index];
            while (jatekos.getMezokSzama() >= mezokSzamaPerJatekos){
                index = r.nextInt(jatekosok.length);
                jatekos = jatekosok[index];
            }
            jatekos.mezoHozzaad(mezo);
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
                else palya += mezok[((i - 1) * m) + (j - 1)].getDobokockakSzamaSzinesen() + " ";
            }
            palya += "\n";
        }
        return palya;
    }
}