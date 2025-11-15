package actividad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjecutaV2 {
	
	    public static void main(String[] args) throws IOException {
	        if (args.length == 0) {
	            System.err.println("Error: Debe proporcionar al menos un comando para ejecutar");
	            System.exit(1);
	        }

	        // Iniciar el proceso
	        Process pb = new ProcessBuilder(args).start();

	        
	        System.out.println("Ejecutando comando: " + String.join(" ", args));
	        

	        //Proceso con exito
	        try {
	            
	            // Leer la salida del proceso
	            BufferedReader reader = new BufferedReader(new InputStreamReader(pb.getInputStream())
	            );
	            
	            String linea;
	            while ((linea = reader.readLine()) != null) {
	                System.out.println(linea);
	            }
	            
	            // Esperar a que el proceso hijo termine
	            int codigoSalida = pb.waitFor();
	            
	            // Verificar si hubo algún error en la ejecución
	            if (codigoSalida != 0) {
	                System.err.println("El proceso hijo terminó con errores. Código de salida: " + codigoSalida);
	            } else {
	                System.out.println("El proceso hijo terminó correctamente");
	            }
	            
	        } catch (Exception e) {
	            System.err.println("Error al ejecutar el comando: " + e.getMessage());
	            System.exit(1);
	        }

	        //Proceso con error
	        try {
	            // Leer la salida erronea del proceso
	             BufferedReader readerError = new BufferedReader(
	               new InputStreamReader(pb.getErrorStream()));
	            
	            
	            String lineaError;
	            while ((lineaError = readerError.readLine()) != null) {
	                System.out.println(lineaError);
	            }
	            
	            // Esperar a que el proceso hijo termine
	            int codigoSalidaError = pb.waitFor();
	            
	            // Verificar si hubo algún error en la ejecución
	            if (codigoSalidaError != 0) {
	                System.err.println("El procesoError hijo terminó con errores. Código de salida: " + codigoSalidaError);
	            } else {
	                System.out.println("El procesoError hijo terminó correctamente");
	            }
	            
	        } catch (Exception e) {
	            System.err.println("Error al ejecutar el comando: " + e.getMessage());
	            System.exit(1);
	        }
	    }

}
