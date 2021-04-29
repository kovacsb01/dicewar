package palya;

/**
 * Ilyen koordinatak alkotjak a mezoket
 */
public class Koordinata {
    private int x;
    private int y;

    public Koordinata() {
        x = 0;
        y = 0;
    }

    public Koordinata(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Meszamolja milyen tavol van egy masik koordinata
     * @param masik a kivalasztott koordinatan kivuli koordinata
     * @return a ketto koordinata tavolsaga
     */
    public int lepesTavolsag(Koordinata masik){
        return Math.abs(masik.x-x) + Math.abs(masik.y-y);
    }

    /**
     * Lepes tavolsag alapjan eldonti hogy egy masik koordinata szomszedja-e
     * @param masik a vizsgalando koordinata
     * @return szomszed-e a masik koordinata
     */
    public boolean szomszed(Koordinata masik){
        return 1 == lepesTavolsag(masik);
    }

    public boolean equals(Koordinata k) {
        return equals(k.x, k.y);
    }

    /**
     * ketto koordinata osszehasonlitasa
     * @param x x koordinata
     * @param y y koordinata
     * @return egyenlo-e a vizsgalt koordinatak
     */
    public boolean equals(int x, int y) {
        return x == this.x && y == this.y;
    }
}
