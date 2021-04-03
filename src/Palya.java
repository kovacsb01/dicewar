import java.util.Random;

public class Palya {
    public static int szamol;
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
    }


}