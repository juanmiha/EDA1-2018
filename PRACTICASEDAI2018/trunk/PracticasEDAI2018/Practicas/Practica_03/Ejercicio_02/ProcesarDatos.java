package org.eda1.practica03.ejercicio02;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

import org.eda1.edaAuxiliar.Greater;

import java.io.File;
import java.io.IOException;


public class ProcesarDatos {

	private TreeMap<String, TreeMap<String, TreeSet<String>>> mapa;

	public ProcesarDatos() {
		this.mapa = new TreeMap<String, TreeMap<String, TreeSet<String>>>();
	}

	public void cargarArchivo(String archivo) {

		Scanner scan = null;;
		String linea;
		String[] items;
		String empresa = "", proyecto = "", ciudad = "";
		try {
			scan = new Scanner(new File(archivo));
		} catch (IOException e) {
			System.out.println("Error al cargar el archivo");
			System.exit(-1);
		}
		while(scan.hasNextLine()){
			linea = scan.nextLine();
		
			//...
			
		}

		scan.close();
	}


	public int size(){
		return mapa.size();
	}


	public TreeSet<String> devolverCiudades() {
		TreeSet<String> ciudadesDiferentes = new TreeSet<String>();

		//...
		
		return ciudadesDiferentes;
	}

	public TreeSet<String> devolverProyectos() {
		TreeSet<String> proyectosDiferentes = new TreeSet<String>();

		//...

		return proyectosDiferentes;
	}


	public TreeSet<String> devolverEmpresas() {
		//...
	}


	public int numeroProyectosEmpresa(String empresa) {
		//...
	}


	public int numeroCiudadesProyecto(String proyecto) {
		int numCiud = 0;

		//...
		return numCiud;
	}


	public int numeroCiudadesEmpresa(String empresa) {
		TreeSet<String> listaCiudades = null;
		
		//...
		
		return listaCiudades.size();
	}

	@Override
	public String toString() {

		String salida = "";

		//...
		return salida;
	}


	public TreeSet<String> devolverEmpresasCiudad(String ciudad) {
		TreeSet<String> listaEmpresas = new TreeSet<String>();

		//...
		
		return listaEmpresas;
	}


	public TreeSet<String> devolverProyectosCiudad(String ciudad) {
		TreeSet<String> listaProyectos = new TreeSet<String>();

		//...
		
		return listaProyectos;
	}

	public TreeSet<String> devolverCiudadesEmpresa(String empresa) {
		TreeSet<String> listaCiudades = null;

		//...
		
		return listaCiudades;
	}


	public String devolverProyectoConMayorNumeroDeCiudades() {
		String resultado = "";
		int numResultado = -1;

		//...

		return resultado;
	}


	public String devolverEmpresaConMayorNumeroDeProyectos() {
		String resultado = "";
		int numResultado = -1;

		//...
		
		return resultado;
	}

	public String devolverCiudadConMayorNumeroDeProyectos() {
		String resultado = "";
		int numResultado = -1;
		TreeSet<String> ciudades, proyectos;


		//...
		
		return resultado;
	}

	public TreeMap<String, TreeSet<String>> devolverCiudadesEmpresas(){
		TreeMap<String, TreeSet<String>> aux = new TreeMap<String, TreeSet<String>>();
		
		//...
		
		return aux;
	}
}