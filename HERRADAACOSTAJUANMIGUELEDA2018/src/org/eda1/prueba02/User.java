package org.eda1.prueba02;

import java.util.TreeSet;

public class User implements Comparable<User> {

	private int id; //Identificador de usuario. Relacionado con el parametro Parameters.NUM_USERS
	private String name; //Nombre del Usuario
	private TreeSet<Device> devices; //Conjunto de dispositivos que posee el usuario

	public User(int id){
		//Constructor parcial util para la busqueda de usuarios en colecciones
		this.id=id;
		this.name = null;
	}

	public User(String nombre){
		//...
		this.id = Parameters.NUM_USERS++;
		this.name = nombre.toLowerCase();
	}

	public int getId(){
		return this.id;
	}

	public void addDevice(Device...devs){
		if(this.devices==null) this.devices =  new TreeSet<Device>();
		for(Device it: devs){
			this.devices.add(it);
		}
	}

	public int intersects(User o){
		int cont=0;
		if(this.devices==null||o.devices==null) return 0;
		Parameters.NUM_INTERSECTS += 1;	//La actualizacion de este parametro lo realizamos unicamente para saber cuantas veces llamamos al metodo intersects()...control de eficiencia???
		for (Device d0 : this.devices) {
			for (Device d1 : o.devices) {
				if(d0.equals(d1)) continue;
				cont += d0.intersects(d1);
			}
		}
		return cont;
	}

	@Override
	public String toString(){
		return this.name;
	}

	@Override
	public int compareTo(User o) {
		//Orden natural --> id
		if(this.id>o.id)return 1;
		if(this.id<o.id)return-1;
		return 0;
	}

	@Override
	public boolean equals(Object o){
		//Metodo equals() coherente con el metodo compareTo()
		User tmp = (User) o;
		return (Integer.compare(this.id,tmp.id)==0);
	}
}
