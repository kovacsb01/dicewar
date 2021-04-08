import java.util.List;

public class Jatekos {

    private List<Mezo> mezok;
    private String szin;

    public Jatekos(int szinId) {
        szin = Szinek.Szin(szinId);
    }

}
