package org.eda1.prueba00.caso04;

public class Personaje implements Comparable<Personaje>{
	private String nick;
	private String nombre;
	private Character sexo;
	private Integer edad;
	private Integer numPeliculas;
	private Integer numDiscos;
	private Integer numLibros;

	public Personaje(String nick){
		this.nick = nick.toLowerCase();
	}

	public Personaje(String nick, String nombre, Character sexo, Integer edad){
		this.nick = nick.toLowerCase();
		this.nombre= nombre;
		if(sexo.equals('m') || sexo.equals('f'))
			this.sexo =  sexo;
		else
			this.sexo = '?';
		if(edad == null)
			this.edad = 0;
		else
			this.edad = edad;
		this.numPeliculas = 0;
		this.numDiscos = 0;
		this.numLibros = 0;
	}

	public void incrementaNumPeliculas(){
		this.numPeliculas++;
	}

	public void incrementaNumDiscos(){
		this.numDiscos++;
	}

	public void incrementaNumLibros(){
		this.numLibros++;
	}

	public String getProfesionPpal(){

		if(getNumDiscos()> getNumLibros() && getNumDiscos()>getNumPeliculas()){
			return "Cantante";
		}
		if(this.sexo.equals('m') && getNumDiscos()<getNumLibros() && getNumPeliculas()<getNumLibros()){
			return "Escritor";
		}
		if(this.sexo.equals('f') && getNumDiscos()<getNumLibros() && getNumPeliculas()<getNumLibros()){
			return "Escritora";
		}
		if(this.sexo.equals('m') && getNumDiscos()<=getNumPeliculas() && getNumPeliculas()>getNumLibros()){
			return "Actor";
		}
		if(this.sexo.equals('f') && getNumDiscos()<getNumPeliculas() && getNumPeliculas()>getNumLibros()){
			return "Actriz";
		}
		if(this.sexo.equals('m') && getNumDiscos()==0 && getNumLibros()==0 && getNumPeliculas() == 0){
			return "Indefinido";
		}
		if(this.sexo.equals('f') && getNumDiscos()==0 && getNumLibros()==0 && getNumPeliculas() == 0){
			return "Indefinida";
		}
		return "?";
	}

	public int getNumLibros(){
		return this.numLibros;
	}

	public int getNumDiscos(){
		return this.numDiscos;
	}

	public int getNumPeliculas(){
		return this.numPeliculas;
	}

	public Character getSexo(){
		return this.sexo;
	}

	public String getNombre(){
		return this.nombre;
	}

	public Integer getEdad(){
		return this.edad;
	}

	public String getNick(){
		return this.nick;
	}

	@Override
	public String toString(){
		return "{"+ getNombre() + " (" + getNick() + "), " + getProfesionPpal() + ", " + getEdad() + " annios}";
	}

	@Override
	public int compareTo(Personaje o) {
		return getNick().compareTo(o.getNick());
	}
}