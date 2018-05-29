package org.eda1.prueba00.caso01;

import java.util.Comparator;

public class MediaComparatorGreater implements Comparator<Palabra> {

	@Override
	public int compare(Palabra p1, Palabra p2)
    {
		Double mediaP1 = (double) (p1.getLongitud()+p1.getFrecuencia())/2;
		Double mediaP2 = (double) (p2.getLongitud()+p2.getFrecuencia())/2;
		if (mediaP1 > mediaP2){
			return -1;
		}
		if (mediaP1 < mediaP2){
			return 1;
		}
		return 0;

    }
}
