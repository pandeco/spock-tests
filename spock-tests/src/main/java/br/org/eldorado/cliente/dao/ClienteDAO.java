package br.org.eldorado.cliente.dao;

import org.springframework.stereotype.Repository;

import br.org.eldorado.cliente.model.Cliente;

@Repository
public class ClienteDAO {

	public Cliente save(Cliente cliente) {
		cliente.setSalvo(true);
		System.out.println("Cliente salvo com sucesso");
		return cliente;
	}

	public Cliente getById(Integer id) {
		System.out.println("Busca cliente por ID");
		return new Cliente();
	}

}
