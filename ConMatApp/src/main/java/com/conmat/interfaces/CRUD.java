package com.conmat.interfaces;

/**
 * Classe que define uma interface de um CRUD simples com Inserção, Exclusão, Edição e Leitura
 * @author Renato Ayron
 *
 */
public interface CRUD {

	/**
	 * Lista todos os elementos
	 */
	public void list();

	/**
	 * Exibe um elemento específico pelo id 
	 * @param id
	 * @return Object
	 */
	public Object get(int id);

	/**
	 * Adiciona um elemento aos dados
	 * @param o
	 * @return boolean
	 */
	public boolean insert(Object o);

	/**
	 * Altera o valor de algum parâmetro do um Objeto
	 * @param o
	 * @return boolean
	 */
	public boolean edit(Object o);

	/**
	 * Deleta um elemento dos dados
	 * @param id
	 * @return boolean
	 */
	public boolean delete(int id);

}
