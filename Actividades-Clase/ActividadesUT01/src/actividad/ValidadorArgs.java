package actividad;

public class ValidadorArgs {

    public static void main(String[] args) {
        
        if (args.length < 1) {
            System.exit(1);
        }
        
        String arg = args[0];
        
        try {
            int numero = Integer.parseInt(arg);
            
            if (numero < 0) {
                System.exit(3);
            } else {
                System.exit(0);
            }
            
        } catch (NumberFormatException e) {
            System.exit(2); 
        }
    }
}
