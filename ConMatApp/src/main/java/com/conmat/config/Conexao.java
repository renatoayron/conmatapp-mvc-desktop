package com.conmat.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe para estabelecer a conexão com o banco de dados
 * 
 * @author Renato Ayron
 *
 */
public class Conexao {

	// parâmetros para url do banco de dados
//	private String host = "localhost"; // servidor local
//	private String port = "3306"; // porta padrão
//	private String db = "materiaisdb"; // nome da base de dados
	private String user = "root"; // substituir caso tenha mudado, o padrão é 'root'
	private String password = "123456"; // substituir pela senha do MySQL da máquina local

	// variável para o gerenciamento de conexão com o banco
	private Connection conn = null;
//	private Statement statement = null;

	// driver e url do banco de dados
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//	private final String DATABASE_URL = "jdbc:mysql://[(host=" + host + ",port=" + port + ")/" + db
//			+ "?useTimezone=true&serverTimezone=UTC&useSSL=false";

	private final String DATABASE_URL = "jdbc:mysql://localhost:3306/materiaisdb?useTimezone=true&serverTimezone=UTC";
//	return DriverManager.getConnection("jdbc:mysql://localhost:3306/fj21", "root", "root");
	
	/**
	 * Construtor da classe que estabelece uma conexão com o banco automaticamente
	 */
	public Conexao() {
		estabelecerConexao();
	}

	/**
	 * Estabelece uma conexão com o banco
	 */
	public void estabelecerConexao() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DATABASE_URL, user, password);
//			statement = conn.createStatement();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} catch (ClassNotFoundException classNotFoundException) {
			classNotFoundException.printStackTrace();
		}
	}

	/**
	 * Retorna a conexão se já estiver sido estabelecida corretamente
	 * 
	 * @return conexão
	 */
	public Connection getConnection() {
		if (conn == null) {
			estabelecerConexao();
			if (conn != null && isConnected()) {
				return conn;
			} else {
				return null;
			}
		} else if (isConnected()) {
			return conn;
		}
		return null;
	}

	/**
	 * Verificar se a conexão está estabelecida
	 * 
	 * @return true ou false
	 */
	public boolean isConnected() {
		if (conn == null) {
			return false;
		} else {
			try {
				if (conn.isValid(0)) {
					return true;
				}
			} catch (SQLException e) {
				conn = null;
				return false;
			}
		}
		return false;
	}

	/**
	 * Fechar a conexão com o banco
	 */
	public void closeConnection() {
		if (!isConnected()) {
			System.out.println("Conexão não estabelecida!");
		} else {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
