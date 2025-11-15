package actividad3;

public class RepiteCadena {

	 public static void main(String[] args) {
		 
	        // Verificar si hay argumentos y si el primero no está vacío
	        if (args.length == 0 || args[0].trim().isEmpty()) {
	            System.out.println("CADENA VACIA...");
	            System.exit(1);
	        }

	        // Mostrar la cadena 5 veces
	        String cadena = args[0];
	        for (int i = 1; i <= 5; i++) {
	            System.out.println(i + ". " + cadena);
	        }
	        
	        System.exit(0);
	    }

}
