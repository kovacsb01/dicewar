package jatek;

import beolvasas.Beolvas;
import beolvasas.BeolvasKonzol;
import jatekosok.OkosAiJatekos;
import jatekosok.RandomAiJatekos;
import jatekosok.TamadoAiJatekos;
import jatekosok.Jatekos;
import palya.Palya;
import palya.Mezo;

import java.util.Random;

/**
 * Ebben az osztalyban tortenik a jatekkal kapcsolatos elemek letrehozasa
 */
public class Jatek {
    private Beolvas beolvas;
    private Jatekos[] jatekosTomb;
    private Palya palya;

    public Jatek() {
        beolvas = new BeolvasKonzol();
    }

    /**
     * Beolvassa a jatekos altal valasztott ellenfeleket
     * es ez alapjan letrehozza a megfelelo meretu palyat
     * es minden mezojehez tesz megfeleloen elosztva egy veletlen kiosztott tipusu ellenfelet
     */
    private void palyaLetrehozasa(){
        int jatekosokSzama = 0;
        System.out.println("Valassz hany ellenfelet szeretnel:");
        System.out.println("1 2 3");
        boolean ujra = true;
        while (ujra){
            jatekosokSzama = beolvas.kovetkezoSzam();
            if (jatekosokSzama < 1 || jatekosokSzama > 3) System.out.println("Ez nem 1 es 3 kozott van, valassz 1 es 3 kozott");
            else ujra = false;
        }
        palya = new Palya(jatekosokSzama);
        jatekosTomb = new Jatekos[jatekosokSzama+1];
        jatekosTomb[0] = new Jatekos( 1);
        Random r = new Random();
        for (int i = 1; i < jatekosTomb.length; i++){
            int v = r.nextInt(3);
            switch (v){
                case 0:
                    jatekosTomb[i] = new RandomAiJatekos(i+1);
                    break;
                case 1:
                    jatekosTomb[i] = new TamadoAiJatekos(i+1);
                    break;
                case 2:
                    jatekosTomb[i] = new OkosAiJatekos(i+1);
                    break;
            }
        }
        palya.kiosztas(jatekosTomb);
        for (Jatekos j: jatekosTomb) {
            j.dobokockaElosztas();
        }
    }

    /**
     * A letrehozott palyat kiirja a konzolra,
     * kiirja a jatekosok altal birtokolt mezok szamat es birtokolt dobokockakat
     */
    private void kiirPalya(){
        System.out.println(palya.toString());
        System.out.print("Mezok szama: ");
        for (Jatekos j: jatekosTomb) {
            System.out.print(j.toString());
        }
        System.out.println();
    }

    /**
     * Dobas erteket hatarozza meg, kiirja a dobasokat egyesevel, majd osszegzi azokat
     * @param mezo a kivalasztott mezorol tortenik a dobas
     * @param resztvevo az egyik jatekos aki reszt vesz a harcban
     * @return mennyit dobott a mezon allo jatekos
     */
    private int dobalas(Mezo mezo, String resztvevo){
        Random r = new Random();
        int osszDobas = 0;
        int dobokockainakSzama = mezo.getDobokockaSzama();
        System.out.print(resztvevo+" dobasai: ");
        for (int i = 0; i < dobokockainakSzama; i++){
            int dobas = r.nextInt(6) + 1;
            osszDobas += dobas;
            System.out.print(dobas+" ");
        }
        System.out.println("\n"+resztvevo+" eredmeny: " + osszDobas);
        return osszDobas;
    }

    /**
     * Itt tortenik a harc ket jatekos kozott<br>
     * ha a tamado nyer megkapja a vedekezo mezojet es az eredeti tamado mezon 1 kockat hagy a tobbit atviszi a megszerzett teruletre<br>
     * ha a vedekezo nyer a tamado mezon 1 dobokocka marad<br>
     * @param lepes ez alapjan kerul kiosztasra a tamado jatekos es a vedekezo jatekos
     */
    private void harc(Lepes lepes){
        System.out.println(lepes.toString());
        int tamadoOsszDobas = dobalas(lepes.getTamado(), "Tamado");
        int celpontOsszDobas = dobalas(lepes.getCelpont(), "Vedekezo");
        if (tamadoOsszDobas > celpontOsszDobas){
            System.out.println("A tamado nyert\n");
            lepes.getCelpont().setDobokockaSzama(lepes.getTamado().getDobokockaSzama()-1);
            lepes.getCelpont().getBirtokos().mezoTorles(lepes.getCelpont());
            lepes.getTamado().getBirtokos().mezoHozzaad(lepes.getCelpont());
        }
        else {
            System.out.println("A vedo nyert\n");
        }
        lepes.getTamado().setDobokockaSzama(1);
    }

    /**
     * Ha a nem gepi jatekos kiesik, eldontheti hogy vegig akarja-e nezni a gepi jatekosok altal folytatott jatekot vagy nem
     * @return a nem gepi jatekos utasitasa a jatek tovabbi menetevel kapcsolatban
     */
    private boolean folytatodjon(){
        boolean igen = false;
        String sor;
        System.out.println("Veszetettel. Meg akarod nezni a jatek veget? (i / n)");
        while (true) {
            sor = beolvas.kovetkezoSor();
            if (sor.equals("i")){
                igen = true;
                break;
            }
            else if (sor.equals("n")) {
                break;
            }
            else {
                System.out.println("i / n");
            }
        }
        return igen;
    }

    /**
     * Itt zajlik le az egesz jatek, addig tart, amig egy jatekos nem marad az egesz palyan
     * @throws InterruptedException arra szolgal, hogy bizonyos ido teljen el a gepi jatekosok dobasai kozott
     */
    public void futas() throws InterruptedException{
        palyaLetrehozasa();
        kiirPalya();
        boolean fut = true;
        boolean kerdeztuk = false;
        while (fut){
            for (Jatekos j : jatekosTomb) {
                if (j.el()) {
                    Lepes lepes = j.kovetkezoLepes(beolvas, palya);
                    while (lepes != null) {
                        harc(lepes);
                        kiirPalya();
                        Thread.sleep(1000);
                        if (j.getMezokSzama() == palya.meret()) {
                            fut = false;
                            System.out.println("Vege a jateknak");
                            break;
                        }
                        if (jatekosTomb[0] != j && !(jatekosTomb[0].el()) && !kerdeztuk){
                            kerdeztuk = true;
                            fut = folytatodjon();
                            if (!fut) break;
                        }
                        lepes = j.kovetkezoLepes(beolvas, palya);
                    }

                    if (!fut) break;
                    j.dobokockaSzamNoveles();
                    kiirPalya();
                    System.out.println("Kovetkezo jatekos");
                }
            }
        }
    }
}