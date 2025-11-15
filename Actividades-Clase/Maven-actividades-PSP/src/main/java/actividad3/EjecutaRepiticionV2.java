package actividad3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EjecutaRepiticionV2 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Pedir la cadena al usuario
        System.out.print("Introduzca la cadena: ");
        String cadena = scanner.nextLine();
        
        try {
        	String classPath = "target/classes";
        	
            // Preparar el comando con el argumento
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPath, "actividad3.RepiteCadena", cadena);
            
            // Redirigir la salida de error al stream de salida estándar
            //pb.redirectErrorStream(true);
            
            //EN ESTE CASO NO REDIRIGIMOS LA SALIDA DE ERROR
            
            // Ejecutar el proceso
            Process proceso = pb.start();
            
            // Leer la salida del proceso            
            BufferedReader leeHijo = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            try {
                while ( (linea = leeHijo.readLine() ) != null ) {
                    System.out.println(linea);
                }
            } finally {
                leeHijo.close();
            }
            
            // OBTENER LOS POSIBLES ERRORES
    		try {
    			InputStream errorStream = proceso.getErrorStream();
    			BufferedReader bufferError = new BufferedReader(new InputStreamReader(errorStream));
    			String liner = null;
    			while ((liner = bufferError.readLine()) != null)
    				System.out.println("ERROR >" + liner);
    		} catch (IOException ioe) {
    			ioe.printStackTrace();
    		}
         
           
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
