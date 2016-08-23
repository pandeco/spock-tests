package br.org.eldorado.cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.eldorado.cliente.dao.ClienteDAO;
import br.org.eldorado.cliente.model.Cliente;

@Service
public class ClienteService {

	@Autowired
	ClienteDAO clienteDAO;

	public Cliente save(Cliente cliente) {
		return clienteDAO.save(cliente);
	}

	public Cliente getById(Integer id) {
		return clienteDAO.getById(id);
	}
}

