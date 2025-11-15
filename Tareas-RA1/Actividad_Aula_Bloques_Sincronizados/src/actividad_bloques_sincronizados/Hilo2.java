package actividad_bloques_sincronizados;

public class Hilo2 extends Thread {
    private Contador1 miContador;

    public Hilo2(String nombre, Contador1 cont) {
        setName(nombre);
        this.miContador = cont;
    }

    public void run() {
        for (int i = 0; i < 300; i++) {
            miContador.restarUno(); // resto uno
        }
        System.out.println(getName() + " cuenta: " + miContador.getNum());
    }
}

