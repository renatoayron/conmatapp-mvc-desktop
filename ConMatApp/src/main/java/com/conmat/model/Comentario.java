package com.conmat.model;

/**
 * Classe para receber comentários dos usuários sobre os materiais
 * 
 * @author Renato Ayron
 *
 */
public class Comentario {

	private String mensagem;

	/**
	 * 
	 * @return mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * 
	 * @param mensagem
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Comentario\nMensagem:\n");
		builder.append(mensagem + "\n");
		return builder.toString();
	}

}
