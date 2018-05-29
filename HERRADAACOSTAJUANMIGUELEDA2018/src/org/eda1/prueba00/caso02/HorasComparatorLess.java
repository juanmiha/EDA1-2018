package org.eda1.prueba00.caso02;

import java.util.Comparator;

public class HorasComparatorLess implements Comparator<Trabajador> {

	@Override
    public int compare(Trabajador t1, Trabajador t2)
    {
		if(t1.horasMes()>t2.horasMes())
			return 1;
		if(t1.horasMes()<t2.horasMes())
			return -1;
		return t1.compareTo(t2);
    }
}
