package com.conmat.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.conmat.config.Conexao;
import com.conmat.model.Material;

/**
 * Classe de persistência de Materiais no banco
 * 
 * @author usuario
 *
 */
public class MaterialDAO {

	/**
	 * Realizar a função de listar todas as tuplas criadas em Material
	 */
	public void list() {
		try {

			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			Statement st;

			String query = "SELECT * FROM Material";
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int idMaterial = rs.getInt("idMaterial");
				String nome = rs.getString("nome");
				String autor = rs.getString("autor");
				Date dataCadastro = rs.getDate("dataCadastro");
				String descricao = rs.getString("descricao");
				String status = rs.getString("status");

				// printa os resultados
				System.out.format("%s - %s - %s - %s - %s - %s\n", idMaterial, nome, autor, dataCadastro, descricao,
						status);
			}

			st.close();
		} catch (SQLException e) {
			System.out.println("Ocorreu uma Exceção! Não foi possível recuperar a lista de Materiais!");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Realizar a função de retorno de uma tupla específica de Material
	 * 
	 * @param id
	 */
	public Material get(int id) {
		Material material = null;
		try {

			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			Statement st;
			PreparedStatement preparedStmt;

			String query = "SELECT * FROM Material WHERE idMaterial = ?";
			st = conn.createStatement();

			preparedStmt = conn.prepareStatement(query);

			preparedStmt.setInt(1, id);

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int idMaterial = rs.getInt("idMaterial");
				String nome = rs.getString("nome");
				String autor = rs.getString("autor");
				Date dataCadastro = rs.getDate("dataCadastro");
				String descricao = rs.getString("descricao");
				String status = rs.getString("status");

				// printa os resultados
				System.out.format("%s - %s - %s - %s - %s - %s\n", idMaterial, nome, autor, dataCadastro, descricao,
						status);
			}

			st.close();
			conexao.closeConnection();
			return material;
		} catch (SQLException e) {
			System.out.println("Ocorreu uma Exceção! Não foi possível recuperar o Aluno!");
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Método para realizar a inserção de um Material
	 * 
	 */
	public boolean insert(Material material) {
		Material m1 = material;

//		if (conexao.isConnected() && conexao.getConnection() != null) {
//		} else {
//		}
		try {

			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			PreparedStatement preparedStmt;

			String query = " insert into Material (`nome`, `autor`, `dataCadastro`, `descricao`, `status`) values (?, ?, ?, ?, ?)";

			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, m1.getNome());
			preparedStmt.setString(2, m1.getAutor());
			preparedStmt.setDate(3, new Date(m1.getCriacao().getTime()));
			preparedStmt.setString(4, m1.getDescricao());
			preparedStmt.setString(5, m1.getStatus());

			preparedStmt.execute();

			conexao.closeConnection();
			System.out.println("Material inserido com SUCESSO!");
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	/**
	 * Método para realizar a edição de um Material
	 */
	public boolean edit(Material material) {
		Material m1 = material;
		try {

			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			PreparedStatement preparedStmt;

			String query = "UPDATE Material SET nome = ?, autor = ?, dataCadastro = ?, descricao = ?, status = ?   WHERE idMaterial = ?";
			preparedStmt = conn.prepareStatement(query);

			preparedStmt.setString(1, m1.getNome());
			preparedStmt.setString(2, m1.getAutor());
			preparedStmt.setDate(3, new Date(m1.getCriacao().getTime()));
			preparedStmt.setString(4, m1.getDescricao());
			preparedStmt.setString(5, m1.getStatus());
			preparedStmt.setInt(6, m1.getId());

			preparedStmt.executeUpdate();
			preparedStmt.close();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	/**
	 * Método para realizar a exclusão de um Material para a camada de Modelo e em
	 * DAO
	 */
	public boolean delete(int id) {
		try {

			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			PreparedStatement preparedStmt;

			String query = "delete from Material where idMaterial = ?";
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, id);

			// executa preparedstatement
			preparedStmt.execute();

			conexao.closeConnection();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	public List<Integer> recuperarIDS() {
		List<Integer> lista = new ArrayList<Integer>();
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			String query = "SELECT idMaterial FROM Material";

			Statement st;
			st = conn.createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("idMaterial");
				lista.add(id);
			}
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
