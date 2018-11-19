
/*
 * Actividad 11
 * Se crea la clase Caballo en el paquete org.iesalandalus.programacion.caballoajedrez
 * 
 * Actividad 12
 * Se crean los métodos get y set
 * */
package org.iesalandalus.programacion.caballoajedrez;

public class Caballo {
	/*Atributos*/
	private Color color;
	private Posicion posicion;
	
	/*Métodos get y set*/
	
	/**
	 * Determina la posición actual del caballo.
	 * @param posicion El valor de la nueva posición.
	 * @throws IllegalArgumentException Cuando se suministra un parámetro que apunte a null.
	 */
	private void setPosicion(Posicion posicion) throws IllegalArgumentException {
		//Se valida el parámetro
		if (posicion == null) throw new IllegalArgumentException("La instancia de Posicion apunta a null");
		else {
			this.posicion = posicion;
		}
	}
	
	/**
	 * Obtiene la posición actual del caballo.
	 * @return La posición actual del caballo.
	 */
	public Posicion getPosicion() {
		return this.posicion;
	}
	
	/**
	 * Determina el color del caballo.
	 * @param color El nuevo color para la pieza.
	 * @throws IllegalArgumentException Cuando se pasa por parámetro un color que apunta a null.
	 */
	private void setColor(Color color) throws IllegalArgumentException {
		//Se valida el parámetro para que éste no apunte a null.
		if (color == null) throw new IllegalArgumentException("La instancia de Color apunta a null");
		else {
			this.color = color;
		}
	}
	
	/**
	 * Obtiene el color actual del caballo.
	 * @return El color actual del caballo.
	 */
	public Color getColor() {
		return this.color;
	}
}
