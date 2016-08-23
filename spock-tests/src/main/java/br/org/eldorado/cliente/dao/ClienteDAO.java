package br.org.eldorado.cliente.dao;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.org.eldorado.cliente.model.Cliente;

@Repository
public class ClienteDAO {
	private Set<Cliente> clientes;

	public Cliente save(Cliente cliente) {
		cliente.setSalvo(true);
		System.out.println("Cliente salvo com sucesso");
		return cliente;
	}

	public Cliente getById(Integer id) {
		System.out.println("Busca cliente por ID");
		return new Cliente();
	}

	public Set<Cliente> findByFirstName(String name) {
		return clientes.stream()
				.filter(c -> c.getNome().startsWith(name))
				.collect(Collectors.toSet());
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

}
