package com.conmat.model;

/**
 * A classe Historico implementa os getters e setters (camada Model)
 * 
 * @author Renato Ayron
 *
 */
public class Historico {

	private int id;
	private boolean statusR;
	private boolean statusE;
	private int matProf;
	private int idReserva;
	private int matAluno;
	private int idEmprestimo;

	/**
	 * 
	 * @param matProf
	 * @param statusR
	 * @param idReserva
	 */
	public Historico(int matProf, boolean statusR, int idReserva) {
		super();
		this.statusE = false;
		this.statusR = statusR;
		this.matProf = matProf;
		this.idReserva = idReserva;
	}

	/**
	 *  Construtor da classe Historico
	 * @param matAluno
	 * @param idEmprestimo
	 * @param statusE
	 */
	public Historico(int matAluno, int idEmprestimo, boolean statusE) {
		super();
		this.statusR = false;
		this.matAluno = matAluno;
		this.idEmprestimo = idEmprestimo;
		this.statusE = statusE;
	}

	/**
	 * Construtor vazio da classe Historico
	 */
	public Historico() {
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

	public int getIdReserva() {
		return idReserva;
	}

	/**
	 * 
	 * @param idReserva
	 */
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public int getMatAluno() {
		return matAluno;
	}

	/**
	 * 
	 * @param matAluno
	 */
	public void setMatAluno(int matAluno) {
		this.matAluno = matAluno;
	}

	public int getIdEmprestimo() {
		return idEmprestimo;
	}

	/**
	 * 
	 * @param idEmprestimo
	 */
	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public boolean isStatusR() {
		return statusR;
	}

	/**
	 * 
	 * @param statusR
	 */
	public void setStatusR(boolean statusR) {
		this.statusR = statusR;
	}

	public boolean isStatusE() {
		return statusE;
	}

	/**
	 * 
	 * @param statusE
	 */
	public void setStatusE(boolean statusE) {
		this.statusE = statusE;
	}

}
