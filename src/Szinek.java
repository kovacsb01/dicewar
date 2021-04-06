public class Szinek {
    private String szin;
    private int szinId;

    public Szinek() {
    }

    public Szinek(String szin, int szinId) {
        this.szin = szin;
        this.szinId = szinId;
    }

    public String Szin(int szinId) {
        if (szinId == 0) szin = "\u001B[0m"; //reset
        else if (szinId == 1) szin = "\033[1;96m"; //cyan
        else if (szinId == 2) szin = "\033[1;94m"; //lila
        else if (szinId == 3) szin = "\033[1;93m"; //citrom
        else if (szinId == 4) szin = "\033[1;92m"; //zold
        return szin;
    }


}
