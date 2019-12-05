package com.conmat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.conmat.config.Conexao;
import com.conmat.model.Usuario;

/**
 * Classe de persistência de Usuarios no banco
 * 
 * @author usuario
 *
 */
public class UsuarioDAO {

	public UsuarioDAO() {
	}

	/**
	 * Realizar a função de listar todas as tuplas criadas em Usuario
	 */
	public void list() {
		try {

			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			String query = "SELECT * FROM Usuario";

			Statement st;
			st = conn.createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int idUsuario = rs.getInt("idUsuario");
				String email = rs.getString("email");
				String usuario = rs.getString("usuario");
				String senha = rs.getString("senha");

				// print the results
				System.out.format("%s - %s - %s - %s\n", idUsuario, email, usuario, senha);
			}

			st.close();
		} catch (SQLException e) {
			System.out.println("Ocorreu uma Exceção! Não foi possível recuperar a lista de Alunos!");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Realizar a função de retorno de uma tupla específica de Usuario
	 */
	public Usuario get(int id) {
		Usuario u1 = null;
		try {

			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			String query = "SELECT * FROM Usuario WHERE idUsuario = ?";

			PreparedStatement preparedStmt;
			Statement st;

			st = conn.createStatement();
			preparedStmt = conn.prepareStatement(query);

			preparedStmt.setInt(1, id);

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int idUsuario = rs.getInt("idUsuario");
				String email = rs.getString("email");
				String usuario = rs.getString("usuario");
				String senha = rs.getString("senha");

				u1 = new Usuario(email, usuario, senha);
				u1.setId(idUsuario);

				// printando os resultados
				System.out.format("%s - %s - %s - %s\n", idUsuario, email, usuario, senha);
			}

			st.close();
			conexao.closeConnection();
			return u1;
		} catch (SQLException e) {
			System.out.println("Ocorreu uma Exceção! Não foi possível recuperar o Aluno!");
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Método para realizar a inserção de um Usuario
	 * 
	 * return boolean
	 */
	public boolean insert(Usuario usuario) {
		Usuario u1 = usuario;

		try {

			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();
			PreparedStatement preparedStmt;

			String query = " insert into Usuario (`email`, `usuario`, `senha`) values (?, ?, ?)";

			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, u1.getEmail());
			preparedStmt.setString(2, u1.getUser());
			preparedStmt.setString(3, u1.getPassword());

			preparedStmt.execute();

			conexao.closeConnection();
			System.out.println("Usuario inserido com SUCESSO!");
			return true;
		} catch (SQLException se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
			return false;
		}
	}

	/**
	 * Método para realizar a edição de um Usuario
	 * 
	 * @param usuario
	 */
	public boolean edit(Usuario usuario) {
		Usuario u1 = (Usuario) usuario;
		try {

			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();
			PreparedStatement preparedStmt;

			String query = "UPDATE Aluno SET email = ?, usuario = ?, senha = ? WHERE idUsuario = ?";
			preparedStmt = conn.prepareStatement(query);

			preparedStmt.setString(1, u1.getEmail());
			preparedStmt.setString(2, u1.getUser());
			preparedStmt.setString(3, u1.getPassword());
			preparedStmt.setInt(4, u1.getId());

			preparedStmt.executeUpdate();
			preparedStmt.close();
			return true;
		} catch (SQLException se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
			return false;
		}
	}

	/**
	 * Método para realizar a exclusão de um Usuario para a camada de Modelo e em
	 * DAO
	 */
	public boolean delete(int idUsuario) {
		try {

			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();
			PreparedStatement preparedStmt;

			String query = "delete from Usuario where idUsuario = ?";
			preparedStmt = conn.prepareStatement(query);

			preparedStmt.setInt(1, idUsuario);

			// executa preparedstatement
			preparedStmt.execute();

			conexao.closeConnection();
			return true;
		} catch (SQLException se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
			return false;
		}

	}

	public List<Integer> recuperarIDS() {
		List<Integer> lista = new ArrayList<Integer>();
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			String query = "SELECT idUsuario FROM Usuario";

			Statement st;
			st = conn.createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("idUsuario");
				lista.add(id);
			}
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
