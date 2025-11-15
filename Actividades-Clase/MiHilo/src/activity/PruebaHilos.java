package activity;

public class PruebaHilos {
    public static void main(String[] args) {
        MiHilo hilo = new MiHilo();
        hilo.setName("MiHilo-01");
        hilo.start();
        try {
            Thread.sleep(1000);
            System.out.println("\n--- RONDA 1 ---");
            hilo.mostrarCadena("Mensaje 1 ");
            hilo.suspender();
            Thread.sleep(2000);
            hilo.reanudar();
            Thread.sleep(1000);
            System.out.println("\n--- RONDA 2 ---");
            hilo.mostrarCadena("Mensaje 2 ");
            hilo.suspender();
            Thread.sleep(2000);
            hilo.reanudar();
            Thread.sleep(1000);
            System.out.println("\n--- RONDA 3 ---");
            hilo.mostrarCadena("Mensaje 3 ");
            hilo.suspender();
            Thread.sleep(2000);
            hilo.reanudar();
            Thread.sleep(1000);
            System.out.println("\n--- RONDA 4 ---");
            hilo.mostrarCadena("Mensaje 4 ");
            hilo.suspender();
            Thread.sleep(2000);
            hilo.reanudar();
            Thread.sleep(1000);
            System.out.println("\n--- RONDA 5 ---");
            hilo.mostrarCadena("Mensaje 5 ");
            hilo.suspender();
            Thread.sleep(2000);
            hilo.reanudar();
            Thread.sleep(1000);
            System.out.println("\n--- FIN DE LA PRUEBA ---");
            hilo.interrupt();
        } catch (InterruptedException e) {
            System.out.println("El hilo Main fue interrumpido.");
        }
    }
}