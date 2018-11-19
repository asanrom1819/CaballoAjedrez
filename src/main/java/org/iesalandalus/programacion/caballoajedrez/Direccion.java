/*
 * Actividad 04
 * Se crea el Enumerado en el paquete indicado en el esquema de la tarea
 * */
package org.iesalandalus.programacion.caballoajedrez;

/**
 * Enumerado con las posibles direcciones que puede tomar la pieza del
 * caballo en un tablero de ajedrez.
 * @author asanrom
 *
 */
public enum Direccion {
	ARRIBA_IZQUIERDA,
	ARRIBA_DERECHA,
	DERECHA_ARRIBA,
	DERECHA_ABAJO,
	ABAJO_DERECHA,
	ABAJO_IZQUIERDA,
	IZQUIERDA_ARRIBA,
	IZQUIERDA_ABAJO;
}