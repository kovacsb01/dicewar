import java.util.List;
import java.util.Random;

public class RandomAiJatekos extends AiJatekos{
    public RandomAiJatekos(int szinId) {
        super(szinId);
        System.out.println(""+Szinek.szinez(szinId, "RandomAiJatekos"));
    }

    @Override
    protected Lepes ervenyesLepes(Palya palya) {
        Lepes lepes = null;
        Random r = new Random();
        List<Mezo> szomszedok;
        int count = 0;
        if (r.nextInt(100) < 75){
            while (lepes == null && count < 1000){
                Mezo tamado = randomMezo();
                count++;
                if (tamado.getDobokockaSzama() < 2) continue;
                szomszedok = palya.getSzomszedMezok(tamado);
                Mezo celpont = szomszedok.get(r.nextInt(szomszedok.size()));
                if (tamado.getBirtokos() == celpont.getBirtokos()) continue;
                lepes = new Lepes(tamado,celpont);
            }
        }
        return lepes;
    }
}
