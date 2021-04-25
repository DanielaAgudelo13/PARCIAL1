package vista;

import control.Controlador;
import processing.core.PApplet;

public class Main extends PApplet {
	
	private Controlador controlador;
	

	public static void main(String[] args) {
		PApplet.main("vista.Main");

	}

	public void settings() {
		size(600, 600);
	}

	public void setup() {
		controlador = new Controlador (this);
		controlador.cargarDatos();
	}

	public void draw() {
		background(255);
		controlador.pintar();
	}

	public void mousePressed() {
	}
	
	public void keyPressed() {
		controlador.presionarTecla();
	}

}
