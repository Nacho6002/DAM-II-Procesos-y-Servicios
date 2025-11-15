package Ejercicio_3;

import java.util.Scanner;

public class EmpleadoInteractivo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("EMPLEADO: Esperando órdenes del Jefe...");
        Scanner walkieTalkie = new Scanner(System.in);
        String orden = walkieTalkie.nextLine();
        //Se queda bloqueado aquí hasta que el Jefe hable
        
        System.out.println("EMPLEADO: ¡Orden recibida! Procesando '" + orden + "'...");
        walkieTalkie.close(); // Cuelga su walkie

        // --- 2. Procesar la orden ---
        if (orden.isEmpty()) {
            // "Grita" por el altavoz de ERRORES
            System.err.println("EMPLEADO: ¡La orden estaba vacía!");
            System.exit(1); // Levanta bandera de error
        }

        // Lógica para ver si es palíndromo
        String limpia = orden.replaceAll("\\s+", "").toLowerCase();
        String invertida = new StringBuilder(limpia).reverse().toString();

        if (limpia.equals(invertida)) {
            // "Grita" por el altavoz NORMAL
            System.out.println("EMPLEADO: Jefe, '" + orden + "' SÍ es un palíndromo.");
            System.exit(0); // Levanta bandera OK
        } else {
            // "Grita" por el altavoz de ERRORES
            System.err.println("EMPLEADO: Jefe, '" + orden + "' NO es un palíndromo.");
            System.exit(2); // Levanta bandera de error
        }
    }
}

