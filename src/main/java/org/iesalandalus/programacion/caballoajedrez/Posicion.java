/*
 * Actividad 05
 * Se crea la clase en el paquete indicado en el esquema de la tarea
 * */
package org.iesalandalus.programacion.caballoajedrez;

/**
 * Esta clase determina y modifa la posición de la pieza del
 * caballo en un tablero de ajedrez.
 * @author asanrom
 *
 */
public class Posicion {
	/*Lista de Atributos*/
	private int fila;
	private char columna;
	
	/*Métodos set y get*/
	
	/**
	 * Determina la fila actual de la pieza.
	 * El nuevo valor debe estar comprendido entre 1 y 8, ambos incluidos.
	 * @param fila Un valor entre 1 y 8.
	 * @throws IllegalArgumentException Cuando se introduce un valor incorrecto.
	 */
	public void setFila(int fila) throws IllegalArgumentException {
		//Se comprueba que el valor es correcto
		if(fila < 0 || fila > 8) {
			//Si es incorrecto sale con una excepción.
			throw new IllegalArgumentException("ERROR: Las filas van de 1 a 8.");
		} else {
			this.fila = fila;
		}
	}
	
	/**
	 * Obtiene el valor actual para la fila de la pieza.
	 * @return Un entero con el valor de la fila.
	 */
	public int getFila() {
		return this.fila;
	}
	
	/**
	 * Determina la columna actual de la pieza en el tablero.
	 * @param columna El nuevo valor de la columna.
	 * @throws IllegalArgumentException Cuando se introduce un valor inadecuado.
	 */
	public void setColumna(char columna) throws IllegalArgumentException {
		//Validación del parámetro.
		
		/* Según la tabla ascii los tramos válidos para las letras comprendidas
		 * de la 'a' a la 'h', mayúsculas y minúsculas son los rangos 65-72 y
		 * 97-104
		 */
		if ((columna < 65 || columna > 72) && (columna < 97 || columna > 104)) {
			throw new IllegalArgumentException("ERROR: Las columnas van de la 'A' a la 'H'.");
		} else {
			this.columna = columna;
		}
	}
	
	/**
	 * Obtiene el valor actual de la columna de la pieza.
	 * @return Una letra con el valor de la columna.
	 */
	public char getColumna() {
		return this.columna;
	}
}
