package com.conmat.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.conmat.dao.AlunoDAO;
import com.conmat.interfaces.CRUD;
import com.conmat.model.Aluno;

/**
 * Classe para gerenciar e controlar as altera��es de estados em Aluno
 * 
 * @author Renato Ayron
 *
 */
public class AlunoController implements CRUD {

	private static AlunoDAO alunoDAO;
	private static Scanner scan;
//	private static Date dataInicial = null;
	
	public AlunoController() {
		alunoDAO = new AlunoDAO();
		scan = new Scanner(System.in);
	}

	/**
	 * Delegar a fun��o de todas as tuplas criadas em Aluno
	 */
	public void list() {
		if (alunoDAO != null) {
			alunoDAO.list();
		} else {
			System.out.println("N�o h� alunos na lista!");
		}
	}

	/**
	 * Delegar a fun��o de retorno de uma tupla espec�fica de Aluno
	 */
	public Aluno get(int id) {
		Aluno aluno = alunoDAO.get(id);
		if (aluno == null) {
			return null;
		} else {
			return aluno;
		}
	}

	/**
	 * M�todo para delegar a inser��o de um Aluno na camada de Modelo e persistir os
	 * dados em DAO
	 * 
	 */
	public boolean insert(Object aluno) {
		Aluno aluno1 = (Aluno) aluno;
		if (aluno != null) {
			alunoDAO.insert(aluno1);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * M�todo para delegar a edi��o de um Aluno para a camada de Modelo e persistir
	 * em DAO
	 */
	public boolean edit(Object aluno) {
//		scan = new Scanner(System.in);
		if (aluno != null) {
//			Aluno a = (Aluno) aluno;
			System.out.println("Insira as novas informa��es: ");
			System.out.println("Nome do Aluno: ");
			String nomeAluno = scan.nextLine();
			System.out.println("Turma: ");
			String turma = scan.nextLine();
			System.out.println("Data de Nascimento: ");
			Date nascAluno = getData();
//			java.util.Date nascAluno = dataInicial;
//			int matricula = a.getMatricula();
			Aluno aluno1 = new Aluno(nomeAluno, turma, nascAluno);
			alunoDAO.edit(aluno1);
			return true;
		} else {
			return false;
		}
	}

	private static java.sql.Date getData() {
//	    scan = new Scanner(System.in);
		String input;
		Date apptDay = null;
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		java.sql.Date sqlDate;
		System.out.println("\nEntre com a data de nascimento...\n Formato: aaaa/mm/dd");
		while (apptDay == null) {
			try {
				input = scan.next();
				apptDay = (Date) df.parse(input);
			} catch (ParseException e) {
				System.out.println("Por favor, entre com uma data v�lida!\n O formato � aaaa/mm/dd");
			}
		}
//		dataInicial = apptDay;
		sqlDate = new java.sql.Date(apptDay.getTime());
		return sqlDate;
	}

	/**
	 * M�todo para delegar a exclus�o de um Aluno para a camada de Modelo e em DAO
	 */
	public boolean delete(int id) {
		Aluno aluno = alunoDAO.get(id);
		if (aluno.getId() == id) {
			alunoDAO.delete(id);
			System.out.println("Aluno removido com SUCESSO!");
			return true;
		} else {
			System.out.println("O Aluno n�o existe ou n�o foi encontrado!");
			return false;
		}
	}

}
