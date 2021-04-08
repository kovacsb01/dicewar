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
        this(n, n);
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

    /*public static int szamol;
    public static int[][] palyatomb;

    public static int[][] getPalyatomb() {
        return palyatomb;
    }

    //itt hozza letre a palya alakjat
    public static String palyameret(Jatek jatek){
        String palyameret = "";
        int index = (jatek.getEllenfelek()+1)*2+1;
        palyatomb = new int[index][index];
        for (int i=0; i<index;i++){
            for (int j=0; j<index;j++){
                palyatomb[i][j] = i + j;
                if (i == 0 || j == 0) palyameret += palyatomb[i][j]+" ";
                else szamol++;
            }
            palyameret += "\n";
        }
        return palyameret;
    }*/


}