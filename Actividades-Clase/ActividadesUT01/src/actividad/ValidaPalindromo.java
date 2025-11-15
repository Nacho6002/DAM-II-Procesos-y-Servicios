package actividad;

import java.util.Scanner;

public class ValidaPalindromo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextLine()) {
            String cadena = scanner.nextLine();
            
            String limpia = cadena.replaceAll("\\s+", "").toLowerCase();

            if (limpia.length() == 0) {
                System.out.println("La cadena está vacía");
            } else {
                String reversa = new StringBuilder(limpia).reverse().toString();
                
                if (limpia.equals(reversa)) {
                    System.out.println("SI es palíndromo");
                } else {
                    System.out.println("NO es palíndromo");
                }
            }
        } else {
            System.err.println("Error: El hijo no recibió ninguna cadena.");
        }
        
        scanner.close();
    }
}
