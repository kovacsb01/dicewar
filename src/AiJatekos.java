import java.util.Random;

public class AiJatekos extends Jatekos{
    public AiJatekos(int szinId) {
        super(szinId);
    }

    protected Lepes ervenyesLepes(Palya palya){
        return null;
    }
    @Override
    public Lepes kovetkezoLepes(Beolvas be, Palya palya) {
        return ervenyesLepes(palya);
    }
}
