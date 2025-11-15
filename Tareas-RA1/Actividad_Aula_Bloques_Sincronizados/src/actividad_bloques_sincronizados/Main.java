package actividad_bloques_sincronizados;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Contador1 contador = new Contador1(100); // empiezas en 100

        Hilo1 h1 = new Hilo1("HILO SUMA", contador);
        Hilo2 h2 = new Hilo2("HILO RESTA", contador);

        h1.start();
        h2.start();

        h1.join();
        h2.join();

        System.out.println("Final, cuenta: " + contador.getNum()); // resultado final
    }
}

