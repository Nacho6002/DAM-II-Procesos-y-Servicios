package actividad5;

import java.util.Scanner;

public class LeeCadenas {
	
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        String cadena;
        
        System.out.println("Introduce cadenas (escribe * y pulsa ENTER para terminar):");
        
        while (!(cadena = scanner.nextLine()).equals("*")) {
            System.out.println("Cadena leída: " + cadena);
        }
        
        System.out.println("Fin de la entrada");
        scanner.close();
        System.exit(0);
    }
}