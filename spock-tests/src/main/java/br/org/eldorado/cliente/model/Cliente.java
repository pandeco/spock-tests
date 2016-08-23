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
}
