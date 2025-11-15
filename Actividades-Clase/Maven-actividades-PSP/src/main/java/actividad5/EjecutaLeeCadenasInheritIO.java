package actividad5;

public class EjecutaLeeCadenasInheritIO {

	 public static void main(String[] args) {
		 
	        try {
	        	String classPath = "target/classes";
	        	
	            // Crear el proceso hijo
	            ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPath, "actividad5.LeeCadenas");
	            
	            // Heredar la entrada estándar, así como la salida y la salida de error del proceso padre
	            pb.inheritIO();
	            
	            // Iniciar el proceso
	            Process proceso = pb.start();
	            
	            // Esperar a que termine y obtener el código de salida
	            int codigoSalida = proceso.waitFor();
	            
	            // Mostrar el resultado según el código de salida
	            System.out.println("\nProceso terminado con código de salida: " + codigoSalida);
	            
	        } catch (Exception e) {
	            System.err.println("Error al ejecutar el programa: " + e.getMessage());
	            System.exit(1);
	        }
	    }
}
