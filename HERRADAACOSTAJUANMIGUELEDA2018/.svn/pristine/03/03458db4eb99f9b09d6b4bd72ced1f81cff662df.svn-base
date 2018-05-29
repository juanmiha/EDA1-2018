package org.eda1.prueba00.caso03;

import java.util.Comparator;

public class IPContComparatorLess implements Comparator<Maquina> {

	@Override
    public int compare(Maquina m1, Maquina m2)
    {
		int comparator = Integer.compare(m1.getNumIps(), m2.getNumIps());
		if(comparator != 0) return comparator;
		return m1.compareTo(m2);
    }
}
