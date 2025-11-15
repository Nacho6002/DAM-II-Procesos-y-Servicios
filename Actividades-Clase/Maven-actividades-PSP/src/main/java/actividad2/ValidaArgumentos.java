package actividad2;

public class ValidaArgumentos {

	public static void main(String[] args) {
		
        // Caso 1: No hay argumentos
        if (args.length < 1) {
            System.out.println("No se proporcionaron argumentos.");
            System.exit(1);
        }

        String argumento = args[0];
        
        try {
            // Intentar convertir el argumento a número
            int numero = Integer.parseInt(argumento);
            
            // Caso 3: Número menor que 0
            if (numero < 0) {
                System.out.println("EL arguemento es un número menor que 0: " + numero);
                System.exit(3);
            }
            
            // Caso 0: Número mayor o igual que 0
            System.out.println("En cualquier otra situación: " + numero);
            System.exit(0);
            
        } catch (NumberFormatException e) {
            // Caso 2: Es una cadena (no se pudo convertir a número)
            System.out.println("CADENA: " + argumento);
            System.exit(2);
        }
    }

}
