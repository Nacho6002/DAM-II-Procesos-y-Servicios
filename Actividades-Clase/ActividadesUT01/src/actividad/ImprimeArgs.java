package actividad;

public class ImprimeArgs {

    public static void main(String[] args) {
        
        if (args.length == 0 || args[0].isEmpty()) {
            System.out.println("CADENA VACIA...");
            System.exit(1); // 
        }
        
        String cadena = args[0];
        
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + ". " + cadena);
        }
        
        System.exit(0);
    }
}
