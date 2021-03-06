import java.util.Scanner;

public class BeolvasKonzol extends Beolvas{

    private Scanner be;

    public BeolvasKonzol() {
        be = new Scanner(System.in);
    }

    @Override
    public String kovetkezoSor(){
        return be.nextLine();
    }

    @Override
    public int kovetkezoSzam(){
        int szam = 0;
        boolean ujra = true;
        while (ujra) {
            String sor = kovetkezoSor();
            try {
                szam = Integer.parseInt(sor);
                ujra = false;
            } catch (Exception e) {
                System.out.println("Ez nem szam, szamot irj!");
            }
        }
        return szam;
    }
}
