package modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import javax.print.attribute.SetOfIntegerSyntax;

import processing.core.PApplet;

public class Logica {

	private PApplet app;

	private String[] data1;

	private String[] data2;

	private String ordenActual;

	private ArrayList<Perro> perros = new ArrayList<Perro>();

	public Logica(PApplet app) {

		this.app = app;
		this.data1 = app.loadStrings("../data/TXT1.txt");
		this.data2 = app.loadStrings("../data/TXT2.txt");
		this.ordenActual = "id";
	}

	public void cargarPerros() {
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		for (int i = 2; i < data1.length; i++) {
			String[] line1 = data1[i].split(" ");
			int id = Integer.parseInt(line1[0]);
			String nombre = line1[1];

			Perro perro = new Perro(app, null, null, null, nombre, id);

			for (int j = 1; j < data2.length; j++) {
				String[] line2 = data2[j].split(" ");
				int id2 = Integer.parseInt(line2[0]);
				String raza = line2[1];
				Date fecha;
				if (perro.getId() == id2) {
					try {
						fecha = format.parse(line2[2]);
						perro.setFecha(fecha);
						perro.setRaza(raza);
						perros.add(perro);
						// System.out.println(perro.getId());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		ordenar(ordenActual);
	}

	public void pintar() {
		// System.out.println(perros.size());
		for (int i = 0; i < perros.size(); i++) {
			perros.get(i).pintar(0, 0 + (100 * i));
		}

		app.fill(0);
		app.text("Presiona I para ordenar por Id", 10, 510);
		app.text("Presiona N para ordenar por Nombre", 10, 530);
		app.text("Presiona R para ordenar por Raza", 10, 550);
		app.text("Presiona ENTER para guardar con el orden actual", 10, 570);

	}

	public void presionarTecla() {
		if (app.key == 'i' || app.key == 'I') {
			ordenActual = "id";
		}

		if (app.key == 'n' || app.key == 'N') {
			ordenActual = "nombre";
		}

		if (app.key == 'r' || app.key == 'R') {
			ordenActual = "raza";
		}
		
		if(app.key == app.ENTER) {
			guardarInformacion();
		}
		
		ordenar(ordenActual);
	}

	public void guardarInformacion() {
		String[] datosNuevos = new String[perros.size()];
		for (int i = 0; i < perros.size(); i++) {
			Perro perro = perros.get(i);
			datosNuevos[i] = perro.getId() + " " + perro.getNombre() + " " + perro.getRaza() + " " + perro.getFecha();
			datosNuevos[i].toLowerCase(); //Cambiar letras a minusculas 
		}
		app.saveStrings(app.dataPath("../exports/datos" + ordenActual + ".txt"), datosNuevos);
	}

	public void ordenar(String orden) {
		switch (orden) {
		default:
		case "id":
			Collections.sort(perros, new SortId());
			break;

		case "nombre":
			Collections.sort(perros, new SortNombre());
			break;

		case "raza":
			Collections.sort(perros, new SortRaza());
			break;

		}
	}
}
