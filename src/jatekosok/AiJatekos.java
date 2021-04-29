package jatekosok;

import jatek.Lepes;
import beolvasas.Beolvas;
import palya.Palya;

/**
 * Ez a gepi jatekosok alapja
 */
public class AiJatekos extends Jatekos {
    public AiJatekos(int szinId) {
        super(szinId);
    }

    /**
     * Ez az ervenyes lepes alapja
     * @param palya ezen fog valtoztatni egy lepes
     * @return itt meg semmi
     */
    protected Lepes ervenyesLepes(Palya palya){
        return null;
    }

    /**
     * A kovetkezo lepest olvassa be
     * @param be ez a beolvasas
     * @param palya ezt fogja valtoztatni
     * @return egy ervenyes lepes
     */
    @Override
    public Lepes kovetkezoLepes(Beolvas be, Palya palya) {
        return ervenyesLepes(palya);
    }
}
