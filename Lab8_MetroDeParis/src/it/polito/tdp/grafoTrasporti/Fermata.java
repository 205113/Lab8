package it.polito.tdp.grafoTrasporti;

public class Fermata {
private int id;
private String nome;
private double x;
private double y;

public Fermata(int id, String nome, double x, double y) {
	this.id = id;
	this.nome = nome;
	this.x = x;
	this.y = y;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public double getX() {
	return x;
}

public void setX(double x) {
	this.x = x;
}

public double getY() {
	return y;
}

public void setY(double y) {
	this.y = y;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Fermata other = (Fermata) obj;
	if (id != other.id)
		return false;
	return true;
}

@Override
public String toString() {
	return this.nome;
}


}
