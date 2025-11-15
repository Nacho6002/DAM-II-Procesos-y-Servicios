package metodos_sincronizados;

public class HiloContador extends Thread {
    private ContadorCaracteres contador;
    private String texto;
    private String tipo;

    public HiloContador(ContadorCaracteres c, String txt, String t) {
        contador = c;
        texto = txt;
        tipo = t;
    }

    public void run() {
        int cuantos = 0;
        for (int i = 0; i < texto.length(); i++) {
            char ch = texto.charAt(i);
            if (tipo.equals("mayus") && ch >= 'A' && ch <= 'Z') {
                contador.sumarMayus();
                cuantos++; // encontré una mayúscula
                System.out.print(ch + " ");
            }
            if (tipo.equals("minus") && ch >= 'a' && ch <= 'z') {
                contador.sumarMinus();
                cuantos++; // minúscula pillada
                System.out.print(ch + " ");
            }
            if (tipo.equals("num") && ch >= '0' && ch <= '9') {
                contador.sumarNum();
                cuantos++; // número visto
                System.out.print(ch + " ");
            }
        }
        System.out.println("\nHilo de " + tipo.toUpperCase() + " " + cuantos + " caracteres encontrados.");
    }
}

