package actividad_bloques_sincronizados;

public class Contador1 {
    private int num;
    private final Object monitor = new Object();

    public Contador1(int valor) {
        this.num = valor;
    }

    public void sumarUno() {
        synchronized (monitor) {
            num++; // sumo uno
        }
    }

    public void restarUno() {
        synchronized (monitor) {
            num--; // resto uno
        }
    }

    public int getNum() {
        return num; // devuelvo el num
    }
}

