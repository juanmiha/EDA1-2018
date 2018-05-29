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
			if (linea.isEmpty()) continue;
			if (linea.startsWith("@") || linea.startsWith(" ")) continue;
			items = linea.split("[ .,->]+ ");
			empresa = items[0];
			proyecto = items[1];
			ciudad = items[2];
			if(!mapa.containsKey(empresa)){
				mapa.put(empresa,new TreeMap<String,TreeSet<String>>());
			}
			if(!mapa.get(empresa).containsKey(proyecto)){
				mapa.get(empresa).put(proyecto,new TreeSet<String>());
			}
			mapa.get(empresa).get(proyecto).add(ciudad);
		}

		scan.close();
	}


	public int size(){
		return mapa.size();
	}


	public TreeSet<String> devolverCiudades() {
		TreeSet<String> ciudadesDiferentes = new TreeSet<String>();
		for(Entry<String,TreeMap<String,TreeSet<String>>> itEmpresas: mapa.entrySet()){
			for(Entry<String,TreeSet<String>> itProyectos : itEmpresas.getValue().entrySet()){
					ciudadesDiferentes.addAll(itProyectos.getValue());

			}
		}
		return ciudadesDiferentes;
	}

	public TreeSet<String> devolverProyectos() {
		TreeSet<String> proyectosDiferentes = new TreeSet<String>();
		for(Entry<String,TreeMap<String,TreeSet<String>>> itEmpresas: mapa.entrySet()){
			for(Entry<String,TreeSet<String>> itProyectos : itEmpresas.getValue().entrySet()){
					proyectosDiferentes.add(itProyectos.getKey());
			}
		}
		return proyectosDiferentes;
	}


	public TreeSet<String> devolverEmpresas() {
		TreeSet<String> empresasDiferentes = new TreeSet<String>();
		for(Entry<String,TreeMap<String,TreeSet<String>>> itEmpresas: mapa.entrySet()){
					empresasDiferentes.add(itEmpresas.getKey());
		}
		return empresasDiferentes;
	}


	public int numeroProyectosEmpresa(String empresa) {
		if (!mapa.containsKey(empresa))
			return 0;
		return mapa.get(empresa).size();
	}


	public int numeroCiudadesProyecto(String proyecto) {
		int numCiud = 0;
		for(Entry<String,TreeMap<String,TreeSet<String>>> itEmpresas: mapa.entrySet()){
			if (mapa.get(itEmpresas.getKey()).containsKey(proyecto))
				numCiud = mapa.get(itEmpresas.getKey()).get(proyecto).size();
		}

		return numCiud;
	}


	public int numeroCiudadesEmpresa(String empresa) {
		TreeSet<String> listaCiudades = null;
		listaCiudades =  new TreeSet<String>();
		if(!mapa.containsKey(empresa))
			return 0;
		for (Entry<String,TreeMap<String,TreeSet<String>>> itEmpresas: mapa.entrySet()) {
			if(empresa.equals(itEmpresas.getKey())){
				for(TreeSet<String> itCiudades : itEmpresas.getValue().values()){
					listaCiudades.addAll(itCiudades);
				}
			}

		}
		return listaCiudades.size();
	}

	@Override
	public String toString() {
		String salida = "";
		for(Entry<String, TreeMap<String, TreeSet<String>>> it : mapa.entrySet()){
			if(mapa.firstKey().equals(it.getKey())){
				salida += it.getKey() + ":";
			}else{
				salida +="\n" + it.getKey() + ":";
			}
			for(Entry<String, TreeSet<String>> it2 : it.getValue().entrySet()){

				if (it.getValue().lastEntry().equals(it2)){
					salida+=" "+it2.getKey()+" "+it2.getValue().toString().replace('[', '<').replace(']', '>');
				}
				else
				salida+=" "+it2.getKey()+" "+it2.getValue().toString().replace('[', '<').replace(']', '>')+";";
			}

		}
		return salida+"\n";
	}

	public TreeSet<String> devolverEmpresasCiudad(String ciudad) {
		TreeSet<String> listaEmpresas = new TreeSet<String>();
		for(Entry<String , TreeMap<String,TreeSet<String>>> itEmpresas: mapa.entrySet()){
			for(Entry<String,TreeSet<String>> itProyectos : itEmpresas.getValue().entrySet()){
				if(itProyectos.getValue().contains(ciudad))
					listaEmpresas.add(itEmpresas.getKey());
			}
		}
		return listaEmpresas;
	}


	public TreeSet<String> devolverProyectosCiudad(String ciudad) {
		TreeSet<String> listaProyectos = new TreeSet<String>();
		for(Entry<String , TreeMap<String,TreeSet<String>>> itEmpresas: mapa.entrySet()){
			for(Entry<String,TreeSet<String>> itProyectos : itEmpresas.getValue().entrySet()){
				if(itProyectos.getValue().contains(ciudad))
					listaProyectos.add(itProyectos.getKey());
			}
		}
		return listaProyectos;
	}

	public TreeSet<String> devolverCiudadesEmpresa(String empresa) {
		TreeSet<String> listaCiudades = null;
		listaCiudades =  new TreeSet<String>();
		if(!mapa.containsKey(empresa))
			return null;
		for (Entry<String,TreeMap<String,TreeSet<String>>> itEmpresas: mapa.entrySet()) {
			if(empresa.equals(itEmpresas.getKey())){
				for(TreeSet<String> itCiudades : itEmpresas.getValue().values()){
					listaCiudades.addAll(itCiudades);
				}
			}
		}
		return listaCiudades;
	}


	public String devolverProyectoConMayorNumeroDeCiudades() {
		String resultado = "";
		int numResultado = -1;
		for(Entry<String,TreeMap<String,TreeSet<String>>> itEmpresas: mapa.entrySet()){
			for(Entry<String, TreeSet<String>> itProyectos : itEmpresas.getValue().entrySet()){
				if(numeroCiudadesProyecto(itProyectos.getKey())>numResultado){
					resultado = itProyectos.getKey();
					numResultado = numeroCiudadesProyecto(itProyectos.getKey());
				}
			}
		}
		return resultado;
	}


	public String devolverEmpresaConMayorNumeroDeProyectos() {
		String resultado = "";
		int numResultado = -1;
		for(Entry<String,TreeMap<String,TreeSet<String>>> itEmpresas: mapa.entrySet()){
				if(numeroProyectosEmpresa(itEmpresas.getKey())>numResultado){
					resultado = itEmpresas.getKey();
					numResultado = numeroProyectosEmpresa(itEmpresas.getKey());
				}
			}
		return resultado;
	}

	public String devolverCiudadConMayorNumeroDeProyectos() {
		String resultado = "";
		int numResultado = -1;
		TreeSet<String> ciudades, proyectos;
		ciudades = devolverCiudades();
		for(String ciudad : ciudades){
			proyectos=devolverProyectosCiudad(ciudad);
			if(proyectos.size()>numResultado){
				resultado = ciudad;
				numResultado = proyectos.size();
			}
			proyectos.clear();
		}
			return resultado;
	}

	public TreeMap<String, TreeSet<String>> devolverCiudadesEmpresas(){
		TreeMap<String, TreeSet<String>> aux = new TreeMap<String, TreeSet<String>>();
		TreeSet<String> ciudades = devolverCiudades();
		for(String ciudad: ciudades){
				aux.put(ciudad,new TreeSet<String>(new Greater<String>()));
				aux.get(ciudad).addAll(devolverEmpresasCiudad(ciudad));
			}
		return aux;
	}
}