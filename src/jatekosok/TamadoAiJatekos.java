package jatekosok;

import jatek.Lepes;
import jatek.Szinek;
import palya.Palya;
import palya.Mezo;

import java.util.List;

/**
 * Ez a tamado jatekos
 */
public class TamadoAiJatekos extends AiJatekos {
    public TamadoAiJatekos(int szinId) {
        super(szinId);
        System.out.println(""+ Szinek.szinez(szinId, "TamadoAiJatekos"));
    }

    /**
     * Mindent megtamad amit tud
     * @param palya ezen fog valtoztatni egy lepes
     * @return tamad
     */
    @Override
    protected Lepes ervenyesLepes(Palya palya) {
        Lepes lepes = null;
        List<Mezo> szomszedok;
        for (Mezo m: mezok) {
            if (m.getDobokockaSzama() > 1){
                szomszedok = palya.getSzomszedMezok(m);
                for (Mezo szomszed: szomszedok) {
                    if (m.getBirtokos() != szomszed.getBirtokos()){
                        lepes = new Lepes(m, szomszed);
                    }
                }
            }
        }
        return lepes;
    }
}
