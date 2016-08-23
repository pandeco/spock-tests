package br.org.eldorado.cliente.model;

public class Cliente {
	
	private Integer id;
	private String nome;
	private String email;
	private boolean salvo;
	
	public Cliente() {
		super();
		this.salvo = false;
	}
	
	public boolean isSalvo() {
		return salvo;
	}

	public void setSalvo(boolean salvo) {
		this.salvo = salvo;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Cliente cliente = (Cliente) o;

		if (id != null ? !id.equals(cliente.id) : cliente.id != null) return false;
		if (nome != null ? !nome.equals(cliente.nome) : cliente.nome != null) return false;
		return email != null ? email.equals(cliente.email) : cliente.email == null;

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (nome != null ? nome.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		return result;
	}
}
