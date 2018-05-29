package org.eda1.practica02.ejercicio02;

import java.util.ArrayList;
import java.util.Scanner;

import org.eda1.edaAuxiliar.AVLTree;

import java.io.File;
import java.io.IOException;

public class ProcesarDatos {

	private AVLTree<EmpresaProyectos> listaEmpresas = new AVLTree<EmpresaProyectos>();

	public void cargarArchivo(String archivo) {
		Scanner scan = null;
		String linea;
		String[] items;

		try {
			listaEmpresas.clear();
			scan = new Scanner(new File(archivo));
			while (scan.hasNextLine()) {
				linea = scan.nextLine();
				if (linea.isEmpty()) continue;

				//...
			}
			scan.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}

	public boolean add(String empresa, String proyecto, String ciudad) {
		//...
	}

	public int size() {
		return this.listaEmpresas.size();
	}

	public int numeroProyectosEmpresa(String empresa) {
		//...
	}

	public int numeroCiudadesProyecto(String proyecto) {
		//...
	}

	public int numeroCiudadesEmpresa(String empresa) {
		//...
	}

	@Override
	public String toString() {
		String cadena = "";
		for (EmpresaProyectos ep : this.listaEmpresas) {
			cadena += ep.toString() + "\n";
		}
		return cadena;
	}

	public String devolverEmpresasCiudad(String ciudad) {

		//...
	}

	public String devolverProyectosCiudad(String ciudad) {
		ArrayList<String> proyectos = new ArrayList<String>();

		//...
		return proyectos.toString();
	}
	
	 public String devolverCiudadesEmpresa(String empresa) {
		 ArrayList<String> ciudades = new ArrayList<String>();
		
		 //...
		 
		 return ciudades.toString();
		 }
}