package modelo;

import java.util.Comparator;

public class SortId implements Comparator<Perro> {

	public int compare(Perro o1, Perro o2) {
		// TODO Auto-generated method stub
		return o1.getId() - o2.getId();
	}
}

