package org.eda1.actividad01;

import java.util.ArrayList;
import java.util.Comparator;

public class Heap<T> {

	private static <T> void swap(ArrayList<T> datos, int a, int b){
		T aux = datos.get(a);
		datos.set(a, datos.get(b));
		datos.set(b, aux);
	}

	private static <T extends Comparable<T>> int compare(T a, T b, Comparator<T> comp){
		return (comp == null) ? a.compareTo(b) : comp.compare(a,b);
	}

	private static <T extends Comparable<T>> void siftDown(ArrayList<T> datos, int start, int end, Comparator<T> comp){
		int parent = start, child = (2 * parent) + 1;  // => (2 * parent) + 1
		while (child < end) {
			if (child + 1< end && compare(datos.get(child), datos.get (child + 1), comp) > 0)
				child++; // child es el �ndice derecho
			if (comp.compare(datos.get(child), datos.get(parent)) >= 0)
				break;
			swap(datos, parent, child);
			parent = child;
			child = (2* parent) + 1;
		}
	}

	public static <T extends Comparable<T>> void sort(ArrayList<T> datos, Comparator<T> comp){
		T element;

		for (int i = (datos.size() / 2) - 1; i >= 0; i--) {
			siftDown(datos, i, datos.size(), comp);
		}
		for (int i = datos.size(); (i > 1); i--) {
			element = datos.get(0);
			datos.set(0, datos.get(i - 1));
			datos.set(i - 1, element);
			siftDown(datos, 0 , i -1, comp);
		}

		for (int i = 0; (i < datos.size() / 2); i++) {
			 element = datos.get(i);
			 datos.set(i, datos.get(datos.size() - i -1));
			 datos.set(datos.size() -i -1, element);
		}
	}

}