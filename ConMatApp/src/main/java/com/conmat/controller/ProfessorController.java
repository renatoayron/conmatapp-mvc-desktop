package com.conmat.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.conmat.dao.ProfessorDAO;
import com.conmat.interfaces.CRUD;
import com.conmat.model.Professor;

/**
 * Classe para gerenciar e controlar as alterações de estados em Professor
 * 
 * @author Renato Ayron
 *
 */
public class ProfessorController implements CRUD {

	private static ProfessorDAO professorDAO;
	private static Scanner scan;
	
	public ProfessorController() {
		professorDAO = new ProfessorDAO();
		scan = new Scanner(System.in);
	}

	/**
	 * Delegar a função de todas as tuplas criadas em Professor
	 */
	public void list() {
		if (professorDAO != null) {
			professorDAO.list();
		} else {
			System.out.println("Não há professores na lista!");
		}
	}

	/**
	 * Delegar a função de retorno de uma tupla específica de Professor
	 */
	public Professor get(int id) {
		Professor professor = professorDAO.get(id);
		if (professor == null) {
			return null;
		} else {
			return professor;
		}
	}

	/**
	 * Método para delegar a inserção de um Professor
	 * 
	 */
	public boolean insert(Object professor) {
		Professor professor1 = (Professor) professor;
		if (professor != null) {
			professorDAO.insert(professor1);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Método para delegar a edição de um Professor
	 * @param professor
	 */
	public boolean edit(Object professor) {
//		scan = new Scanner(System.in);
		if (professor != null) {
//			Professor p = (Professor) professor;
			System.out.println("Insira as novas informações: ");
			System.out.println("Nome do Professor: ");
			String nomeProf = scan.nextLine();
			System.out.println("Salário: ");
			float salario = scan.nextFloat();
			System.out.println("Data de Nascimento: ");
			Date nascProf = getData();
//			java.util.Date nascAluno = dataInicial;
//			int matricula = p.getMatricula();
			Professor professor1 = new Professor(nomeProf, salario, nascProf);
			professorDAO.edit(professor1);
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
				System.out.println("Por favor, entre com uma data válida!\n O formato é aaaa/mm/dd");
			}
		}
//		dataInicial = apptDay;
		sqlDate = new java.sql.Date(apptDay.getTime());
		return sqlDate;
	}

	/**
	 * Método para delegar a exclusão de um Professor para a camada de Modelo e em DAO
	 */
	public boolean delete(int id) {
		Professor professor = professorDAO.get(id);
		if (professor.getId() == id) {
			professorDAO.delete(id);
			System.out.println("Professor removido com SUCESSO!");
			return true;
		} else {
			System.out.println("O Professor não existe ou não foi encontrado!");
			return false;
		}
	}

}
