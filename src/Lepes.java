public class Lepes {
    private Mezo tamado;
    private Mezo celpont;


    public Lepes(Mezo tamado, Mezo celpont) {
        this.tamado = tamado;
        this.celpont = celpont;
    }

    public Mezo getTamado() {
        return tamado;
    }

    public Mezo getCelpont() {
        return celpont;
    }

    @Override
    public String toString() {
        return tamado.toString()+" -> "+celpont.toString();
    }
}
