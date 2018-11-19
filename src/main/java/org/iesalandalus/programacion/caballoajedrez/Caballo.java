
/*
 * Actividad 11
 * Se crea la clase Caballo en el paquete org.iesalandalus.programacion.caballoajedrez
 * 
 * Actividad 12
 * Se crean los métodos get y set
 * 
 * Actividad 13
 * Se crea un constructor por defecto para un caballo negro en la posición 8B.
 * 
 * Actividad 14
 * Se crea un constructor que solicite el color y posicione el caballo según el color.
 * */
package org.iesalandalus.programacion.caballoajedrez;

public class Caballo {
	/*Atributos*/
	private Color color;
	private Posicion posicion;
	
	/*Constructores*/
	
	/**
	 * Crea un caballo negro en la posición 8B.
	 * @throws IllegalArgumentException Si no es posible crearlo en la posición 8B.
	 */
	public Caballo() throws IllegalArgumentException {
		this.color = Color.NEGRO;
		this.posicion = new Posicion(8, 'b');
	}
	
	/**
	 * Crea un nuevo caballo y asigna su posición en el tablero dependiendo de su color.
	 * Blanco: 1b
	 * Negro: 8b
	 * @param color El color del nuevo caballo.
	 * @throws IllegalArgumentException Cuando se suministra un parámetro que apunte a null.
	 */
	public Caballo(Color color) throws IllegalArgumentException {
		//Comprobamos que el parámetro no es nulo.
		if(color == null) throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		else {
			//Asignamos el color
			this.color = color;
			
			//Depende del color asignamos una posición u otra
			if (this.color == Color.BLANCO) {
				this.posicion = new Posicion(1, 'b');
			} else {
				this.posicion = new Posicion(8,'b');
			}
		}
	}
	
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
