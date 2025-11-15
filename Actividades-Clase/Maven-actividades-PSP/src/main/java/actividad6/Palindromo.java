package actividad6;

import java.util.Scanner;

public class Palindromo {
	
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        String cadena = scanner.nextLine();
        scanner.close();

        // Si la cadena está vacía
        if (cadena.isEmpty()) {
            System.err.println("La cadena está vacía");
            System.exit(1);
        }

        // Eliminar espacios y convertir a minúsculas para la comparación
        String cadenaLimpia = cadena.replaceAll("\\s+", "").toLowerCase();
        String cadenaInvertida = new StringBuilder(cadenaLimpia).reverse().toString();

        if (cadenaLimpia.equals(cadenaInvertida)) {
            System.out.println("La cadena '" + cadena + "' ES un palíndromo");
            System.exit(0);
        } else {
            System.err.println("La cadena '" + cadena + "' NO es un palíndromo");
            System.exit(2);
        }
    }
}
