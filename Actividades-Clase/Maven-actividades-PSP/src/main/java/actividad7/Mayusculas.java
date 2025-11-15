package actividad7;

import java.util.Scanner;

public class Mayusculas {

	public static void main(String[] args) {
		
        // El proceso hijo lee de su entrada estándar
        Scanner scanner = new Scanner(System.in);
        
        // Procesa cada línea mientras haya entrada
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            // Convierte a mayúsculas y envía a la salida estándar
            System.out.println(linea.toUpperCase());
        }
        
        scanner.close();
    }

}
