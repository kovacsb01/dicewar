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

    public boolean szomszed(Koordinata masik){
        int atlo = 0;
        if ((x == masik.x-1) || (x == masik.x+1)) atlo++;
        if ((y == masik.y-1) || (y == masik.y+1)) atlo++;
        if (atlo == 1) return true;
        return false;
    }
}
