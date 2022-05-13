package jcolonia.daw2021.mayo;

import java.util.Scanner;
import static java.lang.System.out;
public class VistaMenúBásico extends Vista {
	String [] opcionesMenúPrincipal;
	int opciónElegida;
	public VistaMenúBásico(String título, Scanner scEntrada, String[] opcionesMenúPrincipal) {
		super(título, scEntrada);
		this.opcionesMenúPrincipal = opcionesMenúPrincipal;
		opciónElegida = 0;
	}


	public void mostrarOpciones() {
		int i=1;
		for(String texto:opcionesMenúPrincipal) {
			Vista.mostrarTexto(i +". "+ texto);
			i++;
		}
		
		
	}
	
	public int pedirOpción() {
		String lineaTexto;
		boolean numEsCorrecto = false;
		
		out.println("Introduce la opcion del menu elegida.");
		while (!numEsCorrecto) {
			try {
				lineaTexto = getEntrada().nextLine();
				opciónElegida = Integer.parseInt(lineaTexto);
				if (opciónElegida < 0 || opciónElegida > opcionesMenúPrincipal.length) {
					out.println("No ha elegido una opcion valida.\n");
				}else{
					numEsCorrecto = true;
				}
			}catch (NumberFormatException ex){
				out.printf("No es una de las opciones validas %s%n", ex.getMessage());
			}
		}

		return opciónElegida;
	}

}
