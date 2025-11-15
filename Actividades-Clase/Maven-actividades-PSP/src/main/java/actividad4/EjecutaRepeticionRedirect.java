package actividad4;

import java.util.Scanner;
import java.io.File;

public class EjecutaRepeticionRedirect {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Pedir la cadena al usuario
        System.out.print("Introduzca la cadena: ");
        String cadena = scanner.nextLine();
        
        try {
        	String classPath = "target/classes";
        	
            // Crear archivos para la salida estándar y de error
            File salidaFile = new File("salida.txt");
            File errorFile = new File("error.txt");
            
            // Preparar el comando con el argumento y redirigir la salida
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPath, "actividad4.RepiteCadenaRedirect", cadena);
            pb.redirectOutput(salidaFile);
            pb.redirectError(errorFile);
            
            // Ejecutar el proceso
            Process proceso = pb.start();
            
            // Esperar a que termine y obtener el código de salida
            int codigoSalida = proceso.waitFor();
            
            // Mostrar el resultado según el código de salida
            System.out.println("Valor de Salida: " + codigoSalida);
            if (codigoSalida == 0) {
                System.out.println("FINAL CORRECTO...");
            } else {
                System.out.println("FINAL INCORRECTO...");
            }
            
        } catch (Exception e) {
            System.err.println("Error al ejecutar el programa: " + e.getMessage());
            System.exit(1);
        } finally {
            scanner.close();
        }
    }
}
