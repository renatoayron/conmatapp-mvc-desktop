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
import com.conmat.model.Professor;

/**
 * Classe de persistência de Professores no banco
 * 
 * @author usuario
 *
 */
public class ProfessorDAO {

	/**
	 * Realizar a função de listar todas as tuplas criadas em Professor
	 */
	public void list() {
		try {

			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			Statement st;

			String query = "SELECT * FROM Professor";
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int matricula = rs.getInt("matricula");
				String nomeProf = rs.getString("nomeProf");
				String turma = rs.getString("turma");
				Date nascProf = rs.getDate("nascProf");

				// print the results
				System.out.format("%s - %s - %s - %s\n", matricula, nomeProf, turma, nascProf);
			}

			st.close();
		} catch (SQLException e) {
			System.out.println("Ocorreu uma Exceção! Não foi possível recuperar a lista de Professores!");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Realizar a função de retorno de uma tupla específica de Professor
	 */
	public Professor get(int id) {
		Professor professor = null;
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			PreparedStatement preparedStmt;
			Statement st;

			String query = "SELECT * FROM Professor WHERE matricula = ?";
			st = conn.createStatement();

			preparedStmt = conn.prepareStatement(query);

			preparedStmt.setInt(1, id);

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int matricula = rs.getInt("matricula");
				String nomeProf = rs.getString("nomeProf");
				float salario = rs.getFloat("salario");
				Date nascProf = rs.getDate("nascProf");

				// print the results
				System.out.format("%s - %s - %s - %s\n", matricula, nomeProf, salario, nascProf);

				professor = new Professor(nomeProf, salario, nascProf);
			}

			st.close();
			conexao.closeConnection();
			return professor;
		} catch (SQLException e) {
			System.out.println("Ocorreu uma Exceção! Não foi possível recuperar o Aluno!");
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Método para realizar a inserção de um Professor na camada de Modelo e
	 * persistir os dados em DAO
	 * 
	 */
	public boolean insert(Professor professor) {
		Professor p1 = (Professor) professor;

//		if (conexao.isConnected() && conexao.getConnection() != null) {
//		} else {
//		}
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			PreparedStatement preparedStmt;

			String query = " insert into Professor (`nomeProf`, `salario`, `nascProf`, `idUsuario`) values (?, ?, ?, ?)";

			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, p1.getNomeProf());
			preparedStmt.setFloat(2, p1.getSalario());
			preparedStmt.setDate(3, new Date(p1.getNascProf().getTime()));
			preparedStmt.setInt(4, p1.getId());

			preparedStmt.execute();

			conexao.closeConnection();
			System.out.println("Professor inserido com SUCESSO!");
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	/**
	 * Método para realizar a edição de um Professor para a camada de Modelo e
	 * persistir em DAO
	 */
	public boolean edit(Professor professor) {
		Professor p1 = (Professor) professor;
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			PreparedStatement preparedStmt;

			String query = "UPDATE Professor SET nomeProf = ?, salario = ?, nascProf = ?, idUsuario = ? WHERE matricula = ?";
			preparedStmt = conn.prepareStatement(query);

			preparedStmt.setString(1, p1.getNomeProf());
			preparedStmt.setFloat(2, p1.getSalario());
			preparedStmt.setDate(3, new Date(p1.getNascProf().getTime()));
			preparedStmt.setInt(4, p1.getId());
			preparedStmt.setInt(5, p1.getMatricula());

			preparedStmt.executeUpdate();
			preparedStmt.close();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	/**
	 * Método para realizar a exclusão de um Professor para a camada de Modelo e em
	 * DAO
	 */
	public boolean delete(int matricula) {
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			PreparedStatement preparedStmt;

			String query = "delete from Professor where matricula = ?";
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, matricula);

			// execute the preparedstatement
			preparedStmt.execute();

			conexao.closeConnection();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
	
	public List<Integer> recuperarMatriculas() {
		List<Integer> lista = new ArrayList<Integer>();
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			String query = "SELECT matricula FROM Professor";

			Statement st;
			st = conn.createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("matricula");
				lista.add(id);
			}
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
