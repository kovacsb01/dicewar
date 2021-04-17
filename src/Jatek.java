public class Jatek {
    private Beolvas beolvas;
    private Jatekos jatekos;
    private int mezokSzamaEgyJatekosra;
    private Palya palya;

    public Jatek() {
        beolvas = new BeolvasKonzol();
    }

    public void palyaletrehozasa(){
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
    }

    public void futas(){
        palyaletrehozasa();
        System.out.println(palya.toString());

        while (true){

        }
    }
}