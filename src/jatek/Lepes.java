package jatek;

import palya.Mezo;

/**
 * Ez az osztaly hatarozza meg egy helyes lepes eseten ki lesz tamado jatekos es ki vedekezo jatekos
 */
public class Lepes {
    private Mezo tamado;
    private Mezo celpont;

    public Lepes(Mezo tamado, Mezo celpont) {
        this.tamado = tamado;
        this.celpont = celpont;
    }

    public Mezo getTamado() {
        return tamado;
    }

    public Mezo getCelpont() {
        return celpont;
    }

    /**
     * Kiirja a tamado es vedekezo jatekos melyik mezovel melyiket tamadja
     * @return melyik mezorol melyik mezore tortenik a tamadas mennyi kockaval
     */
    @Override
    public String toString() {
        return tamado.toString()+" -> "+celpont.toString();
    }
}
