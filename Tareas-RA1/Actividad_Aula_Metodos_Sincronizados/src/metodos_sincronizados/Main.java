package metodos_sincronizados;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String texto = "123 Responda Otra vez TEXTO 123 Responda Otra vez";
        ContadorCaracteres cont = new ContadorCaracteres();

        HiloContador hiloNum = new HiloContador(cont, texto, "num");
        HiloContador hiloMayus = new HiloContador(cont, texto, "mayus");
        HiloContador hiloMinus = new HiloContador(cont, texto, "minus");

        hiloNum.start();
        hiloMayus.start();
        hiloMinus.start();

        hiloNum.join();
        hiloMayus.join();
        hiloMinus.join();

        // resultados finales
        System.out.println("Mayúsculas " + cont.getMayus());
        System.out.println("Minúsculas " + cont.getMinus());
        System.out.println("Números " + cont.getNums());
    }
}

