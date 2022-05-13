package jcolonia.daw2021.mayo;


import java.util.ArrayList;
import java.util.Scanner;

public class VistaListado extends Vista {
	ControlSumatorio control = new ControlSumatorio(getEntrada());
	ListaNúmeros conjunto;
	ArrayList<Double> conjuntoLista; 
	public VistaListado(String título, Scanner scEntrada) {
		super(título, scEntrada);
		conjunto = new ListaNúmeros();
		conjuntoLista = new ArrayList<>();
	}
	
	public void mostrarListado(ArrayList<Double> conjuntoLista) {
		
		 for(int i=0;i<conjuntoLista.size();i++) {
			 	String texto;
				texto = conjuntoLista.toString();
				Vista.mostrarTexto(texto);
		 	}
	}
		
	
	
	public void sumaFormateada() {
		conjunto.toString();
	}

}
