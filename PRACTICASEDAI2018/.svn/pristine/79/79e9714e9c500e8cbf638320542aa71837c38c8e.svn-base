package org.eda1.prueba00.caso05;

import static org.junit.Assert.*;

import java.io.File;

import org.eda1.actividad02.AVLTree;
import org.junit.Test;

public class EstacionTestJUnit4 {

	private String 	archivoEntrada = System.getProperty("user.dir") + File.separator +
										"src" + File.separator + 
										"org" + File.separator +
										"eda1" + File.separator + 
										"prueba00" + File.separator +
										"caso05" + File.separator +
										"lineas";
	
	@Test
	public void testEstacion() {
		AVLTree<Estacion> treeEstaciones = null;
		Estacion e1 = new Estacion(1, "Acacias");
		Estacion e2 = new Estacion(0002, "Berna");
		Estacion e3 = new Estacion(004, "Canillas");
		Estacion e4 = new Estacion(03, "Delicias");
		
		assertEquals(e1.toString(), "<E1, Acacias>");
		assertEquals(e2.toString(), "<E2, Berna>");
		assertEquals(e3.toString(), "<E4, Canillas>");
		
		treeEstaciones = new AVLTree<Estacion>();
		treeEstaciones.add(e1);
		treeEstaciones.add(e2);
		treeEstaciones.add(e3);
		treeEstaciones.add(e4);
		
		assertEquals(treeEstaciones.toString(), "[<E1, Acacias>, <E2, Berna>, <E3, Delicias>, <E4, Canillas>]");
		
		//Prueba del metodo toStringWithDetails()
		assertEquals(e1.toStringWithDetails(), "<E1, Acacias> [null, 0.0] --> null");
		
		//Prueba del metodo addDatos()
		treeEstaciones.find(new Estacion(1)).addDatos("Centro", 2000); //equivale a e1.addDatos(...)
		assertEquals(e1.toStringWithDetails(), "<E1, Acacias> [Centro, 2000.0] --> null");
		
		//Prueba del metodo addLineas()
		e1.addLineas(4, 003, 0005, 05, 1);
		assertEquals(e1.toStringWithDetails(), "<E1, Acacias> [Centro, 2000.0] --> [1, 3, 4, 5]");
				
		//Prueba del metodo interseccion()
		e2.addDatos("Carpetana", 342);
		e2.addLineas(3, 5, 00044, 1, 8, 400, 0003, 07);
		
		assertEquals(e1.interseccion(e2).toString(), "[1, 3, 5]");
				
		e1 = e2 = e3 = e4 = null;
		treeEstaciones.clear();
		treeEstaciones = null;
	}
	
	@Test 
	public void testBuildNetwork(){
		EstacionNetwork net = new EstacionNetwork();
		AVLTree<Estacion> treeEstaciones = new AVLTree<Estacion>();
		
		Estacion e1 = new Estacion(1, "Ascao");
		Estacion e2 = new Estacion(2, "Atocha");
		Estacion e3 = new Estacion(3, "Avenida de America");
		
		e1.addLineas(1, 3, 4, 5);
		e2.addLineas(2, 5, 7);
		e3.addLineas(1, 5, 7);
		
		//Insertamos las estaciones en una estructura arborescente tipo AVL
		treeEstaciones.add(e1);
		treeEstaciones.add(e2);
		treeEstaciones.add(e3);
	
		//A partir de la estructura arborescente, construimos la red combinando los elementos dos a dos (evitando bucles)
		net.buildNetwork(treeEstaciones);
		
		assertEquals(net.toString(), "{<E1, Ascao>={<E2, Atocha>=1.0, <E3, Avenida de America>=2.0}, "
				                    + "<E2, Atocha>={<E1, Ascao>=1.0, <E3, Avenida de America>=2.0}, "
				                    + "<E3, Avenida de America>={<E1, Ascao>=2.0, <E2, Atocha>=2.0}}");
	
		assertTrue(net.containsVertex(new Estacion(1)));
		assertTrue(net.containsVertex(new Estacion(1, "Ascao")));
		treeEstaciones.clear();
		net.clear();
		treeEstaciones = null;
		net = null;
		e1 = e2 = e3 = null;
	}
	
	@Test
	public void testLoadFile(){
		EstacionNetwork net= new EstacionNetwork();
		net.loadFile(archivoEntrada);
	
		assertTrue(net.numberOfVertices() == 9);
		assertTrue(net.numberOfEdges() == 34);
		
		//Hay que realizar una pequeña modificacion en el metodo Dijkstra...clase Network.java
		assertEquals(net.Dijkstra(new Estacion(1), new Estacion(7)).toString(), "[<E1, Moncloa>, <E4, Lucia>, <E7, Elipa>]");
		assertEquals(net.Dijkstra(new Estacion(2), new Estacion(9)).toString(), "[<E2, Arguelles>, <E6, Ibiza>, <E9, Aravaca>]");
	
		for (Estacion e : net){
			if (!e.equals(new Estacion(4))) continue;
			assertEquals(e.toString(), "<E4, Lucia>");
			assertEquals(e.toStringWithDetails(),"<E4, Lucia> [Sol, 1560.0] --> [1, 3, 4]");
		}
		net.clear();
		net = null;	
	}
}