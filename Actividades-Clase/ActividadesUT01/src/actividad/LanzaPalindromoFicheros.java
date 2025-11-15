package actividad;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class LanzaPalindromoFicheros {

    public static void main(String[] args) {
        
        String ficheroEntrada = "entrada.txt";
        String ficheroError = "error.txt";
        String cadena = "";
         
        try {
            cadena = Files.readString(Path.of(ficheroEntrada));
            cadena = cadena.trim(); 
        } catch (IOException e) {
            System.err.println("Error leyendo fichero " + ficheroEntrada + ": " + e.getMessage());
            return;
        }

        System.out.println("Cadena leída del fichero: " + cadena);
        
        String javaBin = System.getProperty("java.home") + "/bin/java";
        String classpath = System.getProperty("java.class.path");
        String className = ValidaPalindromo.class.getName();
        
        ProcessBuilder pb = new ProcessBuilder(javaBin, "-cp", classpath, className);
        
        pb.redirectError(new File(ficheroError));
        
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
            System.out.println("Proceso terminado. Revisa 'error.txt' si algo falló.");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}