package modelo;

import java.util.Comparator;

public class SortNombre implements Comparator <Perro> {

	public int compare(Perro o1, Perro o2) {
		// TODO Auto-generated method stub
		return o1.getNombre().compareTo(o2.getNombre());
	}
	

}
