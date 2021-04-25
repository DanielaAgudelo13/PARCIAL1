package modelo;

import java.util.Comparator;

public class SortRaza implements Comparator <Perro> {

	@Override
	public int compare(Perro o1, Perro o2) {
		// TODO Auto-generated method stub
		return o1.getRaza().compareTo(o2.getRaza());
	}

}
