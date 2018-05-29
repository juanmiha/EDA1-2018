package org.eda1.caso06;

import java.util.TreeSet;

public class User implements Comparable<User>{

	private String nombre;
	private TreeSet<Device> device;

	public User(String nombre){
		super();

		this.nombre = nombre;
	}

	public User(String nombre, TreeSet<Device> device){
		super();
		this.nombre = nombre;
		if(this.device==null) this.device = device;
		this.device.addAll(device);

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TreeSet<Device> getDevice() {
		return device;
	}

	public void setDevice(TreeSet<Device> device) {
		this.device = device;
	}

	public boolean equals(Object o){
		User tmp = (User) o;
		return this.nombre.equals(tmp.nombre);
	}

	@Override
	public int compareTo(User o) {
		User tmp = (User) o;
		return this.nombre.compareTo(tmp.nombre);
	}

	public int interseccion(User u2) {
		int i = 0;
		for(Device it1 : this.device){
			for(Device it2: u2.getDevice()){
				i+= it1.interseccion(it2);
			}
		}
		return i;
	}
	public void add(Device dev) {
		if(this.device == null) this.device = new TreeSet<Device>();
		this.device.add(dev);
	}

	public String toString(){
		String aux = this.nombre + ":";
		for(Device it : device){
			aux += " " + it.toString();
		}
		return aux;
	}
}
