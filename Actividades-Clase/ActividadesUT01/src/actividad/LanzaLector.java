package actividad;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LanzaLector {

    public static void main(String[] args) {
        
        String javaBin = System.getProperty("java.home") + "/bin/java";
        String classpath = System.getProperty("java.class.path");
        String className = LeeHastaAsterisco.class.getName();

        ProcessBuilder pb = new ProcessBuilder(javaBin, "-cp", classpath, className);
        
        pb.inheritIO();
        
        try {
            Process p = pb.start();
            
            PrintWriter writer = new PrintWriter(p.getOutputStream());
            
            Scanner scannerPadre = new Scanner(System.in);
            
            System.out.println("Soy el padre. Escribe líneas para enviar al hijo. Escribe '*' para parar.");
            
            String linea = "";
            
            while (true) {
                linea = scannerPadre.nextLine();
                
                writer.println(linea);
                writer.flush(); 
                
                if (linea.equals("*")) {
                    break; 
                }
            }
            
            System.out.println("Padre termina.");
            writer.close();
            scannerPadre.close();
            p.waitFor();
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
