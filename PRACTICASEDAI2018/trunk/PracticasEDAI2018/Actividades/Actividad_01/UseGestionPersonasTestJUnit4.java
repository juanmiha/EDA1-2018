package org.eda1.actividad01;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class UseGestionPersonasTestJUnit4 {

	@Test
	public void testPersona(){
		Persona p1 = new Persona("Abraham", "1");
		Persona p2 = new Persona("Joaquin", "2");
		Persona p3 = new Persona("Abraham", "1");

		assertEquals(p1.toString(), "Abraham [1]");
		assertTrue(p1.equals(p3));
		assertFalse(p1.equals(p2));
		assertTrue(p1.compareTo(p2) < 0);
		assertTrue(p1.compareTo(p3) == 0);
		assertTrue(p2.compareTo(p1) > 0);

		p1 = p2 = p3 = null;
	}

	@Test
	public void ComparatorPersonaTest(){
		Persona p1 = new Persona("Abraham", "5");
		Persona p2 = new Persona("Julian", "3");
		Persona p3 = new Persona("Abraham","1");
		Persona p4 = new Persona("Jaime", "6");
		Persona p5 = new Persona("Elisa", "3");

		ArrayList<Persona> aList = new ArrayList<Persona>();
		aList.add(p1);
		aList.add(p2);
		aList.add(p3);
		aList.add(p4);
		aList.add(p5);

		assertEquals(aList.toString(), "[Abraham [5], Julian [3], Abraham [1], Jaime [6], Elisa [3]]");
		aList.sort(null);
		assertEquals(aList.toString(), "[Abraham [1], Abraham [5], Elisa [3], Jaime [6], Julian [3]]");
		aList.sort(new ComparatorPersona("nombre", true));
		assertEquals(aList.toString(), "[Abraham [1], Abraham [5], Elisa [3], Jaime [6], Julian [3]]");
		aList.sort(new ComparatorPersona("nombre", false));
		assertEquals(aList.toString(), "[Julian [3], Jaime [6], Elisa [3], Abraham [1], Abraham [5]]");
		aList.sort(new ComparatorPersona("cod", true));
		assertEquals(aList.toString(), "[Abraham [1], Elisa [3], Julian [3], Abraham [5], Jaime [6]]");
		aList.sort(new ComparatorPersona("cod", false));
		assertEquals(aList.toString(), "[Jaime [6], Abraham [5], Elisa [3], Julian [3], Abraham [1]]");

		p1 = p2 = p3 = p4 = p5 = null;
	}
	@Test
	public void GestionPersonas(){
		GestionPersonas gp = new GestionPersonas();
		Persona p1 = new Persona("Abraham", "5");
		Persona p2 = new Persona("Julian", "3");
		Persona p3 = new Persona("Abraham","1");
		Persona p4 = new Persona("Julian", "3");
		Persona p5 = new Persona("Jaime", "6");
		Persona p6 = new Persona("Elisa", "3");

		gp.add(p1);
		gp.add(p2);
		gp.add(p3);
		gp.add(p4);
		gp.add(p1);
		gp.add(p5);
		gp.add(p6);

		assertTrue(gp.size() == 5);
		assertEquals(gp.toString(), "[Abraham [5], Julian [3], Abraham [1], Jaime [6], Elisa [3]]");

		p1 = p2 = p3 = p4 = p5 = p6 = null;
		gp = null;
	}

	@Test
	public void GestionPersonasSortTest(){
		GestionPersonas gp = new GestionPersonas();
		String sorted1, sorted2, sorted3;
		Persona p1 = new Persona("Abraham", "5");
		Persona p2 = new Persona("Julian", "3");
		Persona p3 = new Persona("Abraham","1");
		Persona p4 = new Persona("Jaime", "6");
		Persona p5 = new Persona("Elisa", "3");

		gp.add(p1);
		gp.add(p2);
		gp.add(p3);
		gp.add(p4);
		gp.add(p5);

		assertTrue(gp.size() == 5);

		gp.shuffle(); ////Desordenamos el array
		gp.sort1("nombre", true);
		sorted1 = gp.toString();
		
		gp.shuffle(); 
		gp.sort2("Nombre", true);
		sorted2 = gp.toString();
		
		gp.shuffle();
		gp.sort3("Nombre", true);
		sorted3 = gp.toString();

		assertEquals(sorted1, sorted2, sorted3);


		gp.shuffle();
		gp.sort1("Cod", true);
		sorted1 = gp.toString();
		
		gp.shuffle(); 
		gp.sort2("Cod", true);
		sorted2 = gp.toString();
		
		gp.shuffle(); 
		gp.sort3("Cod", true);
		sorted3 = gp.toString();

		assertEquals(sorted1, sorted2, sorted3);

		gp.shuffle();
		gp.sort1("cod", false);
		sorted1 = gp.toString();
		
		gp.shuffle(); 
		gp.sort2("cod", false);
		sorted2 = gp.toString();
		
		gp.shuffle(); 
		gp.sort3("cod", false);
		sorted3 = gp.toString();

		assertEquals(sorted1, sorted2, sorted3);

		gp = null;
		p1 = p2 = p3 = p4 = p5 = null;
		sorted1 = sorted2 = sorted3 = null;
	}
	
	@Test
	public void testTiempoEjecucion(){
		final int NUMEXPERIMENTOS = 10;
		final int NUMPERSONAS = 1000; //Probad con 10000, 100000 y...1000000
		long tSort, tSortHeap;
		
		ArrayList<Persona> aList = new ArrayList<Persona>();
		
		for (int i=0; i<NUMPERSONAS; i++){
			aList.add(new Persona(" Persona #" + String.format("%d", i), String.format("%.4f",Math.random())));
		}

		for (int i = 0; i<NUMEXPERIMENTOS; i++){
			Collections.shuffle(aList); //desordenamos el array
			
			tSort = System.nanoTime();
			aList.sort(new ComparatorPersona("nombre", true));
			tSort = System.nanoTime() - tSort;
			
			
			Collections.shuffle(aList); //desordenamos el array
			
			tSortHeap = System.nanoTime();
			Heap.sort(aList, new ComparatorPersona("nombre", true));
			tSortHeap = System.nanoTime() - tSortHeap;
			
			System.out.println("Experimento #" + (i+1));
			System.out.println("Tiempo de ejecucion mergeSort: " + tSort/1e6 + " s");
			System.out.println("Tiempo de ejecucion sortHeap: " + tSortHeap/1e6 + "s\n---------------");
		}
		//Calcular tiempo medio...y realizar una gráficas en excel con los resultados obtenidos con los dos algoritmos de ordenación para los diferentes tamaños del conjunto de entrada 
	}
}
