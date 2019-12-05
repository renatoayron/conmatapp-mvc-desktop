package com.conmat.model;

import java.util.Date;

/**
 * A classe Professor implementa os getters e setters (camada Model)
 * 
 * @author Renato Ayron
 *
 */
public class Professor extends Usuario {

	private int matricula;
	private String nomeProf;
	private float salario;
	private Date nascProf;

	public Professor() {
	}

	public Professor(String nomeProf, float salario, Date nascProf) {
		super();
		this.nomeProf = nomeProf;
		this.salario = salario;
		this.nascProf = nascProf;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNomeProf() {
		return nomeProf;
	}

	public void setNomeProf(String nomeProf) {
		this.nomeProf = nomeProf;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Date getNascProf() {
		return nascProf;
	}

	public void setNascProf(Date nascProf) {
		this.nascProf = nascProf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + matricula;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (matricula != other.matricula)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Professor\n");
		builder.append("Matricula = ");
		builder.append(matricula + "\n");
		builder.append("Nome do aluno = ");
		builder.append(nomeProf + "\n");
		builder.append("Salário = ");
		builder.append(salario + "\n");
		builder.append("Data de Nascimento = ");
		builder.append(nascProf + "\n");
		return builder.toString();
	}

}
