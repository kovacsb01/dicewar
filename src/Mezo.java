public class Mezo {
    private Koordinata koordinata;
    private int dobokockaSzama;

    public Mezo(Koordinata koordinata) {
        this.koordinata = koordinata;
        dobokockaSzama = 0;
    }

    public Mezo() {
        koordinata = new Koordinata();
        dobokockaSzama = 0;
    }

    public Koordinata getKoordinata() {
        return koordinata;
    }

    public void setKoordinata(Koordinata koordinata) {
        this.koordinata = koordinata;
    }

    public int getDobokockaSzama() {
        return dobokockaSzama;
    }

    public void setDobokockaSzama(int dobokockaSzama) {
        this.dobokockaSzama = dobokockaSzama;
    }
}
