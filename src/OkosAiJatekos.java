import java.util.ArrayList;
import java.util.List;

public class OkosAiJatekos extends AiJatekos{
    public OkosAiJatekos(int szinId) {
        super(szinId);
        System.out.println(""+Szinek.szinez(szinId, "OkosAiJatekos"));
    }

    @Override
    protected Lepes ervenyesLepes(Palya palya) {
        Lepes lepes = null;
        List<Mezo> szomszedok;
        for (Mezo m: mezok) {
            if (m.getDobokockaSzama() > 1){
                szomszedok = palya.getSzomszedMezok(m);
                for (Mezo szomszed: szomszedok) {
                    if (m.getBirtokos() != szomszed.getBirtokos() && m.getDobokockaSzama() > szomszed.getDobokockaSzama()){
                        lepes = new Lepes(m, szomszed);
                    }
                }
            }
        }
        return lepes;
    }
}
