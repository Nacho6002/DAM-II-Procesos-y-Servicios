package Ejercicio_2;

public class EmpleadoValidador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length < 1) {
			System.out.println("EMPLEADO: ¡Jefe, no me dio ningún número!");
			
			System.exit(1);
		}
		
		String argumento = args[0];
		
		try {
			//Intento convertir el argumento en un numero
			int numero = Integer.parseInt(argumento);
			
			if(numero < 0) {
				System.out.println("EMPLEADO: El número " + numero + " es negativo.");
				
				System.exit(2);
			}
			
			System.out.println("EMPLEADO: El número " + numero + " es válido. ¡Terminé!");
			System.exit(0);
			//Todo a ido bien
			
		}catch (NumberFormatException e) {
			//Si fallo el parseInt es porque dieron una letra
			System.out.println("EMPLEADO: ¡Jefe, '" + argumento + "' no es un número!");
			System.exit(3);
		}
	}

}
