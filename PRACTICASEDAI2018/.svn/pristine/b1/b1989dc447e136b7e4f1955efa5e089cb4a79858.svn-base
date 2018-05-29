package org.eda1.prueba02;

import java.util.TreeSet;

public class User implements Comparable<User> {

	private int id; //Identificador de usuario. Relacionado con el parametro Parameters.NUM_USERS
	private String name; //Nombre del Usuario
	private TreeSet<Device> devices; //Conjunto de dispositivos que posee el usuario
	
	public User(int id){
		//Constructor parcial util para la busqueda de usuarios en colecciones
	}

	public User(String nombre){
		//...
	}

	public int getId(){
		return this.id;
	}
	
	public void addDevice(Device...devs){
		//...
	}

	public int intersects(User o){
		int cont=0;
		Parameters.NUM_INTERSECTS += 1;	//La actualizacion de este parametro lo realizamos unicamente para saber cuantas veces llamamos al metodo intersects()...control de eficiencia???
		//...
		return cont;
	}

	@Override
	public String toString(){
		return this.name;
	}

	@Override
	public int compareTo(User o) {
		//Orden natural --> id
	}

	@Override
	public boolean equals(Object o){
		//Metodo equals() coherente con el metodo compareTo()
	}
}
