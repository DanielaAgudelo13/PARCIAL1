package modelo;

import java.util.Date;

import processing.core.PApplet;
import processing.core.PImage;

public class Perro {

	private PApplet app;
	private Date fecha ;
	private PImage img;
	private String raza;
	private String nombre;
	private int id;

	
	public Perro(PApplet app, Date fecha, PImage img, String raza, String nombre, int id) {
		this.app = app;
		this.fecha = fecha;
		this.img = img;
		this.raza = raza;
		this.nombre = nombre;
		this.id = id;
	}
	
	public void pintar (int posX, int posY) {
		app.fill(0, 0, 0);
		app.rect(posX, posY, 600, 100);
		app.fill(255);
		app.textSize(20);
		app.textAlign(app.LEFT, app.TOP);
		app.text("Id: " + id, posX + 5, posY + 5);
		app.text("Nombre: " + nombre, posX + 5, posY + 25);
		app.text("Raza: " + raza, posX + 5, posY + 45);
		app.text("Fecha: " + fecha, posX + 5, posY + 65);
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public PImage getImg() {
		return img;
	}

	public void setImg(PImage img) {
		this.img = img;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	} 
	
	
}
