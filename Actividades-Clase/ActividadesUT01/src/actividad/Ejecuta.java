package actividad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejecuta {

    public static void main(String[] args) {
        
        if (args.length == 0) {
            System.err.println("Error: Se necesita al menos un comando a ejecutar.");
            return;
        }
        
        ProcessBuilder pb = new ProcessBuilder(args);
        
        pb.inheritIO();
        
        try {
            System.out.println("Iniciando comando: " + String.join(" ", args));
            Process p = pb.start();
            
            int exitValue = p.waitFor();
            
            if (exitValue == 0) {
                System.out.println("\nEl comando finalizó correctamente.");
            } else {
                System.out.println("\nSe produjo una anomalía. Valor de salida: " + exitValue);
            }
            
        } catch (IOException e) {
            System.err.println("Error al iniciar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("El proceso padre fue interrumpido: " + e.getMessage());
        }
    }
}
