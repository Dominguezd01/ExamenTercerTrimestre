package jcolonia.daw2021.mayo;


import java.util.Scanner;

public class VistaAltas extends Vista {
	String líneaTexto;
	double núm;
	ListaNúmeros conjunto;
	
	public VistaAltas(String título, Scanner scEntrada) {
		super(título, scEntrada);
		conjunto = new ListaNúmeros();
		líneaTexto = "";
		núm = 0.0;
	}
	
	public void cargarNúmeros() throws SumatorioNumberException {
		boolean cargarNumeros = false;
		while(!cargarNumeros) {
			Vista.mostrarTexto("Introduce un valor");
			líneaTexto= getEntrada().nextLine();
			
			núm = Double.parseDouble(líneaTexto);

			conjunto.add(núm);
			cargarNumeros = pedirConfirmación("Pulsa 'S' para salir o 'N' para continuar");
		}

	}
	


}
