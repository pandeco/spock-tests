package br.org.eldorado.cliente.dao;

import org.springframework.stereotype.Repository;

@Repository
public class ClienteDAOImpl implements ClienteDAO {

	@Override
	public void save() {
		System.out.println("Cliente salvo com sucesso");
	}

}
