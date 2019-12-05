package com.conmat.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.conmat.dao.MaterialDAO;
import com.conmat.interfaces.CRUD;
import com.conmat.model.Aluno;
import com.conmat.model.Material;

/**
 * Classe para gerenciar e controlar as altera��es de estados em Material
 * 
 * @author Renato Ayron
 *
 */
public class MaterialController implements CRUD {

	private static MaterialDAO materialDAO;;
	private static Scanner scan;
	
	/**
	 * Construtor da classe MaterialController
	 */
	public MaterialController() {
		materialDAO = new MaterialDAO();
		scan = new Scanner(System.in);
	}
	
	/**
	 * Delegar a fun��o de todas as tuplas criadas em Material
	 */
	public void list() {
		if (materialDAO != null) {
			materialDAO.list();
		} else {
			System.out.println("N�o h� materiais na lista!");
		}
	}

	/**
	 * Delegar a fun��o de retorno de uma tupla espec�fica de Material
	 */
	public Material get(int id) {
		Material material = materialDAO.get(id);
		if (material == null) {
			return null;
		} else {
			return material;
		}
	}

	/**
	 * M�todo para delegar a inser��o de um Material
	 * @param material
	 */
	public boolean insert(Object material) {
		Material material1 = (Material) material;
		if (material != null) {
			materialDAO.insert(material1);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * M�todo para delegar a edi��o de um Material
	 */
	public boolean edit(Object aluno) {
		if (aluno != null) {
			Aluno a = (Aluno) aluno;
			System.out.println("Insira as novas informa��es: ");
			System.out.println("Nome do Material: ");
			String nome = scan.nextLine();
			System.out.println("Autor do Material: ");
			String autor = scan.nextLine();
			System.out.println("Data de Cria��o: ");
			Date criacao = getData();
			System.out.println("Descric�o: ");
			String descricao = scan.nextLine();
			System.out.println("Status do Material: ");
			String status = scan.nextLine();
			int id = a.getMatricula();
			Material material1 = new Material(nome, autor, criacao, descricao, status);
			material1.setId(id);
			materialDAO.edit(material1);
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
	 * M�todo para delegar a exclus�o de um Material para a camada de Modelo e em DAO
	 */
	public boolean delete(int id) {
		Material material = materialDAO.get(id);
		if (material.getId() == id) {
			materialDAO.delete(id);
			System.out.println("Material removido com SUCESSO!");
			return true;
		} else {
			System.out.println("O Material n�o existe ou n�o foi encontrado!");
			return false;
		}
	}

}
