package org.eda1.prueba00.caso03;

import java.util.ArrayList;

import org.eda1.edaAuxiliar.AVLTree;


public class Maquina implements Comparable<Maquina>{
	private String nombre;
	private AVLTree<IpMaquina> ips;

	public Maquina (String nombre){
		if(nombre!= null)
			this.nombre= nombre;
		else
			this.nombre = "maquina?";
		this.ips = new AVLTree<IpMaquina>();
	}

	public void add(String ip){
		IpMaquina aux = new IpMaquina(ip);
		if(ips.find(aux)==null)
			ips.add(aux);
		else
			ips.find(aux).incrementaContador();
	}

	public ArrayList<IpMaquina> toArray(){
		ArrayList<IpMaquina> output =  new ArrayList<IpMaquina>();
		for(IpMaquina it1 : ips){
			output.add(it1);
		}
		return output;
	}

	public boolean contains(String ip){
		IpMaquina aux = new IpMaquina(ip);
		return (ips.find(aux)!=null)? true:false;
	}

	public String getNombre(){
		return this.nombre;
	}

	public int getNumIps(){
		int contador=0;
		for(IpMaquina it1 : ips){
			contador+= it1.getContador();
		}
		return contador;
	}

	@Override
	public String toString(){
		return this.nombre + " --> " + this.ips.toString();
	}

	@Override
	public int compareTo(Maquina otro){
		return this.nombre.compareTo(otro.nombre);
	}
}