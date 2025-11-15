package actividad6;

import java.io.*;
import java.util.Scanner;

public class EjecutaPalindromo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca la cadena: ");
        String cadena = scanner.nextLine();
        scanner.close();

        try {
        	String classPath = "target/classes";        	
        	
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPath, "actividad6.Palindromo");
            Process proceso = pb.start();
            
            // EN ESTE CASO NO LE ENVIAMOS LA CADENA POR LINEA DE COMANDOS
            
            // Enviar la cadena al proceso hijo mediante getOutputStream
            try (PrintWriter pw = new PrintWriter(proceso.getOutputStream())) {
                pw.println(cadena);
            }

            // Leer la salida estándar
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }
            }

            // Leer la salida de error
            try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(proceso.getErrorStream()))) {
                String linea;
                while ((linea = errorReader.readLine()) != null) {
                    System.err.println(linea);
                }
            }

            // Esperar a que termine el proceso
            int codigo = proceso.waitFor();
            System.out.println("Código de salida: " + codigo);

        } catch (Exception e) {
            System.err.println("Error al ejecutar Palindromo: " + e.getMessage());
            System.exit(1);
        }
    }
}
