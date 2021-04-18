public class Main {
    public static void main(String[] args){
        Menu menu = new Menu();
        boolean fut = true;
        while (fut){
            switch (menu.valaszt()){
                case JATEK:
                    Jatek jatek = new Jatek();
                    jatek.futas();
                    break;
                case BETOLTES:
                    System.out.println("meg nincs kesz LOOL");
                    break;
                case KILEPES:
                    fut = false;
                    break;
                case ISMERETLEN:
                    System.out.println("ismeretlen opcio!!!\n");
                    break;
            }
        }
    }
}