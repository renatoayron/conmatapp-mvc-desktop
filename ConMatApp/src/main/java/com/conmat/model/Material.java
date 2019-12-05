package com.conmat.model;

import java.util.Date;

/**
 * A classe Material implementa os getters e setters (camada Model)
 * 
 * @author Renato Ayron
 *
 */
public class Material {

	private int id;
	private String nome;
	private String autor;
	private Date criacao;
	private String descricao;
	private String status;

	/**
	 * Construtor vazio da classe Material
	 */
	public Material() {

	}

	/**
	 * Construtor da classe Material
	 * 
	 * @param nome
	 * @param autor
	 * @param criacao
	 * @param descricao
	 * @param status
	 */
	public Material(String nome, String autor, Date criacao, String descricao, String status) {
		super();
		this.nome = nome;
		this.autor = autor;
		this.criacao = criacao;
		this.descricao = descricao;
		this.status = status;
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
	 * 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * @return autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * 
	 * @param autor
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * 
	 * @return data de criacao
	 */
	public Date getCriacao() {
		return criacao;
	}

	/**
	 * 
	 * @param criacao
	 */
	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

	/**
	 * 
	 * @return descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * 
	 * @param desricao
	 */
	public void setDesricao(String desricao) {
		this.descricao = desricao;
	}

	/**
	 * 
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * Verificar se um objeto do tipo Material é igual a outro
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aluno\n");
		builder.append("Identificação do Material = ");
		builder.append(id + "\n");
		builder.append("Nome do Material = ");
		builder.append(nome + "\n");
		builder.append("Autor = ");
		builder.append(autor + "\n");
		builder.append("Data de Criação do Material = ");
		builder.append(criacao + "\n");
		builder.append("Descrição: \n");
		builder.append(descricao + "\n");
		builder.append("Status = ");
		builder.append(status + "\n");
		return builder.toString();
	}
	
}
