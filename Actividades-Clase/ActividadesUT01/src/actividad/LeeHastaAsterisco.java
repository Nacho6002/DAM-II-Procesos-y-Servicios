package actividad;

import java.util.Scanner;

public class LeeHastaAsterisco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String linea = "";
        
        System.out.println("Soy el hijo. Escribe líneas. Escribe '*' para parar.");
        
        while (true) {
            linea = scanner.nextLine();
            
            if (linea.equals("*")) {
                break;
            }
            
            System.out.println("Hijo recibe: " + linea); 
        }
        
        System.out.println("Hijo termina.");
        scanner.close();
    }
}
