import java.util.ArrayList;

public class Jatekos {

    private ArrayList<Mezo> mezok;
    private String szin;

    public Jatekos(int szinId) {
        szin = Szinek.Szin(szinId);
        mezok = new ArrayList<Mezo>();
    }

    public void mezoHozzaad(Mezo mezo){
        mezok.add(mezo);
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

}
