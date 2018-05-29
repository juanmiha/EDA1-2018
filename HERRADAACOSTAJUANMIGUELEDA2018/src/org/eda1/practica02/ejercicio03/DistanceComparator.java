package org.eda1.practica02.ejercicio03;

import java.util.Comparator;

public class DistanceComparator implements Comparator<PalabraDistancia>
{
    @Override
    public int compare(PalabraDistancia x, PalabraDistancia y){
    	if(x.getDistancia()==y.getDistancia()){
			return  x.getPalabra().compareTo(y.getPalabra());
		}
		return (x.getDistancia() > y.getDistancia())? 1: -1;
    }
}
