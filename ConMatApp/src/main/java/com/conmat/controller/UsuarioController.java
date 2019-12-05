package com.conmat.controller;

import java.util.List;
import java.util.Scanner;

import com.conmat.dao.UsuarioDAO;
import com.conmat.interfaces.CRUD;
import com.conmat.model.Usuario;

/**
 * Classe para gerenciar e controlar as altera��es de estados em Usuario
 * 
 * @author Renato Ayron
 *
 */
public class UsuarioController implements CRUD {

	private static UsuarioDAO usuarioDAO;
	private static Scanner scan;

	public UsuarioController() {
		usuarioDAO = new UsuarioDAO();
		scan = new Scanner(System.in);
	}

	/**
	 * Delegar a fun��o de todas as tuplas criadas em Usuario
	 */
	public void list() {
		if (usuarioDAO != null) {
			usuarioDAO.list();
		} else {
			System.out.println("N�o h� usu�rios na lista!");
		}
	}

	/**
	 * Delegar a fun��o de retorno de am tupla espec�fica de Usuario
	 */
	public Usuario get(int id) {
		List<Integer> lista = usuarioDAO.recuperarIDS();
		if (lista.contains(id)) {
			Usuario usuario = usuarioDAO.get(id);
			return usuario;
		} else {
			return null;
		}
	}

	/**
	 * M�todo para delegar a inser��o de um Usuario
	 * 
	 */
	public boolean insert(Object usuario) {
		Usuario usuario1 = (Usuario) usuario;
		if (usuario != null) {
			usuarioDAO.insert(usuario1);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * M�todo para delegar a edi��o de um Usuario
	 */
	public boolean edit(Object usuario) {
		if (usuario != null) {
			Usuario u = (Usuario) usuario;
			System.out.println("Insira as novas informa��es: ");
			System.out.println("E-mail: ");
			String email = scan.nextLine();
			System.out.println("Nome de Usu�rio: ");
			String username = scan.nextLine();
			System.out.println("Senha: ");
			String password = scan.nextLine();
			Usuario usuario1 = new Usuario(email, username, password);
			usuario1.setId(u.getId());
			usuarioDAO.edit(usuario1);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * M�todo para delegar a exclus�o de um Usuario para a camada de Modelo e em DAO
	 */
	public boolean delete(int id) {
		List<Integer> lista = usuarioDAO.recuperarIDS();
		if (lista.contains(id)) {
			usuarioDAO.delete(id);
			System.out.println("Usuario removido com SUCESSO!");
			return true;
		} else {
			System.out.println("O Usuario n�o existe ou n�o foi encontrado!");
			return false;
		}
	}

}
