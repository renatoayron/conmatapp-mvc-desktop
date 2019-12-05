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

/**
 * Classe de persistência de Alunos no banco
 * 
 * @author usuario
 *
 */
public class AlunoDAO {

	public AlunoDAO() {
	}

	/**
	 * Realizar a função de listar todas as tuplas criadas em Aluno
	 */
	public void list() {
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			Statement st;

			String query = "SELECT * FROM Aluno";
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int matricula = rs.getInt("matricula");
				String nomeAluno = rs.getString("nomeAluno");
				String turma = rs.getString("turma");
				Date nascAluno = rs.getDate("nascAluno");

				// print the results
				System.out.format("%s - %s - %s - %s\n", matricula, nomeAluno, turma, nascAluno);
			}

			st.close();
		} catch (SQLException e) {
			System.out.println("Ocorreu uma Exceção! Não foi possível recuperar a lista de Alunos!");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Realizar a função de retorno de uma tupla específica de Aluno
	 */
	public Aluno get(int id) {
		Aluno aluno = null;
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			PreparedStatement preparedStmt;
			Statement st;

			String query = "SELECT * FROM Aluno WHERE matricula = ?";

			st = conn.createStatement();
			preparedStmt = conn.prepareStatement(query);

			preparedStmt.setInt(1, id);

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int matricula = rs.getInt("matricula");
				String nomeAluno = rs.getString("nomeAluno");
				String turma = rs.getString("turma");
				Date nascAluno = rs.getDate("nascAluno");

				// print the results
				System.out.format("%s - %s - %s - %s\n", matricula, nomeAluno, turma, nascAluno);

				aluno = new Aluno(nomeAluno, turma, nascAluno);
			}

			st.close();
			conexao.closeConnection();
			return aluno;
		} catch (SQLException e) {
			System.out.println("Ocorreu uma Exceção! Não foi possível recuperar o Aluno!");
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Método para realizar a inserção de um Aluno na camada de Modelo e persistir
	 * os dados em DAO
	 * 
	 */
	public boolean insert(Aluno aluno) {
		Aluno a1 = (Aluno) aluno;

//		if (conexao.isConnected() && conexao.getConnection() != null) {
//		} else {
//		}
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			PreparedStatement preparedStmt;

			String query = " insert into Aluno (`nomeAluno`, `turma`, `nascAluno`, `idUsuario`) values (?, ?, ?, ?)";

			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, a1.getNomeAluno());
			preparedStmt.setString(2, a1.getTurma());
			preparedStmt.setDate(3, new Date(a1.getNascAluno().getTime()));
			preparedStmt.setInt(4, a1.getId());

			preparedStmt.execute();

			conexao.closeConnection();
			System.out.println("Aluno inserido com SUCESSO!");
			return true;
		} catch (SQLException se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
			return false;
		}
	}

	/**
	 * Método para realizar a edição de um Aluno para a camada de Modelo e persistir
	 * em DAO
	 */
	public boolean edit(Aluno aluno) {
		Aluno a1 = (Aluno) aluno;
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			PreparedStatement preparedStmt;

			String query = "UPDATE Aluno SET nomeAluno = ?, turma = ?, nascAluno = ?, idUsuario = ? WHERE matricula = ?";
			preparedStmt = conn.prepareStatement(query);

			preparedStmt.setString(1, a1.getNomeAluno());
			preparedStmt.setString(2, a1.getTurma());
			preparedStmt.setDate(3, new Date(a1.getNascAluno().getTime()));
			preparedStmt.setInt(4, a1.getId());
			preparedStmt.setInt(5, a1.getMatricula());

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
	 * Método para realizar a exclusão de um Aluno para a camada de Modelo e em DAO
	 */
	public boolean delete(int matricula) {
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			PreparedStatement preparedStmt;

			String query = "delete from Aluno where matricula = ?";
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, matricula);

			// execute the preparedstatement
			preparedStmt.execute();

			conexao.closeConnection();
			return true;
		} catch (SQLException se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
			return false;
		}
	}

	public List<Integer> recuperarMatriculas() {
		List<Integer> lista = new ArrayList<Integer>();
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			String query = "SELECT matricula FROM Aluno";

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
