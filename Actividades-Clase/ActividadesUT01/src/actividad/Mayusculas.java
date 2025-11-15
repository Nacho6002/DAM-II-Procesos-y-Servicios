package actividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Mayusculas {

    public static void main(String[] args) {
        
        String javaBin = System.getProperty("java.home") + "/bin/java";
        String classpath = System.getProperty("java.class.path");
        String className = MayusculasHijo.class.getName();

        ProcessBuilder pb = new ProcessBuilder(javaBin, "-cp", classpath, className);
        
        try {
            Process p = pb.start();
            
            PrintWriter writer = new PrintWriter(p.getOutputStream());
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            Scanner scannerPadre = new Scanner(System.in);
            
            System.out.println("Escribe texto. Escribe 'fin' para terminar.");
            String lineaPadre = "";
            
            while (true) {
                lineaPadre = scannerPadre.nextLine();
                
                writer.println(lineaPadre);
                writer.flush(); 
                
                if (lineaPadre.equalsIgnoreCase("fin")) {
                    break;
                }
                
                String lineaHijo = reader.readLine();
                System.out.println("Recibido: " + lineaHijo);
            }
            
            System.out.println("Finalizando...");
            scannerPadre.close();
            writer.close();
            reader.close();
            p.waitFor();
            System.out.println("Programa terminado.");
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
