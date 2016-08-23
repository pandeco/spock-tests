package br.org.eldorado.cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.eldorado.cliente.dao.ClienteDAO;
import br.org.eldorado.cliente.model.Cliente;

@Service
public class ClienteService implements ServiceManager<Cliente> {

	@Autowired
	ClienteDAO clienteDAO;

	public void save(Cliente cliente) {
		
		System.out.println("Trata cliente " + cliente.getNome());
		clienteDAO.save();
	}
}

