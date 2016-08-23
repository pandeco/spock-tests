package br.org.eldorado.cliente.service


import br.org.eldorado.cliente.model.Cliente
import br.org.eldorado.cliente.dao.ClienteDAO
import br.org.eldorado.cliente.service.ClienteService
import spock.lang.Specification

class ClienteServiceSpec extends Specification {

	def "test that service getById delegates to DAO"() {
		given: "a service with a mocked DAO"
		Cliente client = new Cliente(id:1,nome:"Fulano",email:"fulano@eldorado.org.br",salvo:false)

		ClienteDAO dao = Stub(ClienteDAO)
		ClienteService service = new ClienteService(clienteDAO:dao)

		dao.getById(1) >> client
		
		when: "I get a client by ID"
		def returnedClient = service.getById(1)

		then: "I get the client"
		returnedClient == client
	}

	def "test that service delegates to dao"() {
		given: "a mocked DAO and a service"
		ClienteDAO dao = Mock()
		ClienteService service = new ClienteService(clienteDAO: dao)

		when: "I save client"
		service.save(new Cliente(nome: "Marta"))

		then: "method save in DAO should have been invoked with client"
		1 * dao.save( { it.nome == "Marta" })
	}


}
