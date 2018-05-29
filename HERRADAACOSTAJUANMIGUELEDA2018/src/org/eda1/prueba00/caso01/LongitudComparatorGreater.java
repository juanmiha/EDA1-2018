package org.eda1.prueba00.caso01;

import java.util.Comparator;

public class LongitudComparatorGreater implements Comparator<Palabra> {

	@Override
    public int compare(Palabra p1, Palabra p2)
    {
		if(p1.getLongitud()>p2.getLongitud()){
			return -1;
		}
		if(p1.getLongitud()<p2.getLongitud()){
			return 1;
		}
		return 0;
    }
}
