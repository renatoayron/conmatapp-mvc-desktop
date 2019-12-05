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
import com.conmat.model.Aluno;
import com.conmat.model.Emprestimo;

/**
 * Classe de persistência de Emprestimos no banco
 * 
 * @author usuario
 *
 */
public class EmprestimoDAO {

//	Calendar calendar = Calendar.getInstance();
//	Date startDate = new Date(calendar.getTime().getTime());

	/**
	 * Realizar a função de listar todas as tuplas criadas em Emprestimo
	 */
	public void list() {
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();
			Statement st;
			
			String query = "SELECT * FROM Emprestimo";
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int idEmprestimo = rs.getInt("idEmprestimo");
				Date dataEmprestimo = rs.getDate("dataEmprestimo");
				Date prazoEntrega = rs.getDate("prazoEntrega");
				int matAluno = rs.getInt("matAluno");

				// printa os resultados
				System.out.format("%s - %s - %s - %s\n", idEmprestimo, dataEmprestimo, prazoEntrega, matAluno);
			}

			st.close();
		} catch (SQLException e) {
			System.out.println("Ocorreu uma Exceção! Não foi possível recuperar a lista de Empréstimos!");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Realizar a função de retorno de uma tupla específica de Emprestimo
	 * 
	 * @param id
	 */
	public Emprestimo get(int id) {
		Emprestimo emprestimo = null;
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();
			
			PreparedStatement preparedStmt;
			Statement st;
			
			String query = "SELECT * FROM Emprestimo WHERE idEmprestimo = ?";
			st = conn.createStatement();

			preparedStmt = conn.prepareStatement(query);

			preparedStmt.setInt(1, id);

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int idEmprestimo = rs.getInt("idEmprestimo");
				Date dataEmprestimo = rs.getDate("dataEmprestimo");
				Date prazoEntrega = rs.getDate("prazoEntrega");
				int matAluno = rs.getInt("matAluno");

				// printa os resultados
				System.out.format("%s - %s - %s - %s\n", idEmprestimo, dataEmprestimo, prazoEntrega, matAluno);
			}

			st.close();
			conexao.closeConnection();
			return emprestimo;
		} catch (SQLException e) {
			System.out.println("Ocorreu uma Exceção! Não foi possível recuperar o Emprestimo!");
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Método para realizar a inserção de um Emprestimo
	 * @param emprestimo
	 * @param aluno
	 */
	public boolean insert(Emprestimo emprestimo, Aluno aluno) {
		Emprestimo e1 = emprestimo;
		Aluno a1 = aluno;
		
//		if (conexao.isConnected() && conexao.getConnection() != null) {
//		} else {
//		}
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();
			
			PreparedStatement preparedStmt;
			
			String query = " insert into Emprestimo (`dataEmprestimo`, `prazoEntrega`, `matAluno`) values (?, ?, ?)";
			
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setDate(1, new Date(e1.getData().getTime()));
			preparedStmt.setDate(2, new Date(e1.getPrazo().getTime()));
			preparedStmt.setInt(3, a1.getId());

			preparedStmt.execute();

			conexao.closeConnection();
			System.out.println("Emprestimo realizado com SUCESSO!");
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	/**
	 * Método para realizar a edição de um Emprestimo
	 * @param emprestimo
	 */
	public boolean edit(Emprestimo emprestimo) {
		Emprestimo e1 = emprestimo;
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();
			
			PreparedStatement preparedStmt;
			
			String query = "UPDATE Emprestimo SET dataEmprestimo = ?, prazoEntrega = ? WHERE idEmprestimo = ?";
			preparedStmt = conn.prepareStatement(query);

			preparedStmt.setDate(1, new Date(e1.getData().getTime()));
			preparedStmt.setDate(2, new Date(e1.getPrazo().getTime()));

			preparedStmt.executeUpdate();
			preparedStmt.close();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	/**
	 * Método para realizar a exclusão de um Emprestimo
	 * @param id
	 */
	public boolean delete(int id) {
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();
			
			PreparedStatement preparedStmt;
			
			String query = "delete from Emprestimo where idEmprestimo = ?";
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

			String query = "SELECT idEmprestimo FROM Emprestimo";

			Statement st;
			st = conn.createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("idEmprestimo");
				lista.add(id);
			}
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
