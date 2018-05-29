package org.eda1.practica01.ejercicio02;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.eda1.practica01.ejercicio02.ProcesarDatos;
import org.junit.Before;
import org.junit.Test;

public class ProcesarDatosTestJUnit4 {
	String directorioEntrada = "";
	ProcesarDatos proceso = null;
	@Before
	public void setUp() throws Exception {
		directorioEntrada = System.getProperty("user.dir") + File.separator +
						    "src" + File.separator +
						    "org" + File.separator +
						    "eda1" + File.separator +
						    "practica01" + File.separator +
						    "ejercicio02" + File.separator;
	}

	@Test
	public void testProyectoCiudades(){

		ProyectoCiudades pc = new ProyectoCiudades("Proyecto1");
		pc.addCiudad("Almeria");
		pc.addCiudad("Almeria");
		pc.addCiudad("Zaragoza");
		pc.addCiudad("Madrid");
		assertEquals(pc.toString(), "Proyecto1 <Almeria, Zaragoza, Madrid>");

		assertEquals(pc.getProyecto(), "Proyecto1");

		assertTrue(pc.equals(new ProyectoCiudades("Proyecto1")));

		pc = null;
	}

	@Test
	public void testEmpresaProyectos(){
		EmpresaProyectos ep = new EmpresaProyectos("Empresa1");
		ep.addProyectoCiudad("Proyecto1", "Almeria");
		ep.addProyectoCiudad("Proyecto2", "Jaen");
		ep.addProyectoCiudad("Proyecto1", "Zaragoza");
		ep.addProyectoCiudad("Proyecto1",  "Almeria");
		ep.addProyectoCiudad("Proyecto2",  "Salamanca");

		assertEquals(ep.toString(), "Empresa1: Proyecto1 <Almeria, Zaragoza>; Proyecto2 <Jaen, Salamanca>");

		assertTrue(ep.equals(new EmpresaProyectos("Empresa1")));

		assertTrue(ep.getNumCiudades("Proyecto1") == 2);
		assertTrue(ep.getNumCiudades("NoExisto") == -1);

		ep = null;
	}

	@Test
	public void testProcesarDatos() throws FileNotFoundException {
		String salidaEsperada = "";
		proceso = new ProcesarDatos();
		proceso.cargarArchivo(directorioEntrada + "empresasProyectosCiudades.txt");

		assertTrue(proceso.size() == 4);

		assertTrue(proceso.getEmpresaProyectos("Apple") == null);
		assertTrue(proceso.getEmpresaProyectos("Adobe").size() == 3);

		assertTrue(proceso.getEmpresaProyectos("Adobe").getNumCiudades("Photoshop") == 3);

		salidaEsperada = "Adobe: Photoshop <San_Antonio, Houston, Seattle>; Flash <Charleston, Boston, Washington>; Illustrator <Miami, Sacramento, New_Orleans>" + "\n" +
				         "Microsoft: Word <Washington, New_York, Orlando, Miami, Memphis, Maryland>; VisualC++ <Stanford, Philadelphia, Miami, Washington, New_York>; Excel <Sacramento, Los_Angeles, Phoenix, San_Francisco, Las_Vegas>" + "\n" +
		                 "Ramsoft: EZJava <New_York, Stanford, Washington>" + "\n" +
		                 "Borland: Delphi <Jackson, Detroit, Chicago, Milwaukee, Miami>; C++Builder <Ohio, Portland, Berkeley, Wisconsin, Washington>; JBuilder <Miami, Tucson, Santa_Fe, Denver>" + "\n";

		assertEquals(proceso.toString(), salidaEsperada);

		ArrayList<String> empresas = proceso.enumerarEmpresasCiudad("Miami");
		assertTrue(empresas.size() == 3);


		salidaEsperada = "[Adobe, Microsoft, Borland]";
		assertEquals(empresas.toString(), salidaEsperada);

		ArrayList<String> proyectos = proceso.enumerarProyectosCiudad("Washington");

		assertTrue(proyectos.size() == 5);

		salidaEsperada = "[Flash, Word, VisualC++, EZJava, C++Builder]";
		assertEquals(proyectos.toString(), salidaEsperada);

		assertTrue(proceso.contarCiudadesEmpresa("Microsoft") == 13);
		assertTrue(proceso.contarCiudadesEmpresa("Apple") == 0);

	}
}
