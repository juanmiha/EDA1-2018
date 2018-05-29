package org.eda1.caso06;

import static org.junit.Assert.*;

import java.io.File;
import java.util.TreeSet;

import org.eda1.edaAuxiliar.AVLTree;
import org.junit.Test;

public class UserTestUnit4 {

		private String 	archivoEntrada = System.getProperty("user.dir") + File.separator +
											"src" + File.separator +
											"org" + File.separator +
											"eda1" + File.separator +
											"caso06" + File.separator+
											"lineas";

		@Test
		public void testDevice() {

			Device e1 = new Device("PC", "00001");
			Device e2 = new Device("Movil", "00010");
			Device e3 = new Device("PS4", "00011");
			Device e4 = new Device("PS3", "00100");

			assertEquals(e1.toString(), "PC (00001)");
			assertEquals(e2.toString(), "Movil (00010)");
			assertEquals(e3.toString(), "PS4 (00011)");

			assertEquals(e1.compareTo(e4), -1);
			assertEquals(e4.compareTo(e2), 1);
			assertEquals(e1.compareTo(new Device("PC","00001")), 0);

			e1 = e2 = e3 = e4 = null;

		}

		@Test
		public void testUser() {
			AVLTree<User> treeUsuario = null;
			User e1 = new User("Alex", new TreeSet<Device>());
			User e2 = new User("Sergio", new TreeSet<Device>());
			User e3 = new User("Manuel", new TreeSet<Device>());
			User e4 = new User("Daniel", new TreeSet<Device>());

			e2.add(new Device("PS4", "01001"));
			e4.add(new Device("PC", "00011"));

			assertEquals(e1.toString(), "Alex:");
			assertEquals(e2.toString(), "Sergio: PS4 (01001)");
			assertEquals(e3.toString(), "Manuel:");

			treeUsuario = new AVLTree<User>();
			treeUsuario.add(e1);
			treeUsuario.add(e2);
			treeUsuario.add(e3);
			treeUsuario.add(e4);

			assertEquals(treeUsuario.toString(), "[Alex:, Daniel: PC (00011), Manuel:, Sergio: PS4 (01001)]");

			assertEquals(e1.interseccion(e2), 0);
			assertEquals(e2.interseccion(e4), 1);

			assertEquals(e1.compareTo(e1), 0);

			boolean tmp = e1.compareTo(e2) < 0;
			assertTrue(tmp);

			e1 = e2 = e3 = e4 = null;
			treeUsuario.clear();
			treeUsuario = null;
		}

		@Test
		public void testBuildNetwork(){
			UserNetwork net = new UserNetwork();
			AVLTree<User> treeUsuario = new AVLTree<User>();

			User e1 = new User("Manuel", new TreeSet<Device>());
			User e2 = new User("Juanjo", new TreeSet<Device>());
			User e3 = new User("Lexicografico", new TreeSet<Device>());

			e1.add(new Device("PS4", "10101"));
			e1.add(new Device("PS3", "01101"));
			e2.add(new Device("PS2", "10101"));
			e2.add(new Device("PC", "11001"));
			e3.add(new Device("Tablet", "11001"));
			e3.add(new Device("Xiaomi", "11000"));

			//Insertamos las estaciones en una estructura arborescente tipo AVL
			treeUsuario.add(e1);
			treeUsuario.add(e2);
			treeUsuario.add(e3);

			//A partir de la estructura arborescente, construimos la red combinando los elementos dos a dos (evitando bucles)
			net.buildNetwork(treeUsuario);

			assertEquals(net.toString(), "{Juanjo: PS2 (10101) PC (11001)={Lexicografico: Xiaomi (11000) Tablet (11001)=8.0, Manuel: PS3 (01101) PS4 (10101)=9.0}, "+
										 "Lexicografico: Xiaomi (11000) Tablet (11001)={Juanjo: PS2 (10101) PC (11001)=8.0, Manuel: PS3 (01101) PS4 (10101)=6.0}, "+
										 "Manuel: PS3 (01101) PS4 (10101)={Juanjo: PS2 (10101) PC (11001)=9.0, Lexicografico: Xiaomi (11000) Tablet (11001)=6.0}}");

			assertTrue(net.containsVertex(new User("Manuel")));

			treeUsuario.clear();
			net.clear();
			treeUsuario = null;
			net = null;
			e1 = e2 = e3 = null;
		}

		@Test
		public void testLoadFile(){
			UserNetwork net= new UserNetwork();
			net.loadFile(archivoEntrada);

			assertTrue(net.numberOfVertices() == 6);
			assertTrue(net.numberOfEdges() == 30);

			//Hay que realizar una pequeña modificacion en el metodo Dijkstra...clase Network.java
			assertEquals(net.Dijkstra(new User("Alex"), new User("Kike")).toString(), "[Alex: Movil (00000) PC (00001) Tablet (00010) PC (01001), Kike: Mac (00110)]");
			assertEquals(net.Dijkstra(new User("Manuel"), new User("Juanjo")).toString(), "[Manuel: PS3 (01010) Xbox360 (01011) XboxONE (01100), Juanjo: PS4 (00100) PC (00101)]");

			net.clear();
			net = null;
		}
	}
