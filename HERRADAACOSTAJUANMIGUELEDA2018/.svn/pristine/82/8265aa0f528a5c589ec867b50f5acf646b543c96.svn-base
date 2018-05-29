package org.eda1.prueba00.caso04;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonajeTestJUnit4 {

	private String 	directorioEntrada = System.getProperty("user.dir") + File.separator +
										"src" + File.separator + 
										"org" + File.separator +
										"eda1" + File.separator + 
										"prueba00" + File.separator +
										"caso04" + File.separator;
	private GestionPersonajes gestion = null;

	@Before
	public void setUp() throws Exception {
		gestion = new GestionPersonajes();
	}
	
	@After
	public void tearDown() throws Exception {
		gestion.clear();
		gestion = null;
			
	}
	
	@Test
	public void testPersonaje() {
		Personaje p1 = new Personaje("p98", "Emiliano Perez", 'm', 98);
		Personaje p2 = new Personaje("P34", "Pepa Perez", 'f', 43);
		Personaje p3 = new Personaje("jj34", "Juana juarez_Segura", 'n', null);
		Personaje p4 = new Personaje("LP27", "Luis Perez", 'm', 27);
		
		assertEquals(p2.getNick(), "p34");
		assertEquals(p4.getNick(), "lp27");
		
		assertEquals(p3.getNombre(), "Juana juarez_Segura");
		
		assertTrue(p2.getEdad().equals(43));
		assertTrue(p3.getEdad().equals(0));

		assertTrue(p3.getSexo().equals('?'));
		assertTrue(p1.getSexo().equals('m'));
		assertTrue(p2.getSexo().equals('f'));
		
		assertEquals(p1.getProfesionPpal(), "Indefinido");
		assertEquals(p2.getProfesionPpal(), "Indefinida");
		assertEquals(p3.getProfesionPpal(), "?");
		assertEquals(p4.getProfesionPpal(), "Indefinido");
		
		p1.incrementaNumDiscos();
		p2.incrementaNumLibros();
		p3.incrementaNumPeliculas();
		p4.incrementaNumPeliculas();
		p4.incrementaNumPeliculas();
		
		assertEquals(p1.getProfesionPpal(), "Cantante");
		assertEquals(p2.getProfesionPpal(), "Escritora");
		assertEquals(p3.getProfesionPpal(), "?");
		assertEquals(p4.getProfesionPpal(), "Actor");
		
		assertTrue(p1.getNumDiscos() == 1);
		assertTrue(p1.getNumPeliculas() == 0);
		assertTrue(p4.getNumPeliculas() == 2);
		
		assertEquals(p1.toString(), "{Emiliano Perez (p98), Cantante, 98 annios}");
		assertEquals(p2.toString(), "{Pepa Perez (p34), Escritora, 43 annios}");
		assertEquals(p3.toString(), "{Juana juarez_Segura (jj34), ?, 0 annios}");
		assertEquals(p4.toString(), "{Luis Perez (lp27), Actor, 27 annios}");
		
		p1 = p2 = p3 = p4 = null;
	}	
	
	@Test
	public void testAddAddValues(){
		Personaje p1 = new Personaje("p98", "Emiliano Perez", 'm', 98);
		Personaje p2 = new Personaje("P34", "Pepa Perez", 'f', 43);
		Personaje p3 = new Personaje("LP27", "Luis Perez", 'm', 27);
		
		assertTrue(gestion.add(p1));
		assertTrue(gestion.add(p2));
		assertTrue(gestion.add(p3));
		assertFalse(gestion.add(p3));
		
		assertEquals(gestion.toString(), "[{Luis Perez (lp27), Indefinido, 27 annios}, {Pepa Perez (p34), Indefinida, 43 annios}, {Emiliano Perez (p98), Indefinido, 98 annios}]");
		
		assertTrue(gestion.addValues("p98", "p", "l", "p", "d", "d"));
		assertFalse(gestion.addValues("jjj","d", "d", "d"));
		assertTrue(gestion.addValues("LP27", "d", "d", "d"));
		
		assertEquals(gestion.toString(), "[{Luis Perez (lp27), Cantante, 27 annios}, {Pepa Perez (p34), Indefinida, 43 annios}, {Emiliano Perez (p98), Actor, 98 annios}]");
		
		assertEquals(gestion.find("lp27").getProfesionPpal(), "Cantante");
		gestion.addValues("lp27", "l", "l", "l", "l");
		assertEquals(gestion.find("lP27").getProfesionPpal(), "Escritor");
		
		assertTrue(gestion.find("aol") == null);
		
		p1 = p2 = p3 = null;
	}
	
	@Test
	public void testLoad(){
		gestion.loadFile(directorioEntrada + "datos");
		
		assertTrue(gestion.size() == 6);
		assertTrue(gestion.find("m84").getNumDiscos() == 31);
		assertTrue(gestion.find("loca203").getNumLibros() == 0);
		assertTrue(gestion.find("a34").getNumPeliculas() == 12);
		
		assertEquals(gestion.toString(), "[{Amalia Lopez (a0), Indefinida, 0 annios}, {Antonio Sanchez_Saez (a34), Actor, 34 annios}, {Francisco Segura (fsegura), Escritor, 56 annios}, {Juan Aguilera (j34), Escritor, 34 annios}, {Juana LaLoca (loca203), Actriz, 203 annios}, {Maria Sanchez (m84), Cantante, 84 annios}]");
		
		gestion.loadFile(directorioEntrada + "datos"); 
		assertTrue(gestion.size() == 6);
		
		gestion.loadFile(directorioEntrada + "datos2"); 
		assertTrue(gestion.size() == 1);
	}
	
	@Test
	public void testToString(){
		gestion.loadFile(directorioEntrada + "datos");
		
		assertEquals(gestion.toString(), gestion.toString(null));

		assertEquals(gestion.toString(), gestion.toString(new Less("ea!!!")));

		assertEquals(gestion.toString(new Less("sexo")), gestion.toString(new Less("SEXo")));
		
		assertEquals(gestion.toString(new Less("sexo")), "[{Amalia Lopez (a0), Indefinida, 0 annios}, {Juana LaLoca (loca203), Actriz, 203 annios}, {Maria Sanchez (m84), Cantante, 84 annios}, {Antonio Sanchez_Saez (a34), Actor, 34 annios}, {Francisco Segura (fsegura), Escritor, 56 annios}, {Juan Aguilera (j34), Escritor, 34 annios}]");
		assertEquals(gestion.toString(new Less("eDad")), "[{Amalia Lopez (a0), Indefinida, 0 annios}, {Antonio Sanchez_Saez (a34), Actor, 34 annios}, {Juan Aguilera (j34), Escritor, 34 annios}, {Francisco Segura (fsegura), Escritor, 56 annios}, {Maria Sanchez (m84), Cantante, 84 annios}, {Juana LaLoca (loca203), Actriz, 203 annios}]");
		assertEquals(gestion.toString(new Less("profesion")), "[{Antonio Sanchez_Saez (a34), Actor, 34 annios}, {Juana LaLoca (loca203), Actriz, 203 annios}, {Maria Sanchez (m84), Cantante, 84 annios}, {Francisco Segura (fsegura), Escritor, 56 annios}, {Juan Aguilera (j34), Escritor, 34 annios}, {Amalia Lopez (a0), Indefinida, 0 annios}]");
		
		assertEquals(gestion.toString(new Greater("eDaD")), "[{Juana LaLoca (loca203), Actriz, 203 annios}, {Maria Sanchez (m84), Cantante, 84 annios}, {Francisco Segura (fsegura), Escritor, 56 annios}, {Juan Aguilera (j34), Escritor, 34 annios}, {Antonio Sanchez_Saez (a34), Actor, 34 annios}, {Amalia Lopez (a0), Indefinida, 0 annios}]");
	}
}