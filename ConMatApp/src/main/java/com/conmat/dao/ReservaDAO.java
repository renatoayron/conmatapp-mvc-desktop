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
import com.conmat.model.Reserva;

/**
 * Classe de persistência de Reservas no banco
 * 
 * @author usuario
 *
 */
public class ReservaDAO {

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

			String query = "SELECT * FROM Reserva";
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int idReserva = rs.getInt("idReserva");
				Date dataReserva = rs.getDate("dataReserva");
				int matProf = rs.getInt("matProf");

				// printa os resultados
				System.out.format("%s - %s - %s\n", idReserva, dataReserva, matProf);
			}

			st.close();
		} catch (SQLException e) {
			System.out.println("Ocorreu uma Exceção! Não foi possível recuperar a lista de Reservas!");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Realizar a função de retorno de uma tupla específica de Emprestimo
	 * 
	 * @param id identificação da Reserva 
	 */
	public Reserva get(int id) {
		Reserva reserva = null;
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			PreparedStatement preparedStmt;
			Statement st;

			String query = "SELECT * FROM Reserva WHERE idReserva = ?";
			st = conn.createStatement();

			preparedStmt = conn.prepareStatement(query);

			preparedStmt.setInt(1, id);

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int idReserva = rs.getInt("idReserva");
				Date dataReserva = rs.getDate("dataReserva");
				int matProf = rs.getInt("matProf");

				// printa os resultados
				System.out.format("%s - %s - %s - %s\n", idReserva, dataReserva, matProf);
			}

			st.close();
			conexao.closeConnection();
			return reserva;
		} catch (SQLException e) {
			System.out.println("Ocorreu uma Exceção! Não foi possível recuperar o Reserva!");
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Método para realizar a inserção de um Emprestimo
	 * 
	 * @param reserva
	 * @param professor
	 */
	public boolean insert(Reserva reserva, Professor professor) {
		Reserva r1 = reserva;
		Professor p1 = professor;
//		if (conexao.isConnected() && conexao.getConnection() != null) {
//		} else {
//		}
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			PreparedStatement preparedStmt;

			String query = " insert into Reserva (`dataReserva`, `matProf`) values (?, ?)";

			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setDate(1, new Date(r1.getData().getTime()));
			preparedStmt.setInt(2, p1.getId());

			preparedStmt.execute();

			conexao.closeConnection();
			System.out.println("Reserva realizada com SUCESSO!");
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	/**
	 * Método para realizar a edição de um Reserva
	 * 
	 * @param reserva
	 */
	public boolean edit(Reserva reserva) {
		Reserva r1 = reserva;
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			PreparedStatement preparedStmt;

			String query = "UPDATE Reserva SET dataReserva = ? WHERE idReserva = ?";
			preparedStmt = conn.prepareStatement(query);

			preparedStmt.setDate(1, new Date(r1.getData().getTime()));

			preparedStmt.executeUpdate();
			preparedStmt.close();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	/**
	 * Método para realizar a exclusão de um Reserva
	 * 
	 * @param id
	 */
	public boolean delete(int id) {
		try {
			Conexao conexao = new Conexao();
			Connection conn = conexao.getConnection();

			PreparedStatement preparedStmt;

			String query = "delete from Reserva where idReserva = ?";
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

			String query = "SELECT idReserva FROM Reserva";

			Statement st;
			st = conn.createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("idReserva");
				lista.add(id);
			}
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
