package actividad_bloques_sincronizados;

public class Hilo1 extends Thread {
    private Contador1 miContador;

    public Hilo1(String nombre, Contador1 cont) {
        setName(nombre);
        this.miContador = cont;
    }

    public void run() {
        for (int i = 0; i < 300; i++) {
            miContador.sumarUno(); // sumo uno
        }
        System.out.println(getName() + " cuenta: " + miContador.getNum());
    }
}

