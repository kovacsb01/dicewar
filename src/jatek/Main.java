package jatek;

/**
 * Itt lehet eldonteni mit szeretnenk csinalni a programmal
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Menu menu = new Menu();
        boolean fut = true;
        while (fut){
            switch (menu.valaszt()){
                case JATEK:
                    Jatek jatek = new Jatek();
                    jatek.futas();
                    break;
                case BETOLTES:
                    System.out.println("nincs kesz");
                    break;
                case KILEPES:
                    fut = false;
                    break;
                case ISMERETLEN:
                    System.out.println("ismeretlen opcio!\n");
                    break;
            }
        }
    }
}