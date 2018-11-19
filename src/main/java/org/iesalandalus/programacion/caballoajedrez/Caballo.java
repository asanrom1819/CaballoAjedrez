
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
 * 
 * Actividad 15
 * Se crea un constructor que solicite el color y la posición de su columna.
 * 
 * Actividad 16
 * Se crea un constructor de copia
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
		this.setColor(Color.NEGRO);
		this.setPosicion(new Posicion(8, 'b'));
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
			this.setColor(color);;
			
			//Depende del color asignamos una posición u otra
			if (this.color == Color.BLANCO) {
				this.setPosicion(new Posicion(1, 'b'));
			} else {
				this.setPosicion(new Posicion(8, 'b'));
			}
		}
	}
	
	/**
	 * Crea un nuevo caballo con el color y la fila indicada. La columna ha de ser 'b' o 'g'.
	 * @param color El color del caballo, determinará su fila.
	 * @param columna La columna del caballo, puede ser 'b' o 'g'.
	 * @throws IllegalArgumentException Si el parámetro color apunta a null o la columna es inadecuada.
	 */
	public Caballo(Color color, char columna) throws IllegalArgumentException {
		//Se comprueba que el color no es nulo.
		if (color == null) throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		//Se comprueba si la columna es válida.
		if (columna != 'g' &&
				columna != 'G' &&
				columna != 'b' &&
				columna != 'B') throw new IllegalArgumentException("ERROR: Columna inicial no válida.");
		
		//Si pasa las comprobaciones
		this.setColor(color);
		
		if (this.color == Color.BLANCO) this.setPosicion(new Posicion(1, columna));
		else this.setPosicion(new Posicion(8, columna));
	}
	
	/**
	 * Crea un nuevo caballo que es copia de otro suministrado como parámetro.
	 * @param caballo El caballo que se quiere duplicar.
	 * @throws IllegalArgumentException Cuando el parámetro suministrado apunta a null.
	 */
	public Caballo(Caballo caballo) throws IllegalArgumentException {
		//Se comprueba el parámetro suministrado
		if (caballo == null) throw new IllegalArgumentException("El parámetros suministrado apunta a null.");
		else {
			this.setColor(caballo.getColor());
			this.setPosicion(new Posicion(caballo.getPosicion()));
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
		if (color == null) throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
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
