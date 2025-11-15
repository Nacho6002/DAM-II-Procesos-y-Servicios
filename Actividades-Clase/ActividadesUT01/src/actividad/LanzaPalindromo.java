package actividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class LanzaPalindromo {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce una cadena para ver si es palíndromo: ");
        String cadena = scanner.nextLine();
        scanner.close();

        String javaBin = System.getProperty("java.home") + "/bin/java";
        String classpath = System.getProperty("java.class.path");
        String className = ValidaPalindromo.class.getName();
        
        ProcessBuilder pb = new ProcessBuilder(javaBin, "-cp", classpath, className);
        
        try {
            Process p = pb.start();
            
            PrintWriter writer = new PrintWriter(p.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            writer.println(cadena);
            writer.close();

            String lineaRespuesta = reader.readLine();
            
            System.out.println("Respuesta del hijo: " + lineaRespuesta);
            
            reader.close();
            p.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}