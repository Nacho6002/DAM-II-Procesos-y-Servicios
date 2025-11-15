package activity;

class MiHilo extends Thread {
    private boolean suspendido = false;

    public void mostrarCadena(String cadena) {
        System.out.println(cadena);
    }

    @Override
    public void run() {
        try {
            System.out.println("Lanzando hilo...");
            for (int i = 0; i < 5; i++) {
                synchronized (this) {
                    while (suspendido) {
                        wait();
                    }
                }
                System.out.print("TIC TAC ");
                Thread.sleep(1000);
            }
            System.out.println("\nParando hilo.");
        } catch (InterruptedException e) {
            System.out.println(getName() + " ha sido interrumpido.");
        }
    }

    public synchronized void suspender() {
        this.suspendido = true;
    }

    public synchronized void reanudar() {
        this.suspendido = false;
        notify();
    }
}