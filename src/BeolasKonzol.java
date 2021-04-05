import java.util.Scanner;

public class BeolasKonzol extends Beolvas{

    private Scanner be;

    public BeolasKonzol() {
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
            try {
                szam = be.nextInt();
                ujra = false;
            } catch (Exception e) {
                System.out.println("Ez nem szam, szamot irj!");
            }
        }
        return szam;
    }


}
