package com.conmat.model;

/**
 * A classe Usuario implementa os getters e setters (camada Model)
 * 
 * @author Renato Ayron
 *
 */
public class Usuario {

	private int id;
	private String email;
	private String user;
	private String password;

	/**
	 * 
	 */
	public Usuario() {
	}

	/**
	 * Contrustor da classe Usuario
	 * 
	 * @param email
	 * @param user
	 * @param password
	 */
	public Usuario(String email, String user, String password) {
		super();
		this.email = email;
		this.user = user;
		this.password = password;
	}

	/**
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * 
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Identificação do Usuário = ");
		builder.append(id + "\n");
		builder.append("Usuário\n");
		builder.append("Email = ");
		builder.append(email + "\n");
		builder.append("Nome de usuário = ");
		builder.append(user + "\n");
		builder.append("Senha = <");
		builder.append(password + ">\n");
		return builder.toString();
	}

}
