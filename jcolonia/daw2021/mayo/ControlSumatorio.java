package jcolonia.daw2021.mayo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Gestión de números «decimales»: recogida y visualización de la suma.
 * 
 * @versión 2022.3.1
 * @author <a href="dmartin.jcolonia@gmail.com">David H. Martín</a>
 */
public class ControlSumatorio {
	/**
	 * Texto identificativo de las funciones de la aplicación que aparecerán en el
	 * menú principal.
	 */
	private static final String[] OPCIONES_MENÚ_PRINCIPAL = { "Agregar valor", "Mostrar valores", "Mostrar suma",
			"Restablecer", "SALIR" };

	/**
	 * Título de la aplicación. Se mostrará como encabezado del menú principal.
	 */
	private static final String TÍTULO_MENÚ_PRINCIPAL = "Sumatorio";

	/**
	 * Recurso asociado a la entrada estándar de la aplicación. Debe ser un objeto
	 * único a compartir con las diferentes vistas creadas.
	 */
	private Scanner entrada;

	private ListaNúmeros conjunto = new ListaNúmeros();;

	private VistaMenúBásico menúPrincipal;
	
	String texto;
	ArrayList <String> listaString;
	ArrayList <Double> listaNums = new ArrayList <Double>();
	public ControlSumatorio(Scanner in) {
		this.entrada = in;

		listaString = new ArrayList<String>();
	}

	private void buclePrincipal() throws SumatorioNumberException {
		int opciónElegida;
		boolean fin = false;

		menúPrincipal = new VistaMenúBásico(TÍTULO_MENÚ_PRINCIPAL, entrada, OPCIONES_MENÚ_PRINCIPAL);

		// Bucle general
		do {
			menúPrincipal.mostrarTítulo1();
			menúPrincipal.mostrarOpciones();
			opciónElegida = menúPrincipal.pedirOpción();
			switch (opciónElegida) {
			case 5: // SALIR
				fin = true;
				Vista.mostrarAviso("¡¡¡A-D-I-O-S!!");
				break;
				
			case 1: cargarSumando();
					break;
				
			case 2:  mostrarSumandos();
					break;
				
			case 3: mostrarSuma();
				break;
			case 4:
			restablecer();
				break;
			default: // Opción no esperada: abortar
				ejecutarGenérico(opciónElegida);
				System.err.println("Error interno de programa - operación pendiente de desarrollo");
				System.exit(1);
			}
		} while (!fin);
	}

	



	private void restablecer() {
		conjunto.restablecerListas();
	}

	public void cargarSumando() throws SumatorioNumberException {
		VistaAltas cargarNum = new VistaAltas(texto, entrada);
		cargarNum.cargarNúmeros();
		listaNums = conjunto.getLista();

	}
	
	public void mostrarSumandos() {
		VistaListado listado = new VistaListado(texto, entrada);
		listado.mostrarListado(conjunto.getLista());
	}
	
	public void mostrarSuma() {
		VistaListado listado = new VistaListado(texto, entrada);
		listado.sumaFormateada();
	}
	private void ejecutarGenérico(int id) {
		String mensaje;
		mensaje = String.format("%n  Ha elegido la opción %d: «%s»", id, OPCIONES_MENÚ_PRINCIPAL[id - 1]);
		Vista.mostrarTexto(mensaje);
	}

	public static void main(String[] args) throws SumatorioNumberException {
		Scanner entrada = new Scanner(System.in);

		ControlSumatorio control = new ControlSumatorio(entrada);
		control.buclePrincipal();
		entrada.close();
	}
}
