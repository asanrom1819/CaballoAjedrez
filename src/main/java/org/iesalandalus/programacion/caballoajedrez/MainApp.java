/*
 * Actividad 20
 * Crear los métodos del diagrama de clases.
 * */
package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	/*Atributos*/
	private static Caballo caballo;
	
	/**
	 * Inicio
	 * @param args Ninguno
	 */
	public static void main(String[] args) {
		//Variables
		int opcion;
		
		System.out.println("Programa para aprender a colocar y mover un caballo en el tablero de ajedrez");
		
		do {
			MainApp.mostrarMenu();
			opcion = MainApp.elegirOpcion();
			MainApp.ejecutarOpcion(opcion);
		} while(opcion != 5);
		
		//Mensaje final
		System.out.println();
		System.out.print("Fin de programa.");
	}
	
	/*Métodos*/
	
	private static void mostrarMenu() {
		//Se muestra el menú general.
		System.out.println("Elige una opción del menú: ");
		System.out.println();
		
		System.out.println("1 - Crear un caballo predeterminado.");
		System.out.println("2 - Crear un caballo eligiendo el color.");
		System.out.println("3 - Crear un caballo eligiendo el color y la columna de inicio.");
		System.out.println("4 - Mueve el caballo.");
		System.out.println("5 - Salir.");
		System.out.println();
		
		//Muestra los datos del caballo actual.
		if(MainApp.caballo ==  null) System.out.println("Aún no has creado ningún caballo.");
		else System.out.println(MainApp.caballo.toString());
		
		System.out.println();
	}
	
	/**
	 * Toma de teclado la decisión del usuario y lo almacena en la clase.
	 * El método valida la respuesta y solo permite valores entre el 1 y el 5.
	 * @return La opción escogida.
	 */
	private static int elegirOpcion() {
		boolean check = false;
		int opcion;
		
		System.out.print("Opción: ");
		
		do {
			opcion = Entrada.entero();
			
			//Validamos la decisión
			if (opcion >= 1 && opcion <= 5) check = true;
			else System.out.print("Escoge una opción del 1 al 5: ");
			
		} while (check == false);
		
		return opcion;
	}
	
	private static void ejecutarOpcion(int opcion) {
		switch(opcion) {
			case 1:
				MainApp.crearCaballoDefecto();
				break;
				
			case 2:
				MainApp.crearCaballoDefectoColor();
				break;
				
			case 3:
				MainApp.crearCaballoColorPosicion();
				break;
				
			case 4:
				MainApp.mover();
				break;
		}
	}
	
	/**
	 * Crea un caballo por defecto y lo situa en la variable de la clase.
	 */
	private static void crearCaballoDefecto() {
		//Trata de crear un caballo por defecto.
		try {
			MainApp.caballo = new Caballo();
		} catch(IllegalArgumentException e) {
			System.out.println("No se ha podido crear el caballo: " + e.getMessage());
		}
	}
	
	/**
	 * Crea y asigna un caballo por defecto según el color.
	 */
	private static void crearCaballoDefectoColor() {
		//Variable
		Color color;
		
		//Se elige el color.
		color = MainApp.elegirColor();
		
		//Intentamos crear el caballo
		try {
			MainApp.caballo = new Caballo(color);
		} catch(IllegalArgumentException e) {
			System.out.println("No se ha podido crear el caballo: " + e.getMessage());
		}
	}
	
	/**
	 * Toma del usuario el color del caballo.
	 * El método valida la decisión y no saldrá hasta que se elija un color adecuado.
	 * @return El color elegido.
	 */
	private static Color elegirColor() {
		//Variable
		boolean check = false;
		int opcion;
		Color color;
				
		//Mensaje
		System.out.println();
		System.out.println("Elige el color del caballo. ");
		System.out.println();
		System.out.println("1 - Caballo blanco.");
		System.out.println("2 - Caballo negro.");
		System.out.println();
		System.out.print("Opción: ");
				
		//Se toma el valor por teclado
		do {
			opcion = Entrada.entero();
					
			//Validamos la decisión
			if (opcion == 1 || opcion == 2) check = true;
			else System.out.print("Escoge una opción del 1 al 2: ");
					
		} while (check == false);
				
		if (opcion == 1) color = Color.BLANCO;
		else color = Color.NEGRO;
		
		return color;
	}
	
	/**
	 * Intenta crear un caballo eligiendo el color y su columna inicial.
	 */
	private static void crearCaballoColorPosicion() {
		//Variable
		Color color;
		char columna;
				
		//Se elige el color.
		color = MainApp.elegirColor();
		
		//Se elige la columna.
		columna = MainApp.elegirColumnaInicial();
				
		//Intentamos crear el caballo
		try {
			MainApp.caballo = new Caballo(color, columna);
		} catch(IllegalArgumentException e) {
			System.out.println("No se ha podido crear el caballo: " + e.getMessage());
		}
	}
	
	/**
	 * Toma del usuario la columna inicial del caballo.
	 * El método valida la decisión y no saldrá hasta que se elija una columna adecuada.
	 * @return Una letra indicando la columna.
	 */
	private static char elegirColumnaInicial() {
		//Variable
		boolean check = false;
		int opcion;
		char columna;
						
		//Mensaje
		System.out.println();
		System.out.println("Elige la columna donde colocar el caballo. ");
		System.out.println();
		System.out.println("1 - Columna izquierda (b).");
		System.out.println("2 - Columna derecha (g).");
		System.out.println();
		System.out.print("Opción: ");
						
		//Se toma el valor por teclado
		do {
			opcion = Entrada.entero();
					
			//Validamos la decisión
			if (opcion == 1 || opcion == 2) check = true;
			else System.out.print("Escoge una opción del 1 al 2: ");
					
		} while (check == false);
					
		if (opcion == 1) columna = 'b';
		else columna = 'g';
				
		return columna;
	}
	
	private static void mover() {
		//Comprobamos si se ha creado un caballo.
		if (MainApp.caballo == null) System.out.println("¡No has creado ningún caballo!");
		else {
			//Tratamos de realizar el movimiento.
			try {
				MainApp.caballo.mover(elegirDireccion());
			} catch(OperationNotSupportedException e) {
				System.out.println("No se ha podido realizar el movimiento: " + e.getMessage());
			}
		}
	}
	
	/**
	 * Muestra el menú con los posibles movimientos para el caballo.
	 */
	private static void mostrarMenuDirecciones() {
		//Muestra el menú con los movimientos del caballo.
		System.out.println("Elige la dirección para mover el caballo.");
		System.out.println();
		System.out.println("1 - Arriba Izquierda.");
		System.out.println("2 - Arriba Derecha.");
		System.out.println("3 - Derecha Arriba.");
		System.out.println("4 - Derecha Abajo.");
		System.out.println("5 - Abajo Derecha.");
		System.out.println("6 - Abajo Izquierda.");
		System.out.println("7 - Izquierda Arriba.");
		System.out.println("8 - Izquierda Abajo.");
		System.out.println();
	}
	
	/**
	 * Toma del usuario la siguiente dirección del caballo.
	 * El método valida la decisión y no saldrá hasta que se elija una opción adecuada.
	 * @return Una dirección definida para el movimiento del caballo.
	 */
	private static Direccion elegirDireccion() {
		//Variable
		boolean check = false;
		int opcion;
		Direccion direccion = null;
		
		//Se muestran las direcciones posibles para el caballo.
		MainApp.mostrarMenuDirecciones();
		
		System.out.print("Opción: ");
								
		//Se toma el valor por teclado
		do {
			opcion = Entrada.entero();
							
			//Validamos la decisión
			if (opcion >= 1 && opcion <= 8) check = true;
			else System.out.print("Escoge una opción del 1 al 8: ");
						
		} while (check == false);
						
		switch(opcion) {
			case 1:
				direccion = Direccion.ARRIBA_IZQUIERDA;
				break;
			
			case 2:
				direccion = Direccion.ARRIBA_DERECHA;
				break;
				
			case 3:
				direccion = Direccion.DERECHA_ARRIBA;
				break;
				
			case 4:
				direccion = Direccion.DERECHA_ABAJO;
				break;
				
			case 5:
				direccion = Direccion.ABAJO_DERECHA;
				break;
				
			case 6:
				direccion = Direccion.ABAJO_IZQUIERDA;
				break;
				
			case 7:
				direccion = Direccion.IZQUIERDA_ARRIBA;
				break;
				
			case 8:
				direccion = Direccion.IZQUIERDA_ABAJO;
		}
						
		return direccion;
	}
}