package com.conmat.model;

import java.util.Date;

/**
 * A classe Aluno implementa os getters e setters (camada Model)
 * 
 * @author Renato Ayron
 *
 */
public class Aluno extends Usuario {

	private int matricula;
	private String nomeAluno;
	private String turma;
	private Date nascAluno;

	/**
	 * Construtor vazio da classe Aluno
	 */
	public Aluno() {
	}

	/**
	 * Construtor da classe Aluno
	 * 
	 * @param nomeAluno
	 * @param turma
	 * @param nascAluno
	 */
	public Aluno(String nomeAluno, String turma, Date nascAluno) {
		super();
		this.nomeAluno = nomeAluno;
		this.turma = turma;
		this.nascAluno = nascAluno;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public Date getNascAluno() {
		return nascAluno;
	}

	public void setNascAluno(Date nascAluno) {
		this.nascAluno = nascAluno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matricula;
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
		Aluno other = (Aluno) obj;
		if (matricula != other.matricula)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aluno\n");
		builder.append("Matricula = ");
		builder.append(matricula + "\n");
		builder.append("Nome do aluno = ");
		builder.append(nomeAluno + "\n");
		builder.append("Turma = ");
		builder.append(turma + "\n");
		builder.append("Data de Nascimento = ");
		builder.append(nascAluno + "\n");
		return builder.toString();
	}

}
