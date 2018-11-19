/*
 * Actividad 05
 * Se crea la clase en el paquete indicado en el esquema de la tarea
 * 
 * Actividad 06
 * Se crean los m�todos get y set
 * 
 * Actividad 07
 * Se crea un constructor
 * 
 * Actividad 08
 * Se crea un constructor de copia
 * 
 * Actividad 09
 * Se sobreescriben los métodos equals() y hashCode().
 * 
 * Actividad 10
 * Se sobreescribe el método toString().
 * */
package org.iesalandalus.programacion.caballoajedrez;

/**
 * Esta clase determina y modifa la posici�n de la pieza del
 * caballo en un tablero de ajedrez.
 * @author asanrom
 *
 */
public class Posicion {
	/*Lista de Atributos*/
	private int fila;
	private char columna;
	
	/*Constructores*/
	
	/**
	 * Crea una instancia de la clase con los valores suministrados como par�metros.
	 * @param fila El valor de la fila de la pieza a crear (1-8).
	 * @param columna El valor de la columna de la pieza a crear (a-h).
	 * @throws IllegalArgumentException Cuando se pasan valores inadecuados.
	 */
	public Posicion(int fila, char columna) throws IllegalArgumentException {
		//Se llaman a los m�todos de la clase con las validaciones
		this.setFila(fila);
		this.setColumna(columna);
	}
	
	/**
	 * Constructor de copia de la clase.
	 * @param posicion La instancia de la clase que se quiere duplicar.
	 * @throws IllegalArgumentException Cuando se pasa un valor que apunta a null.
	 */
	public Posicion(Posicion posicion) throws IllegalArgumentException {
		//Se verifica que el parámetro no sea nulo.
		if(posicion == null) throw new IllegalArgumentException();
		else {
			//Se copian los valores de la posición suministrada.
			this.fila = posicion.getFila();
			this.columna = posicion.getColumna();
		}
	}
	
	/*M�todos set y get*/
	
	/**
	 * Determina la fila actual de la pieza.
	 * El nuevo valor debe estar comprendido entre 1 y 8, ambos incluidos.
	 * @param fila Un valor entre 1 y 8.
	 * @throws IllegalArgumentException Cuando se introduce un valor incorrecto.
	 */
	public void setFila(int fila) throws IllegalArgumentException {
		//Se comprueba que el valor es correcto
		if(fila < 0 || fila > 8) {
			//Si es incorrecto sale con una excepci�n.
			throw new IllegalArgumentException("ERROR: Fila no válida.");
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
		//Validaci�n del par�metro.
		
		/* Seg�n la tabla ascii los tramos v�lidos para las letras comprendidas
		 * de la 'a' a la 'h', may�sculas y min�sculas son los rangos 65-72 y
		 * 97-104
		 */
		if ((columna < 65 || columna > 72) && (columna < 97 || columna > 104)) {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
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
	
	/*Métodos Override*/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columna;
		result = prime * result + fila;
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		if (columna != other.columna)
			return false;
		if (fila != other.fila)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[fila=" + this.fila + ", columna=" + this.columna + "a]";
	}
}
