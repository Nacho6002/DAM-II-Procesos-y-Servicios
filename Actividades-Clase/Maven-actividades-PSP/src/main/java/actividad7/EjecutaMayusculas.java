package actividad7;

import java.io.*;
import java.util.Scanner;

public class EjecutaMayusculas {
	
    public static void main(String[] args) {
    	
        try {
        	
            //En eclipse apuntamos al directorio de clases
            String classPath = "target/classes";

            // Crear el proceso hijo
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPath, "actividad7.Mayusculas");
            Process proceso = pb.start();
            
            
            BufferedWriter escribirHijo = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()));
            BufferedReader leerHijo = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            
            // Leer de la entrada estándar y enviar al hijo
            System.out.println("Escribe texto (línea vacía para terminar):");
            Scanner scanner = new Scanner(System.in);
            String lineaEntrada;
            
            while (!(lineaEntrada = scanner.nextLine()).isEmpty()) {
            	
                // Enviar la línea al proceso hijo
                String[] palabra = lineaEntrada.split("");
                
                for (String letra : palabra) {
                    escribirHijo.write(letra);
                }
                escribirHijo.write("\n");      
                escribirHijo.flush();
                
                // Leer y mostrar la respuesta del hijo
                String respuesta = leerHijo.readLine();
                if (respuesta != null) {
                    System.out.println("Hijo dice: " + respuesta);
                }
            }
            
            // Cerrar todos los recursos
            escribirHijo.close();
            leerHijo.close();
            scanner.close();
            
            // Esperar a que el hijo termine
            proceso.waitFor();
            
        } catch (Exception e) {
            System.err.println("Error en el proceso: " + e.getMessage());
            System.exit(1);
        }
    }
}
