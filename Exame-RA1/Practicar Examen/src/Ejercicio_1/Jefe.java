package Ejercicio_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jefe {

	public static void main(String[] args) {
		System.out.println("Jefe: Voy a contratar alguien para que eliste los archivos");
		
		try {
			
			ProcessBuilder contrato = new ProcessBuilder("cmd.exe", "/c", "dir");
			
			contrato.redirectErrorStream(true);
			
			Process empleado = contrato.start();
			
			BufferedReader traductor = new BufferedReader(new InputStreamReader(empleado.getInputStream()));
			
			
			String lineaQueDiceEmpleado;
			System.out.println("Aver que dice este empleado...");
			
			while ((lineaQueDiceEmpleado = traductor.readLine()) != null) {
				System.out.println("Empleado dice: " + lineaQueDiceEmpleado);
			}
			
			//waitFor empera a que empleado acabe
			int codigoSalida = empleado.waitFor();
			
			if(codigoSalida == 0) {
				System.out.println("Jefe: Buene trabajo empleado termino correctamente");
			}else {
				System.out.println("Jefe: El empleado termino con errores" + codigoSalida);
			}
			
			
		}catch (IOException | InterruptedException e) {
			System.out.println("Jefe: Error no pude ni contratar al empleado");
			e.printStackTrace();
		}
	}
}
