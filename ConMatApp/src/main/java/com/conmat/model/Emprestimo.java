package com.conmat.model;

import java.util.Date;

/**
 * A classe Emprestimo implementa os getters e setters (camada Model)
 * 
 * @author Renato Ayron
 *
 */
public class Emprestimo {

	private int id;
	private Date data;
	private Date prazo;
	private int matAluno;

	/**
	 * Construtor vazio da classe Emprestimo
	 */
	public Emprestimo() {
	}

	/**
	 * Construtor da classe Emprestimo
	 * 
	 * @param data
	 * @param prazo
	 * @param matAluno
	 */
	public Emprestimo(Date data, Date prazo, int matAluno) {
		super();
		this.data = data;
		this.prazo = prazo;
		this.matAluno = matAluno;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getPrazo() {
		return prazo;
	}

	public void setPrazo(Date prazo) {
		this.prazo = prazo;
	}

	public int getMatAluno() {
		return matAluno;
	}

	public void setMatAluno(int matAluno) {
		this.matAluno = matAluno;
	}

	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emprestimo\n");
		builder.append("Id = ");
		builder.append(id + "\n");
		builder.append("Data do Emprestimo = ");
		builder.append(data + "\n");
		builder.append("Prazo para entrega = ");
		builder.append(prazo + "\n");
		builder.append("Identificação do Aluno = ");
		builder.append(matAluno + "\n");
		return builder.toString();
	}

}
