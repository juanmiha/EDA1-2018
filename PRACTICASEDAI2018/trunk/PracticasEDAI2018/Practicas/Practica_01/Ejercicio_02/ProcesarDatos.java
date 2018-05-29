package org.eda1.practica01.ejercicio02;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Clase que contiene los metodos necesarios para procesar el archivo y generar
 * la ED ...
 * 
 * @author Antonio Corral Liria
 * @author Francisco Guil
 */
public class ProcesarDatos {

	
	private ArrayList<EmpresaProyectos> listaEmpresas = new ArrayList<EmpresaProyectos>();

	
	/**
	 * Metodo que lee las lineas del archivo correspondiente 
	 * 
	 * @param ruta del archivo de entrada
	 * @return void (trabajamos con el atributo listaEmpresas
	 */
	public void cargarArchivo(String file) {
		Scanner fileScanner = null;
		EmpresaProyectos eP = null;
		String[] empProCiu = null;
		try {
			fileScanner = new Scanner(new File(file));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		while (fileScanner.hasNextLine()) {
			empProCiu = fileScanner.nextLine().split(" ");
			//...
		}
	}

	/**
	 * Metodo size()
	 * @return tamaño de la estructura listaEmpresas
	 */
	public int size() {
		return this.listaEmpresas.size();
	}
	
	/**
	 * Metodo getEmpresaProyectos() --> devuelve referencia al objeto EmpresaProyectos asociado al parametro empresa
	 * @param empresa
	 * @return referencia al objeto EmpresaProyectos
	 */

	public EmpresaProyectos getEmpresaProyectos(String empresa){
		int pos = listaEmpresas.indexOf(new EmpresaProyectos(empresa));
		return pos == -1 ? null : listaEmpresas.get(pos);
	}

	/**
	 * Metodo toString()
	 */
	@Override
	public String toString() {
		String salida = "";
		for (int i = 0; i < this.listaEmpresas.size(); i++) {
			salida += this.listaEmpresas.get(i).toString() + "\n";

		}
		return salida;
	}

	/**
	 * Metodo metodo enumerarEmpresasCiudad() -> devuelve un ArrayList<String> con todas las empresas que desarrollan proyectos en la ciudad 
	 * @param ciudad
	 * @return ArrayList<String> con el conjunto de empresas
	 */

	public ArrayList<String> enumerarEmpresasCiudad(String ciudad) {
		ArrayList<String> empresas = new ArrayList<String>();
		for (EmpresaProyectos ep: listaEmpresas){
			//...
		}
		return empresas;
	}

	/**
	 * Metodo enumerarProyectos() -> devuelve un ArrayList<String> con todos los proyectos que se desarrollan en la ciudad
	 * @param ciudad
	 * @return ArrayList<String> con el conjunto de proyectos
	 */
	public ArrayList<String> enumerarProyectosCiudad(String ciudad) {
		//...
	}

	/**
	 * Metodo contarCiudadesEmpresa() -> devuelve el número de ciudades en las que la empresa desarrolla productos software. Es posible que la empresa no exista.
	 * @param empresa
	 * @return Numero de ciudades
	 */
	public int contarCiudadesEmpresa(String empresa) {
		ArrayList<String> ciudades = null;
		//...
	}
}