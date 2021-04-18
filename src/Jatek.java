public class Jatek {
    private Beolvas beolvas;
    private Jatekos[] jatekosTomb;
    private int mezokSzamaEgyJatekosra;
    private Palya palya;

    public Jatek() {
        beolvas = new BeolvasKonzol();
    }

    public void palyaLetrehozasa(){
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
        for (int i = 0; i < jatekosTomb.length; i++){
            jatekosTomb[i] = new Jatekos(i + 1);
        }
        palya.kiosztas(jatekosTomb);
        for (Jatekos j: jatekosTomb) {
            j.dobokockaElosztas();
        }
    }

    public void futas(){
        palyaLetrehozasa();
        System.out.println(palya.toString());

        while (true){

        }
    }
}