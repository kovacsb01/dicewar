package jatekosok;

import jatek.Lepes;
import jatek.Szinek;
import palya.Palya;
import palya.Mezo;

import java.util.List;
import java.util.Random;

/**
 * Ez az okos gepi jatekos
 */
public class OkosAiJatekos extends AiJatekos {
    public OkosAiJatekos(int szinId) {
        super(szinId);
        System.out.println(""+ Szinek.szinez(szinId, "OkosAiJatekos"));
    }

    /**
     * Az okos jatekos lepese, taktikusan tortenik
     * @param palya ezen fog valtoztatni egy lepes
     * @return egy taktikus tamadas
     */
    @Override
    protected Lepes ervenyesLepes(Palya palya) {
        Random r = new Random();
        Lepes lepes = null;
        List<Mezo> szomszedok;
        for (Mezo m: mezok) {
            if (m.getDobokockaSzama() > 1){
                szomszedok = palya.getSzomszedMezok(m);
                for (Mezo szomszed: szomszedok) {
                    if (m.getBirtokos() != szomszed.getBirtokos() && m.getDobokockaSzama() >= szomszed.getDobokockaSzama()){
                        if (m.getDobokockaSzama() == szomszed.getDobokockaSzama() && r.nextInt(100) < 75) lepes = new Lepes(m, szomszed);
                        else lepes = new Lepes(m, szomszed);
                    }
                }
            }
        }
        return lepes;
    }
}
