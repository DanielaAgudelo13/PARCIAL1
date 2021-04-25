package control;

import modelo.Logica;
import processing.core.PApplet;

public class Controlador {

	private PApplet app;
	private Logica logica;

	public Controlador(PApplet app) {

		this.app = app;
		this.logica = new Logica (app);
		
	}
	
	public void cargarDatos () {
		logica.cargarPerros();
	}
	
	public void pintar () {
		logica.pintar();
	}
	
	public void presionarTecla() {
		logica.presionarTecla();
	}

}

	