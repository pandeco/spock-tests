package br.org.eldorado.cliente.dao;

import br.org.eldorado.cliente.model.Cliente;

public interface ClienteDAO {
	
	public Cliente save(Cliente cliente);
	
	public Cliente getById(Integer id);
}
