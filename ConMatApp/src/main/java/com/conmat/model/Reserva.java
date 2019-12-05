package com.conmat.model;

import java.util.Date;

/**
 * A classe Reserva implementa os getters e setters (camada Model)
 * 
 * @author Renato Ayron
 *
 */
public class Reserva {

	private int id;
	private Date data;
	private int matProf;

	/**
	 * Construtor vazio da classe Reserva
	 */
	public Reserva() {
	}

	/**
	 * Construtor da classe Reserva
	 * @param data
	 * @param matProf
	 */
	public Reserva(Date data, int matProf) {
		super();
		this.data = data;
		this.matProf = matProf;
	}

	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * 
	 * @param data
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * 
	 * @return matProf
	 */
	public int getMatProf() {
		return matProf;
	}

	/**
	 * 
	 * @param matProf
	 */
	public void setMatProf(int matProf) {
		this.matProf = matProf;
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * toString da classe Reserva
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aluno\n");
		builder.append("Identificação da Reserva = ");
		builder.append(id + "\n");
		builder.append("Data da Reserva do Material = ");
		builder.append(data + "\n");
		builder.append("Identificação do Professor = ");
		builder.append(matProf + "\n");
		return builder.toString();
	}
	
}
