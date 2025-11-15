package actividad;

import java.util.Scanner;

public class MayusculasHijo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            
            System.out.println(linea.toUpperCase());
        }
        
        scanner.close();
    }
}