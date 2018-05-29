package org.eda1.prueba02;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class UserDevicesTestJUnit4 {

	private String 	archivoEntrada = System.getProperty("user.dir") + File.separator +
										"src" + File.separator +
										"org" + File.separator +
										"eda1" + File.separator +
										"prueba02" + File.separator;

	@Before
	public void init(){
		Parameters.CODE_LENGTH = 10;
		Parameters.NUM_INTERSECTS = 0;
		Parameters.NUM_DEVICES = 0;
		Parameters.NUM_USERS = 0;
	}

	@Test
	public void testDevice() throws Exception {
		Device d1, d2, d3, d4;

		d1 = d2 = d3 = d4 = null;

		d1 = new Device("1000001111");
		d2 = new Device("0001111100");
		try{
			d3 = new Device("0000");
		}catch(Exception e){
			assertEquals(e.getMessage(), "Code length = 10");
		}
		d4 = new Device("1110001110");

		assertTrue(Parameters.NUM_DEVICES == 3);
		
		assertEquals(d4.toString(),"Device #2 with code 1110001110");

		assertTrue(d3 == null);

		assertTrue(d1.compareTo(d2) < 0);
		assertTrue(d2.compareTo(d1) > 0);
		assertTrue(d1.compareTo(d1) == 0);

		assertFalse(d1.equals(d2));

		assertTrue(d1.intersects(d2) == 2);
		assertTrue(d1.intersects(d4) == 4);
		assertTrue(d2.intersects(d4) == 2);

		d1 = d2 = d3 = d4 = null;
	}

	@Test
	public void testUser() throws Exception{
		User u1 = new User("Pepe");
		User u2 = new User("AntonIa");
	
		assertTrue(Parameters.NUM_USERS == 2);
		
		for (int i=0; i<1000; i++){
			new User(i);
		}
		
		assertTrue(Parameters.NUM_USERS == 2);
		
		assertTrue(u1.getId() == 0);
		assertTrue(u2.getId() == 1);
		
		Device d1 = new Device("1100011001");
		Device d2 = new Device("0011100110");
		Device d3 = new Device("1111000011");
		Device d4 = new Device("0000111100");

		assertTrue(Parameters.NUM_DEVICES == 4);

		assertEquals(u1.toString(), "pepe");
		assertEquals(u2.toString(), "antonia");

		
		u1.addDevice(d1,d3);
		u2.addDevice(d2,d4);

		assertTrue(u1.intersects(u2) == 5);

		u2.addDevice(d3);

		assertTrue(u1.intersects(u2) == 8);
		assertTrue(u1.intersects(u2) == u2.intersects(u1));
		
		u1 = u2 = null;
		d1 = d2 = d3 = d4 = null;
	}

	@Test
	public void testBuildNetwork() throws Exception{
		UserNetwork uNet = new UserNetwork();
		uNet.loadFile(archivoEntrada + "datos2"); 
				
		assertTrue(uNet.numberOfVertices() == 4);
		assertTrue(uNet.numberOfEdges() == 10);
		
		User u1 = new User(1);
		User u2 = new User(2);
		User u3 = new User(3);
	
		assertTrue(uNet.containsEdge(u1, u3));
		assertTrue(uNet.getWeight(u1, u3) == 3.0);
		assertTrue(uNet.getWeight(u2, u1) == 4.0);
		assertEquals(uNet.getNeighbors(u2).toString(), "[juan, maria, anabel]");

	
		uNet.loadFile(archivoEntrada + "datos1");	
		
		assertTrue(Parameters.NUM_DEVICES == 10);
		assertTrue(Parameters.NUM_USERS == 5);

		assertTrue(uNet.numberOfEdges() == 20);
		assertTrue(uNet.numberOfVertices() == 5);
		
		uNet = null;
		u1 = u2 = u3 = null;
	}

	@Test
	public void testGetNeighborsOfVertex() throws Exception{
		UserNetwork uNet = new UserNetwork();
		
		uNet.loadFile(archivoEntrada + "datos1");

		User u1 = new User(0);
		User u2 = new User(3);
		User u3 = new User(10);
		
		assertEquals(uNet.getNeighborsOfVertex(u1), "{<pepe, alberto>=63.0, <pepe, anabel>=47.0, <pepe, juan>=61.0, <pepe, maria>=85.0}");
		assertEquals(uNet.getNeighborsOfVertex(u2), "{<maria, alberto>=90.0, <maria, anabel>=71.0, <maria, juan>=92.0, <maria, pepe>=85.0}");		
		assertEquals(uNet.getNeighborsOfVertex(u3), null);

		//Con este parametro controlamos que el metodo buildNetwork sea eficiente...no realizando comparaciones redundantes
		//Si ya hemos computado u1.intersects(u2) --> no sera necesario realizar la operacion u2.intersects(u1) (propiedad conmutativa).
		//En este caso en concreto, como tenemos 5 usuarios, solo habra que hacer 10 intersecciones: u1->u2, u1->u3, u1->4, u1->5, u2->u3, u2->u4, u2->u5, u3->u4, u3->u5, u4->u5
		//El resto seran redundantes...
		assertTrue(Parameters.NUM_INTERSECTS == 10);
		
		
		for (int i=0; i<10; i++)
			uNet.loadFile(archivoEntrada + "datos2");
		
		assertTrue(Parameters.NUM_INTERSECTS==10);
		
		
		
		u1 = u2 = u3 = null;
		uNet = null;
	}
}